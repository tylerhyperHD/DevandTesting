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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;

public class Command_dab implements CommandExecutor {

	private final DevandTesting plugin;

	public Command_dab(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player sender_p = (Player) sender;

		if (plugin.getExtensions().hasNoPermsTo(PermType.ADMIN, sender)) {
			return plugin.getPermMsg().nope(sender);
		}

		sender_p.chat("dab");
		if (Bukkit.getServer().getPlayerExact("tylerhyperHD").isOnline()) {
			Player player = Bukkit.getPlayer("tylerhyperHD");
			player.chat("Die.");
		}
		return true;
	}
}
