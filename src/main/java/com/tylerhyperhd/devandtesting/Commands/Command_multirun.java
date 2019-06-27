/**
 * This command is excluded from the MIT license due to it's wide usage
 */
package com.tylerhyperhd.devandtesting.Commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.InstanceManager;

public class Command_multirun extends PermsManager {

	/**
	 * Constructs and enables the multirun command.
	 * 
	 * @param iMgr The instance manager for the command.
	 */
	public Command_multirun(InstanceManager iMgr) {
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
		if (!super.getInstanceMgr().getConfigs().getOverlords().contains(sender.getName())) {
			return super.nope(sender);
		}
		if (args.length < 2) {
			return false;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command must be executed in-game.");
			return true;
		}
		if (Integer.parseInt(args[0]) == 1 || Integer.parseInt(args[0]) == 0) {
			sender.sendMessage(ChatColor.RED
					+ String.format("Why are you trying to run the command %s times?", Integer.parseInt(args[0])));
			return true;
		}
		String baseCommand = StringUtils.join(args, " ", 1, args.length);
		sender.sendMessage(
				ChatColor.BLUE + String.format("Running: %s %s times", baseCommand, Integer.parseInt(args[0])));
		int i = 0;
		do {
			((Player) sender).chat("/" + baseCommand);
			i++;
		} while (i < Integer.parseInt(args[0]));
		return true;
	}
}
