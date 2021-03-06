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
package com.tylerhyperhd.devandtesting.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.ConfigExe;
import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.PermType;

public class Command_admin extends PermsManager {

	/**
	 * Constructs and enables the admin command.
	 * 
	 * @param iMgr The instance manager for the command.
	 */
	public Command_admin(InstanceManager iMgr) {
		super(iMgr);
	}

	/**
	 * 
	 * @param sender The sender executing the command.
	 * @param cmd The command being executed.
	 * @param string The string associated with the command.
	 * @param args The arguments associated with the command.
	 * @return True if the command executed successfully, false if the command didn't execute correctly.
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player sender_p = super.getInstanceMgr().playerSenderFix(sender);
		ConfigExe configu = super.getInstanceMgr().getConfigs().getMainConfig();
		FileConfiguration configs = configu.getConfig();

		if (configs.getBoolean(sender_p.getUniqueId().toString() + ".inTempAdmin")) {
			configs.set(sender_p.getUniqueId().toString() + ".inTempAdmin", false);
			configu.saveConfig();
			sender.sendMessage(
					ChatColor.GOLD + "You are now in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
			sender_p.setGameMode(GameMode.SURVIVAL);
			super.getInstanceMgr().getLogger().info(ChatColor.GOLD + sender.getName() + " just went into "
					+ ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
			super.getInstanceMgr().getLogger()
					.info(ChatColor.GOLD + "Admin command is disabled for them now since it was temp admin.");
			sender.sendMessage("Your gamemode has been updated.");
		} else if (super.getInstanceMgr().hasNoPermsTo(PermType.ADMIN, sender)) {
			return super.nope(sender);
		}

		if (args.length == 0) {
			if (sender_p.getGameMode().equals(GameMode.SPECTATOR)) {
				if (super.getInstanceMgr().hasNoPermsTo(PermType.ADMIN, sender)) {
					return super.nope(sender);
				}
				sender.sendMessage(ChatColor.GOLD + "You were put in " + ChatColor.RED + "ADMIN" + ChatColor.GOLD
						+ " mode because of being in spectator mode.");
				// Have to be in play mode to do spectator mode, sooo it turns back to admin
				// mode
				configs.set(sender_p.getUniqueId().toString() + ".inAdmin", true);
				configu.saveConfig();
				sender.sendMessage(
						ChatColor.GOLD + "You are now in " + ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode");
				sender_p.setGameMode(GameMode.CREATIVE);
				super.getInstanceMgr().getLogger().info(ChatColor.GOLD + sender.getName() + " just went into "
						+ ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode");
				sender.sendMessage("Your gamemode has been updated.");
				return true;
			} else if (!(configs.getBoolean(sender_p.getUniqueId().toString() + ".inAdmin"))) {
				if (super.getInstanceMgr().hasNoPermsTo(PermType.ADMIN, sender)) {
					return super.nope(sender);
				}
				configs.set(sender_p.getUniqueId().toString() + ".inAdmin", true);
				configu.saveConfig();
				sender.sendMessage(
						ChatColor.GOLD + "You are now in " + ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode");
				sender_p.setGameMode(GameMode.CREATIVE);
				super.getInstanceMgr().getLogger().info(ChatColor.GOLD + sender.getName() + " just went into "
						+ ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode");
				sender.sendMessage("Your gamemode has been updated.");
				return true;
			} else {
				if (super.getInstanceMgr().hasNoPermsTo(PermType.ADMIN, sender)) {
					return super.nope(sender);
				}
				configs.set(sender_p.getUniqueId().toString() + ".inAdmin", false);
				configu.saveConfig();
				sender.sendMessage(
						ChatColor.GOLD + "You are now in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
				sender_p.setGameMode(GameMode.SURVIVAL);
				super.getInstanceMgr().getLogger().info(ChatColor.GOLD + sender.getName() + " just went into "
						+ ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
				sender.sendMessage("Your gamemode has been updated.");
				return true;
			}

		} else if (args.length > 1) { // Admin support
			if (super.getInstanceMgr().hasNoPermsTo(PermType.ADMIN_OTHERS, sender)) {
				return super.nope(sender);
			}

			Player player = Bukkit.getPlayer(args[0]);

			if (player == null) {
				sender.sendMessage(ChatColor.RED + "Player not found/invalid arguments.");
				return false;
			}
			if (args[1].equalsIgnoreCase("admin")) {
				configs.set(player.getUniqueId().toString() + ".inTempAdmin", true);
				configu.saveConfig();
				player.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "ADMIN" + ChatColor.GOLD
						+ " mode temporarily");
				player.sendMessage(ChatColor.GOLD
						+ "This mode can be removed when you logout or you can use the command /admin to get out of it.");
				player.setGameMode(GameMode.CREATIVE);
				super.getInstanceMgr().getLogger().info(ChatColor.GOLD + player.getName() + " just went into "
						+ ChatColor.RED + "ADMIN" + ChatColor.GOLD + " mode temporarily by " + sender.getName());
				player.sendMessage("Your gamemode has been updated.");

			} else if (args[1].equalsIgnoreCase("play")) {
				configs.set(player.getUniqueId().toString() + ".inTempAdmin", false);
				configu.saveConfig();
				player.sendMessage(
						ChatColor.GOLD + "You are now in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode");
				player.setGameMode(GameMode.SURVIVAL);
				super.getInstanceMgr().getLogger().info(ChatColor.GOLD + player.getName() + " just went into "
						+ ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode temporarily by " + sender.getName());
				player.sendMessage("Your gamemode has been updated.");
			}
		}

		return true;
	}

}
