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

import com.tylerhyperhd.devandtesting.ColorUtil;
import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;

public class Command_color implements CommandExecutor {

	private final DevandTesting plugin;

	public String PREFIX = ChatColor.GOLD + "[DevandTesting]";

	public Command_color(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

		if (plugin.getExtensions().hasNoPermsTo(PermType.COLOR, sender)) {
			plugin.noperms.nope(sender);
			return true;
		}

		if (args.length == 0) {
			sender.sendMessage(PREFIX + "Colors:");
			sender.sendMessage(ChatColor.DARK_BLUE + "darkblue" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.DARK_GREEN + "darkgreen" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.DARK_AQUA + "darkaqua" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.DARK_RED + "darkred" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.DARK_PURPLE + "darkpurple" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.GOLD + "gold" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.GRAY + "gray" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.DARK_GRAY + "darkgray" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.BLUE + "blue" + ChatColor.RESET + ",");
			sender.sendMessage(PREFIX + "To see more colors, do /color 2");
			sender.sendMessage(PREFIX + "To turn off chat color, do /color off");
			return false;
		} else if (args[0].equals("2")) {
			sender.sendMessage(PREFIX + "Colors:");
			sender.sendMessage(ChatColor.GREEN + "green" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.AQUA + "aqua" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.RED + "red" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "lightpurple" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.YELLOW + "yellow" + ChatColor.RESET + ",");
			sender.sendMessage(ChatColor.WHITE + "white" + ChatColor.RESET + ",");
			sender.sendMessage(PREFIX + "To turn off chat color, do /color off");
			return false;
		} else if (args[0].equals("off")) {
			ColorUtil.removeAll(sender);
			sender.sendMessage(PREFIX + "You have disabled color chat.");
			return true;
		} else if (args[0].equals("darkblue")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkBlueChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkblue.");
			return true;
		} else if (args[0].equals("darkgreen")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkGreenChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkgreen.");
			return true;
		} else if (args[0].equals("darkaqua")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkAquaChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkaqua.");
			return true;
		} else if (args[0].equals("darkred")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkRedChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkred.");
			return true;
		} else if (args[0].equals("darkpurple")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkPurpleChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkpurple.");
			return true;
		} else if (args[0].equals("gold")) {
			ColorUtil.removeAll(sender);
			ColorUtil.GoldChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to gold.");
			return true;
		} else if (args[0].equals("gray")) {
			ColorUtil.removeAll(sender);
			ColorUtil.GrayChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to gray.");
			return true;
		} else if (args[0].equals("darkgray")) {
			ColorUtil.removeAll(sender);
			ColorUtil.DarkGrayChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to darkgray.");
			return true;
		} else if (args[0].equals("blue")) {
			ColorUtil.removeAll(sender);
			ColorUtil.BlueChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to blue.");
			return true;
		} else if (args[0].equals("green")) {
			ColorUtil.removeAll(sender);
			ColorUtil.GreenChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to green.");
			return true;
		} else if (args[0].equals("aqua")) {
			ColorUtil.removeAll(sender);
			ColorUtil.AquaChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to aqua.");
			return true;
		} else if (args[0].equals("red")) {
			ColorUtil.removeAll(sender);
			ColorUtil.RedChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to red.");
			return true;
		} else if (args[0].equals("lightpurple")) {
			ColorUtil.removeAll(sender);
			ColorUtil.LightPurpleChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to lightpurple.");
			return true;
		} else if (args[0].equals("yellow")) {
			ColorUtil.removeAll(sender);
			ColorUtil.YellowChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to yellow.");
			return true;
		} else if (args[0].equals("white")) {
			ColorUtil.removeAll(sender);
			ColorUtil.WhiteChat.add(sender.getName());
			sender.sendMessage(PREFIX + "You have changed your chat color to white.");
			return true;
		}
		return true;

	}

}
