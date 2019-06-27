package com.tylerhyperhd.devandtesting.Listener;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.tylerhyperhd.devandtesting.InstanceManager;

public abstract class ListenerController implements Listener {
	private InstanceManager iMgr;

	/**
	 * 
	 * 
	 * @param iMgr
	 */
	public ListenerController(InstanceManager iMgr) {
		this.iMgr = iMgr;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public InstanceManager getInstanceMgr() {
		return this.iMgr;
	}

	/**
	 * 
	 * 
	 * @param player
	 * @return
	 */
	public boolean nope(Player player) {
		player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
		return true;
	}

	/**
	 * 
	 * 
	 * @param sender
	 * @return
	 */
	public boolean nope(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
		return true;
	}
}
