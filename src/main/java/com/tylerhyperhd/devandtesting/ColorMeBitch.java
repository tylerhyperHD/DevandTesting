/**
 * This code is by Camzie99 and is excluded from this plugin's MIT license
 */

package com.tylerhyperhd.devandtesting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;

public class ColorMeBitch {

	public static final List<ChatColor> COLORS = Arrays.asList(ChatColor.DARK_BLUE, ChatColor.DARK_GREEN,
			ChatColor.DARK_AQUA, ChatColor.DARK_RED, ChatColor.DARK_PURPLE, ChatColor.GOLD, ChatColor.BLUE,
			ChatColor.GREEN, ChatColor.AQUA, ChatColor.RED, ChatColor.LIGHT_PURPLE, ChatColor.YELLOW);

	public static Random random = new Random();

	public static ChatColor randomChatColor() {
		return COLORS.get(random.nextInt(COLORS.size()));
	}

	public static String color(String string) {
		string = ChatColor.translateAlternateColorCodes('&', string);
		string = string.replaceAll("&-", randomChatColor().toString());
		return string;
	}
}
