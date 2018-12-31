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
package com.tylerhyperhd.devandtesting.InsaneBranch;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_purple;

// This class was made to make the purple inventory vanish on server restart without issues.
public class PurpleCalmer {

	// Makes constructors of these items
	public ItemStack CamWool;
	public ItemStack CamBow;
	public ItemStack CamSword;
	public ItemStack CamArrow;
	public ItemStack CamChest;
	public ItemStack CamLegs;
	public ItemStack CamBoots;

	public PurpleCalmer() {
		this.CamWool = getCamWool();
		this.CamBow = getCamBow();
		this.CamSword = getCamSword();
		this.CamArrow = getCamArrow();
		this.CamChest = getCamChestplate();
		this.CamLegs = getCamLeggings();
		this.CamBoots = getCamBoots();
	}

	public ItemStack getCamWool() {
		ItemStack CamWool = new ItemStack(Material.PURPLE_WOOL, 1);
		Command_purple.enchantAll(CamWool);
		ItemMeta meta = CamWool.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
		List<String> lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
				ChatColor.BLUE + "you from all possible harm." });
		meta.setLore(lore);
		CamWool.setItemMeta(meta);
		return CamWool;
	}

	public ItemStack getCamBow() {
		ItemStack CamBow = new ItemStack(Material.BOW, 1);
		Command_purple.enchantAll(CamBow);
		ItemMeta meta = CamBow.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_AQUA + "The Purple Shot");
		List<String> lore = Arrays.asList(new String[] { ChatColor.BLUE + "Legend has it, this bow",
				ChatColor.BLUE + "can only shoot purple arrows!" });
		meta.setLore(lore);
		CamBow.setItemMeta(meta);
		return CamBow;
	}

	public ItemStack getCamSword() {
		ItemStack CamSword = new ItemStack(Material.GOLDEN_SWORD, 1);
		Command_purple.enchantAll(CamSword);
		ItemMeta sword = CamSword.getItemMeta();
		sword.setDisplayName(ChatColor.DARK_GREEN + "The Purple Blade");
		List<String> a = Arrays.asList(new String[] { ChatColor.BLUE + "The purple has the power",
				ChatColor.BLUE + "to wield this legendary blade!" });
		sword.setLore(a);
		CamSword.setItemMeta(sword);
		return CamSword;
	}

	public ItemStack getCamArrow() {
		ItemStack CamArrow = new ItemStack(Material.ARROW, 1);
		Command_purple.enchantAll(CamArrow);
		ItemMeta arrow = CamArrow.getItemMeta();
		arrow.setDisplayName(ChatColor.DARK_PURPLE + "Purple Arrow");
		List<String> b = Arrays.asList(new String[] { ChatColor.BLUE + "This arrow has a mysterious",
				ChatColor.BLUE + "purple aura around it..." });
		arrow.setLore(b);
		CamArrow.setItemMeta(arrow);
		return CamArrow;
	}

	public ItemStack getCamChestplate() {
		ItemStack CamChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		Command_purple.enchantAll(CamChest);
		LeatherArmorMeta chest = (LeatherArmorMeta) CamChest.getItemMeta();
		chest.setDisplayName(ChatColor.YELLOW + "Purple Chestplate");
		List<String> c = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
				ChatColor.BLUE + "you from all possible harm." });
		chest.setLore(c);
		chest.setColor(Color.fromRGB(125, 20, 240));
		CamChest.setItemMeta(chest);
		return CamChest;
	}

	public ItemStack getCamLeggings() {
		ItemStack CamLegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		Command_purple.enchantAll(CamLegs);
		LeatherArmorMeta legs = (LeatherArmorMeta) CamLegs.getItemMeta();
		legs.setDisplayName(ChatColor.YELLOW + "Purple Leggings");
		List<String> d = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
				ChatColor.BLUE + "you from all possible harm." });
		legs.setLore(d);
		legs.setColor(Color.fromRGB(125, 20, 240));
		CamLegs.setItemMeta(legs);
		return CamLegs;
	}

	public ItemStack getCamBoots() {
		ItemStack CamBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
		Command_purple.enchantAll(CamBoots);
		LeatherArmorMeta boots = (LeatherArmorMeta) CamBoots.getItemMeta();
		boots.setDisplayName(ChatColor.YELLOW + "Purple Boots");
		List<String> e = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect",
				ChatColor.BLUE + "you from all possible harm." });
		boots.setLore(e);
		boots.setColor(Color.fromRGB(125, 20, 240));
		CamBoots.setItemMeta(boots);
		return CamBoots;
	}

	public ItemStack[] getPurpleStuff() {
		ItemStack[] purple = { getCamWool(), getCamBow(), getCamSword(), getCamArrow(), getCamChestplate(),
				getCamLeggings(), getCamBoots() };
		return purple;
	}
}
