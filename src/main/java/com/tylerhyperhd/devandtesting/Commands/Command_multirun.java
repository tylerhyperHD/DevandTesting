/**
 * This command is excluded from the MIT license due to it's wide usage
 */
package com.tylerhyperhd.devandtesting.Commands;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.DevandTesting;

public class Command_multirun implements CommandExecutor {

	private final DevandTesting plugin;

	public Command_multirun(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		List<String> OVERLORDS = plugin.configs.getOverlords();

		if (!OVERLORDS.contains(sender.getName())) {
			plugin.noperms.nope(sender);
			return true;
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
