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
package com.tylerhyperhd.devandtesting;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColorUtil {

	// &1-&9 Colors
	public static List<String> DarkBlueChat = new ArrayList<String>();
	public static List<String> DarkGreenChat = new ArrayList<String>();
	public static List<String> DarkAquaChat = new ArrayList<String>();
	public static List<String> RedChat = new ArrayList<String>();
	public static List<String> DarkPurpleChat = new ArrayList<String>();
	public static List<String> GoldChat = new ArrayList<String>();
	public static List<String> GrayChat = new ArrayList<String>();
	public static List<String> DarkGrayChat = new ArrayList<String>();
	public static List<String> BlueChat = new ArrayList<String>();

	// &a-&f Colors
	public static List<String> GreenChat = new ArrayList<String>();
	public static List<String> AquaChat = new ArrayList<String>();
	public static List<String> DarkRedChat = new ArrayList<String>();
	public static List<String> LightPurpleChat = new ArrayList<String>();
	public static List<String> YellowChat = new ArrayList<String>();
	public static List<String> WhiteChat = new ArrayList<String>();

	/**
	 * Removes all chat colors from a sender
	 * 
	 * @param sender The sender that will no longer have colors
	 */
	public static void removeAll(CommandSender sender) {
		GoldChat.remove(sender.getName());
		GrayChat.remove(sender.getName());
		DarkGrayChat.remove(sender.getName());
		BlueChat.remove(sender.getName());
		GreenChat.remove(sender.getName());
		AquaChat.remove(sender.getName());
		RedChat.remove(sender.getName());
		LightPurpleChat.remove(sender.getName());
		YellowChat.remove(sender.getName());
		WhiteChat.remove(sender.getName());
		DarkBlueChat.remove(sender.getName());
		DarkGreenChat.remove(sender.getName());
		DarkAquaChat.remove(sender.getName());
		DarkRedChat.remove(sender.getName());
		DarkPurpleChat.remove(sender.getName());
	}

	/**
	 * Gets the color that the player has
	 * 
	 * @param player The player being searched
	 * @return The color that the player has
	 */
	public static String getColor(Player player) {
		if (ColorUtil.DarkBlueChat.contains(player.getName())) {
			return ChatColor.DARK_BLUE + "Dark Blue";
		} else if (ColorUtil.DarkGreenChat.contains(player.getName())) {
			return ChatColor.DARK_GREEN + "Dark Green";
		} else if (ColorUtil.DarkAquaChat.contains(player.getName())) {
			return ChatColor.DARK_AQUA + "Dark Aqua";
		} else if (ColorUtil.DarkRedChat.contains(player.getName())) {
			return ChatColor.DARK_RED + "Dark Red";
		} else if (ColorUtil.DarkPurpleChat.contains(player.getName())) {
			return ChatColor.DARK_PURPLE + "Dark Purple";
		} else if (ColorUtil.GoldChat.contains(player.getName())) {
			return ChatColor.GOLD + "Gold";
		} else if (ColorUtil.GrayChat.contains(player.getName())) {
			return ChatColor.GRAY + "Gray";
		} else if (ColorUtil.DarkGrayChat.contains(player.getName())) {
			return ChatColor.DARK_GRAY + "Dark Gray";
		} else if (ColorUtil.BlueChat.contains(player.getName())) {
			return ChatColor.BLUE + "Blue";
		} else if (ColorUtil.GreenChat.contains(player.getName())) {
			return ChatColor.GREEN + "Green";
		} else if (ColorUtil.AquaChat.contains(player.getName())) {
			return ChatColor.AQUA + "Aqua";
		} else if (ColorUtil.RedChat.contains(player.getName())) {
			return ChatColor.RED + "Red";
		} else if (ColorUtil.LightPurpleChat.contains(player.getName())) {
			return ChatColor.LIGHT_PURPLE + "Light Purple";
		} else if (ColorUtil.YellowChat.contains(player.getName())) {
			return ChatColor.YELLOW + "Yellow";
		} else if (ColorUtil.WhiteChat.contains(player.getName())) {
			return ChatColor.RESET + "White";
		} else {
			return "None";
		}
	}
}
