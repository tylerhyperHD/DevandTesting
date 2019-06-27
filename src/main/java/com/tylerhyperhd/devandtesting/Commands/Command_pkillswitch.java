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
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import com.tylerhyperhd.devandtesting.InstanceManager;

public class Command_pkillswitch extends PermsManager {

	/**
	 * Constructs and enables the pkillswitch command.
	 * 
	 * @param iMgr The instance manager for the command.
	 */
	public Command_pkillswitch(InstanceManager iMgr) {
		super(iMgr);
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
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

		PluginManager dswitch = Bukkit.getServer().getPluginManager();

		if (!super.getInstanceMgr().getConfigs().getOverlords().contains(sender.getName())) {
			return super.nope(sender);
		}

		if (args.length == 0) {

			Bukkit.getServer().broadcastMessage(ChatColor.RED + "All plugins except one are being disabled!!!!");

			for (Plugin plugin : dswitch.getPlugins()) {
				if (!(plugin.equals(super.getInstanceMgr().getPlugin()))) {
					Bukkit.getServer().getLogger().warning("KILLSWITCH ACTIVATED: Disabling plugin" + plugin.getName());
					dswitch.disablePlugin(plugin);
				}
			}

			return true;
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("everything")) {
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "All plugins are being disabled!!!!");

				for (Plugin plugin : dswitch.getPlugins()) {
					Bukkit.getServer().getLogger()
							.warning("MEGA KILLSWITCH ACTIVATED: Disabling plugin" + plugin.getName());
					dswitch.disablePlugin(plugin);
				}
			}
		}

		return true;
	}

}
