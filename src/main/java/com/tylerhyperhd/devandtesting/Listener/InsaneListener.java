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
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.InsaneBranch.InsaneMode;

public class InsaneListener implements Listener {
	
	// Get confirm between methods
	private boolean confirm = false;
	private DevandTesting plugin;
	// Get player between methods
	private Player player;
	
	public InsaneListener(DevandTesting plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerCommandExecution(PlayerCommandPreprocessEvent event) {
		player = event.getPlayer();
		
		if (event.getMessage().equals("insane") || event.getMessage().equals("/insane")) {
			event.setCancelled(true);
			
			if(confirm) {
				confirm = false;
			}
			
			
	        if (!player.hasPermission("devandtesting.insane")) {
	            plugin.noperms.nope(player);
	        }
	        else {
				player.sendMessage(ChatColor.RED + "[DevandTesting] Insane mode will add additional functions that could break the server. Type 'yes' if you want to continue.");
				confirm = true;
	        }
		}
	}
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		if(confirm && event.getMessage().equalsIgnoreCase("yes")
				&& event.getPlayer().hasPermission("devandtesting.insane") && event.getPlayer().equals(player)) {
			player.sendMessage(ChatColor.RED + "Insane mode is loading now. It can only be deactivated through a server restart.");
			InsaneMode imode = new InsaneMode(plugin);
			imode.initializeInsaneMode();
		}
	}
	
}
