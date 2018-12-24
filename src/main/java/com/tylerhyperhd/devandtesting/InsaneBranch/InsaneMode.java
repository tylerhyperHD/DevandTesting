package com.tylerhyperhd.devandtesting.InsaneBranch;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_purple;

public class InsaneMode {
	
	private DevandTesting plugin;
	
	public InsaneMode(DevandTesting plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Initializes all insane commands from the listener.
	 */
	public void initializeInsaneMode() {
		plugin.getCommand("purple").setExecutor(new Command_purple());
	}
	
}
