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
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.PermType;

public class InsaneListener extends ListenerController {
	// Get confirm between methods
	private boolean confirm = false;
	// Get player between methods
	private Player player;

	/**
	 * 
	 * 
	 * @param iMgr
	 */
	public InsaneListener(InstanceManager iMgr) {
		super(iMgr);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean getConfirm() {
		return this.confirm;
	}

	/**
	 * 
	 * 
	 * @param confirm
	 */
	private void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	/**
	 * 
	 * 
	 * @param event
	 */
	@EventHandler
	public void onPlayerCommandExecution(PlayerCommandPreprocessEvent event) {
		player = event.getPlayer();

		if (event.getMessage().equals("insane") || event.getMessage().equals("/insane")) {
			event.setCancelled(true);

			if (this.getConfirm()) {
				this.setConfirm(false);
			}

			if (super.getInstanceMgr().hasNoPermsTo(PermType.INSANE, player)) {
				super.nope(player);
			} else {
				player.sendMessage(ChatColor.RED
						+ "[DevandTesting] Insane mode will add additional functions that could break the server. Type 'yes' if you want to continue.");
				this.setConfirm(true);
			}
		}
	}

	/**
	 * 
	 * 
	 * @param event
	 */
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		if (this.getConfirm() && event.getMessage().equalsIgnoreCase("yes")
				&& super.getInstanceMgr().doesHavePermsTo(PermType.INSANE, player)
				&& event.getPlayer().equals(player)) {
			event.setCancelled(true);
			player.sendMessage(
					ChatColor.RED + "Insane mode is loading now. It can only be deactivated through a server restart.");
			super.getInstanceMgr().initializeInsaneMode();
		}
	}
}
