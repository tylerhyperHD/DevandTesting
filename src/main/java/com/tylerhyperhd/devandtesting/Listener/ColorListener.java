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
package com.tylerhyperhd.devandtesting.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.tylerhyperhd.devandtesting.ColorUtil;
import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;

public class ColorListener implements Listener {

	private final DevandTesting plugin;

	public ColorListener(DevandTesting plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		if (plugin.getExtensions().doesHavePermsTo(PermType.COLOR, event.getPlayer())) {
			event.getPlayer()
					.sendMessage(ChatColor.GOLD + "Your Chat Color is set to " + ColorUtil.getColor(event.getPlayer()));
		}
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();

		// &1-&9 Colors
		if (ColorUtil.DarkBlueChat.contains(player.getName())) {
			message = ChatColor.DARK_BLUE + message;
		} else if (ColorUtil.DarkGreenChat.contains(player.getName())) {
			message = ChatColor.DARK_GREEN + message;
		} else if (ColorUtil.DarkAquaChat.contains(player.getName())) {
			message = ChatColor.DARK_AQUA + message;
		} else if (ColorUtil.DarkRedChat.contains(player.getName())) {
			message = ChatColor.DARK_RED + message;
		} else if (ColorUtil.DarkPurpleChat.contains(player.getName())) {
			message = ChatColor.DARK_PURPLE + message;
		} else if (ColorUtil.GoldChat.contains(player.getName())) {
			message = ChatColor.GOLD + message;
		} else if (ColorUtil.GrayChat.contains(player.getName())) {
			message = ChatColor.GRAY + message;
		} else if (ColorUtil.DarkGrayChat.contains(player.getName())) {
			message = ChatColor.DARK_GRAY + message;
		} else if (ColorUtil.BlueChat.contains(player.getName())) {
			message = ChatColor.BLUE + message;
		} // &a-&f Colors
		else if (ColorUtil.GreenChat.contains(player.getName())) {
			message = ChatColor.GREEN + message;
		} else if (ColorUtil.AquaChat.contains(player.getName())) {
			message = ChatColor.AQUA + message;
		} else if (ColorUtil.RedChat.contains(player.getName())) {
			message = ChatColor.RED + message;
		} else if (ColorUtil.LightPurpleChat.contains(player.getName())) {
			message = ChatColor.LIGHT_PURPLE + message;
		} else if (ColorUtil.YellowChat.contains(player.getName())) {
			message = ChatColor.YELLOW + message;
		} else if (ColorUtil.WhiteChat.contains(player.getName())) {
			message = ChatColor.RESET + message;
		}
		event.setMessage(message);
	}
}
