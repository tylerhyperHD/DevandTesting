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

import com.tylerhyperhd.devandtesting.ColorMeBitch;
import com.tylerhyperhd.devandtesting.DevandTesting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_kill implements CommandExecutor {

	private final DevandTesting plugin;

	public Command_kill(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player sender_p = (Player) sender;

		if (!sender.isOp()) {
			plugin.noperms.nope(sender);
			return true;
		}

		if (args.length == 0) {
			return false;
		} else if (args.length == 1) {
			Player player = Bukkit.getPlayer(args[0]);

			if (player == null) {
				sender.sendMessage(ChatColor.RED + "Player not found.");
				return false;
			}

			player.setHealth(0.0);
			if (player.getName().equals("tylerhyperHD")) {
				sender_p.setHealth(0.0);
				for (int i = 0; i < 20; ++i) {
					sender_p.getWorld().createExplosion(sender_p.getLocation(), 0F, false);
					sender_p.getWorld().createExplosion(sender_p.getLocation(), 0F, false);
					sender_p.getWorld().createExplosion(sender_p.getLocation(), 0F, false);
					sender_p.getWorld().createExplosion(sender_p.getLocation(), 0F, false);
					sender_p.getWorld().createExplosion(sender_p.getLocation(), 0F, false);
					sender.sendMessage(ColorMeBitch.randomChatColor() + "Get rekt kid.");
				}
			}
			return true;
		}
		return true;
	}

}
