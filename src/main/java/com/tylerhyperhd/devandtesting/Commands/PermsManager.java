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
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.InstanceManager;

public abstract class PermsManager implements CommandExecutor {
	private InstanceManager iMgr;
	
	/**
	 * Constructs the permissions manager.
	 * 
	 * @param iMgr The instance manager for the command.
	 */
	public PermsManager(InstanceManager iMgr) {
		this.iMgr = iMgr;
	}
	
	/**
	 * 
	 * @param sender The sender executing the command.
	 * @param cmd The command being executed.
	 * @param string The string associated with the command.
	 * @param args The arguments associated with the command.
	 * @return True if the command executed successfully, false if the command didn't execute correctly.
	 */
	@Override
	public abstract boolean onCommand(CommandSender sender, Command cmd, String string, String[] args);
	
	/**
	 * Gets the instance manager for the command.
	 * 
	 * @return The instance manager for the command.
	 */
	public InstanceManager getInstanceMgr() {
		return this.iMgr;
	}
	
	/**
	 * Shows when a player doesn't have permission to execute the command.
	 * 
	 * @param player The player that is used for the command.
	 * @return True to stop the command from executing.
	 */
	public boolean nope(Player player) {
		player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
		return true;
	}

	/**
	 * Shows when a sender doesn't have permission to execute the command.
	 * 
	 * @param sender The sender that executes the command.
	 * @return True to stop the command from executing.
	 */
	public boolean nope(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
		return true;
	}

}
