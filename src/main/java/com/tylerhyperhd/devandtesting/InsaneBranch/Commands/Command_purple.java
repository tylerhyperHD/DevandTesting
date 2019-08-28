/**
 * All insane branch commands are not under MIT license and can be freely used.
 */

package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.PermType;
import com.tylerhyperhd.devandtesting.Commands.PermsManager;
import com.tylerhyperhd.devandtesting.InsaneBranch.InsaneMode;

// Original command made by Camzie99. RIP Camzie.
public class Command_purple extends PermsManager {

	private final InsaneMode insane;

	/**
	 * 
	 * 
	 * @param iMgr
	 * @param insane
	 */
	public Command_purple(InstanceManager iMgr, InsaneMode insane) {
		super(iMgr);
		this.insane = insane;
	}

	/**
	 * 
	 * 
	 * @param type
	 * @return
	 */
	public static ItemStack enchantAll(ItemStack type) {
		for (Enchantment ench : Enchantment.values()) {
			// TODO: Figure out why this isn't being added
			if (!ench.equals(Enchantment.LOOT_BONUS_MOBS) || !ench.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
				type.addUnsafeEnchantment(ench, 32767);
			}
		}
		return type;
	}

	/**
	 * 
	 * @param sender
	 * @param cmd
	 * @param string
	 * @param args
	 * @return
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (super.getInstanceMgr().senderIsConsole(sender)) {
			return false;
		}
		if (super.getInstanceMgr().hasNoPermsTo(PermType.INSANE, sender)) {
			Player sender_p = Bukkit.getPlayer(sender.getName());
			sender_p.sendMessage(ChatColor.RED
					+ "Only the wise may use this command.\nNo permissions for the people who aren't purple.");
			sender_p.setHealth(0.0);
			return true;
		}
		if (args.length == 0) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				PlayerInventory inv = player.getInventory();
				World world = player.getWorld();
				Location loc = player.getLocation();
				world.strikeLightningEffect(loc);
				// Made this code less redundant
				for (int i = 0; i <= 8; i++) {
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
				}
				world.strikeLightningEffect(loc);
				ItemStack CamWool = insane.getPurpleStuff().getCamWool();
				ItemStack CamBow = insane.getPurpleStuff().getCamBow();
				ItemStack CamSword = insane.getPurpleStuff().getCamSword();
				ItemStack CamArrow = insane.getPurpleStuff().getCamArrow();
				ItemStack CamChest = insane.getPurpleStuff().getCamChestplate();
				ItemStack CamLegs = insane.getPurpleStuff().getCamLeggings();
				ItemStack CamBoots = insane.getPurpleStuff().getCamBoots();
				ItemStack RoyalTrident = insane.getPurpleStuff().getRoyalTrident();
				inv.setHelmet(CamWool);
				inv.addItem(CamBow);
				inv.addItem(CamSword);
				inv.addItem(CamArrow);
				inv.setChestplate(CamChest);
				inv.setLeggings(CamLegs);
				inv.setBoots(CamBoots);
				inv.addItem(RoyalTrident);
			}
		}
		return true;

	}
}