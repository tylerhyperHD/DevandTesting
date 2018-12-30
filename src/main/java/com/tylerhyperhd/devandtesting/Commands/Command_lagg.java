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

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;

public class Command_lagg implements CommandExecutor {

	private final DevandTesting plugin;

	public Command_lagg(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player sender_p = (Player) sender;

		if (args.length == 0) {
			sender.sendMessage(ChatColor.GREEN + "Running DevandTesting v" + DevandTesting.version);
			return false;
		}

		if (args.length == 1) {
			if (plugin.getExtensions().hasNoPermsTo(PermType.ADMIN, sender)) {
				return plugin.getPermMsg().nope(sender);
			}
			// Separate the if statement to prevent permissions from not working

			if (args[0].equalsIgnoreCase("clear")) { // Clear all entities to remove lag
				int count = 0;
				for (Entity entity : sender_p.getWorld().getEntities()) {
					if (!(entity instanceof Player)) {
						entity.remove();
						count++;
					}
				}
				sender.sendMessage(ChatColor.RED + "Removed " + count + " entities!");
				return true;
			} else if (args[0].equalsIgnoreCase("kill")) {

			}

		}
		return false;
	}
}
