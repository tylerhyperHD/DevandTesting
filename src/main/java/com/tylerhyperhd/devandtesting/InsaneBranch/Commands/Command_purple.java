/**
 * All insane branch commands are not under MIT license and can be freely used.
 */

package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

// Original command made by Camzie99. RIP Camzie.
public class Command_purple implements CommandExecutor {
    
	public ItemStack enchantAll(ItemStack type) {
		for (Enchantment ench : Enchantment.values()) {
			if (ench.equals(Enchantment.LOOT_BONUS_MOBS) || ench.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
				continue;
			}
			type.addUnsafeEnchantment(ench, 32767);
		}
		return type;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
			if (!(sender instanceof Player)) {
				return false;
			}
			if (!sender.hasPermission("devandtesting.insane")) {
				Player sender_p = Bukkit.getPlayer(sender.getName());
				sender_p.sendMessage(ChatColor.RED
						+ "Only the wise may use this command.\nNo permissions for the people who aren't purple.");
				sender_p.setHealth(0.0);
				return true;
			}
			if (args.length == 0) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					PlayerInventory inv = player.getInventory();
					ItemStack CamWool = new ItemStack(Material.PURPLE_WOOL, 1);
					enchantAll(CamWool);
					ItemMeta meta = CamWool.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
					List<String> lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
							ChatColor.BLUE + "you from all possible harm." });
					meta.setLore(lore);
					CamWool.setItemMeta(meta);
					World world = player.getWorld();
					Location loc = player.getLocation();
					inv.setHelmet(CamWool);
					world.strikeLightningEffect(loc);
				}
				for (Player player : Bukkit.getOnlinePlayers()) {
					World world = player.getWorld();
					Location loc = player.getLocation();
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
					Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Gracing the world with purple!");
					world.strikeLightningEffect(loc);
				}
				for (Player player : Bukkit.getOnlinePlayers()) {
					PlayerInventory inv = player.getInventory();
					ItemStack CamBow = new ItemStack(Material.BOW, 1);
					enchantAll(CamBow);
					ItemMeta meta = CamBow.getItemMeta();
					meta.setDisplayName(ChatColor.DARK_AQUA + "The Purple Shot");
					List<String> lore = Arrays.asList(new String[] { ChatColor.BLUE + "Legend has it, this bow",
							ChatColor.BLUE + "can only shoot purple arrows!" });
					meta.setLore(lore);
					CamBow.setItemMeta(meta);
					inv.addItem(CamBow);
					ItemStack CamSword = new ItemStack(Material.GOLDEN_SWORD, 1);
					enchantAll(CamSword);
					ItemMeta sword = CamSword.getItemMeta();
					sword.setDisplayName(ChatColor.DARK_GREEN + "The Purple Blade");
					List<String> a = Arrays.asList(new String[] { ChatColor.BLUE + "The purple has the power",
							ChatColor.BLUE + "to wield this legendary blade!" });
					sword.setLore(a);
					CamSword.setItemMeta(sword);
					inv.addItem(CamSword);
					ItemStack CamArrow = new ItemStack(Material.ARROW, 1);
					enchantAll(CamArrow);
					ItemMeta arrow = CamArrow.getItemMeta();
					arrow.setDisplayName(ChatColor.DARK_PURPLE + "Purple Arrow");
					List<String> b = Arrays.asList(new String[] { ChatColor.BLUE + "This arrow has a mysterious",
							ChatColor.BLUE + "purple aura around it..." });
					arrow.setLore(b);
					CamArrow.setItemMeta(arrow);
					inv.addItem(CamArrow);
					ItemStack CamChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
					enchantAll(CamChest);
					LeatherArmorMeta chest = (LeatherArmorMeta) CamChest.getItemMeta();
					chest.setDisplayName(ChatColor.YELLOW + "Purple Chestplate");
					List<String> c = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
							ChatColor.BLUE + "you from all possible harm." });
					chest.setLore(c);
					chest.setColor(Color.fromRGB(125, 20, 240));
					CamChest.setItemMeta(chest);
					inv.setChestplate(CamChest);
					ItemStack CamLegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
					enchantAll(CamLegs);
					LeatherArmorMeta legs = (LeatherArmorMeta) CamLegs.getItemMeta();
					legs.setDisplayName(ChatColor.YELLOW + "Purple Leggings");
					List<String> d = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
							ChatColor.BLUE + "you from all possible harm." });
					legs.setLore(d);
					legs.setColor(Color.fromRGB(125, 20, 240));
					CamLegs.setItemMeta(legs);
					inv.setLeggings(CamLegs);
					ItemStack CamBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
					enchantAll(CamBoots);
					LeatherArmorMeta boots = (LeatherArmorMeta) CamBoots.getItemMeta();
					boots.setDisplayName(ChatColor.YELLOW + "Purple Boots");
					List<String> e = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
							ChatColor.BLUE + "you from all possible harm." });
					boots.setLore(e);
					boots.setColor(Color.fromRGB(125, 20, 240));
					CamBoots.setItemMeta(boots);
					inv.setBoots(CamBoots);
				}
			}
			return true;
	}

}
