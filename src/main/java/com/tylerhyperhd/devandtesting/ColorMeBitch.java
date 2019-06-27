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

	/**
	 * Colors player chats
	 * 
	 * @param plugin The plugin instance of DevandTesting
	 */
	public ColorMeBitch(DevandTesting plugin) {
		ColorMeBitch.plugin = plugin;
	}

	public static HashMap<Player, PermissionAttachment> attachments = new HashMap<>();

	public static final List<ChatColor> COLORS = Arrays.asList(ChatColor.DARK_BLUE, ChatColor.DARK_GREEN,
			ChatColor.DARK_AQUA, ChatColor.DARK_RED, ChatColor.DARK_PURPLE, ChatColor.GOLD, ChatColor.BLUE,
			ChatColor.GREEN, ChatColor.AQUA, ChatColor.RED, ChatColor.LIGHT_PURPLE, ChatColor.YELLOW);

	public static Random random = new Random();

	/**
	 * Gets a random chat color for the user
	 * 
	 * @return Random chat color
	 */
	public static ChatColor randomChatColor() {
		return COLORS.get(random.nextInt(COLORS.size()));
	}

	/**
	 * Sets the random color in place.
	 * 
	 * @param string The random colors stringified.
	 * @return The random colors stringified.
	 */
	public static String color(String string) {
		string = ChatColor.translateAlternateColorCodes('&', string);
		string = string.replaceAll("&-", randomChatColor().toString());
		return string;
	}

	public static void attachPlayer(Player player) {
		attachments.put(player, player.addAttachment(plugin));
	}

	/**
	 * Adds a permission to a player through Spigot
	 * 
	 * @param player The player the permission is being set to
	 * @param permission The permission being given
	 */
	public static void addPermission(Player player, String permission) {
		if (!attachments.containsKey(player)) {
			attachPlayer(player);
		}
		PermissionAttachment attach = attachments.get(player);
		attach.setPermission(permission, true);
	}

	/**
	 * Removes a permission to a player through Spigot
	 * 
	 * @param player The player the permission is being removed from
	 * @param permission The permission that is being removed
	 */
	public static void removePermission(Player player, String permission) {
		if (!attachments.containsKey(player)) {
			attachPlayer(player);
		}
		PermissionAttachment attach = attachments.get(player);
		attach.setPermission(permission, false);
	}
}
