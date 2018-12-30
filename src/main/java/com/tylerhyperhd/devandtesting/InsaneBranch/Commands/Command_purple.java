/**
 * All insane branch commands are not under MIT license and can be freely used.
 */

package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;
import com.tylerhyperhd.devandtesting.InsaneBranch.InsaneMode;

// Original command made by Camzie99. RIP Camzie.
public class Command_purple implements CommandExecutor {

	private final DevandTesting plugin;
	private final InsaneMode insane;

	public Command_purple(DevandTesting plugin, InsaneMode insane) {
		this.plugin = plugin;
		this.insane = insane;
	}

	public static ItemStack enchantAll(ItemStack type) {
		for (Enchantment ench : Enchantment.values()) {
			// Fixes unsafe enchantment crash issue
			if (!ench.equals(Enchantment.LOOT_BONUS_MOBS) || !ench.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
				type.addUnsafeEnchantment(ench, 32767);
			}
		}
		return type;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		if (plugin.getExtensions().hasNoPermsTo(PermType.INSANE, sender)) {
			Player sender_p = Bukkit.getPlayer(sender.getName());
			sender_p.sendMessage(ChatColor.RED
					+ "Only the wise may use this command.\nNo permissions for the people who aren't purple.");
			sender_p.setHealth(0.0);
			return true;
		}
		if (args.length == 0) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				PlayerInventory inv = player.getInventory();
				ItemStack CamWool = insane.pcalmer.getCamWool();
				World world = player.getWorld();
				Location loc = player.getLocation();
				inv.setHelmet(CamWool);
				world.strikeLightningEffect(loc);
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				World world = player.getWorld();
				Location loc = player.getLocation();
				// Made this code less redundant
				for (int i = 0; i <= 8; i++) {
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
				}
				world.strikeLightningEffect(loc);
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				PlayerInventory inv = player.getInventory();
				ItemStack CamBow = insane.pcalmer.getCamBow();
				inv.addItem(CamBow);
				ItemStack CamSword = insane.pcalmer.getCamSword();
				inv.addItem(CamSword);
				ItemStack CamArrow = insane.pcalmer.getCamArrow();
				inv.addItem(CamArrow);
				ItemStack CamChest = insane.pcalmer.getCamChestplate();
				inv.setChestplate(CamChest);
				ItemStack CamLegs = insane.pcalmer.getCamLeggings();
				inv.setLeggings(CamLegs);
				ItemStack CamBoots = insane.pcalmer.getCamBoots();
				inv.setBoots(CamBoots);
			}
		}
		return true;
	}

}
