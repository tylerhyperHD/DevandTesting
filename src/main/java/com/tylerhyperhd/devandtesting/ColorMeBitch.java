/**
 * This code is by Camzie99 and is excluded from this plugin's MIT license
 */

package com.tylerhyperhd.devandtesting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class ColorMeBitch {

	private static DevandTesting plugin;

	public ColorMeBitch(DevandTesting plugin) {
		ColorMeBitch.plugin = plugin;
	}

	public static HashMap<Player, PermissionAttachment> attachments = new HashMap<>();

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

	public static void attachPlayer(Player player) {
		attachments.put(player, player.addAttachment(plugin));
	}

	public static void addPermission(Player player, String permission) {
		if (!attachments.containsKey(player)) {
			attachPlayer(player);
		}
		PermissionAttachment attach = attachments.get(player);
		attach.setPermission(permission, true);
	}

	public static void removePermission(Player player, String permission) {
		if (!attachments.containsKey(player)) {
			attachPlayer(player);
		}
		PermissionAttachment attach = attachments.get(player);
		attach.setPermission(permission, false);
	}
}
