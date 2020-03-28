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
package com.tylerhyperhd.devandtesting;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tylerhyperhd.devandtesting.Commands.Command_admin;
import com.tylerhyperhd.devandtesting.Commands.Command_clearchat;
import com.tylerhyperhd.devandtesting.Commands.Command_color;
import com.tylerhyperhd.devandtesting.Commands.Command_creative;
import com.tylerhyperhd.devandtesting.Commands.Command_dab;
import com.tylerhyperhd.devandtesting.Commands.Command_gamemode;
import com.tylerhyperhd.devandtesting.Commands.Command_kill;
import com.tylerhyperhd.devandtesting.Commands.Command_lagg;
import com.tylerhyperhd.devandtesting.Commands.Command_multirun;
import com.tylerhyperhd.devandtesting.Commands.Command_pkillswitch;
import com.tylerhyperhd.devandtesting.Commands.Command_spectator;
import com.tylerhyperhd.devandtesting.Commands.Command_survival;
import com.tylerhyperhd.devandtesting.Commands.Command_website;
import com.tylerhyperhd.devandtesting.InsaneBranch.CommandsDisabled;
import com.tylerhyperhd.devandtesting.Listener.ColorListener;
import com.tylerhyperhd.devandtesting.Listener.InsaneListener;
import com.tylerhyperhd.devandtesting.Listener.TestingListener;

public class DevandTesting extends JavaPlugin {
	public static List<String> admin = new ArrayList<String>();
	private GamemodeInventories gminvs;

	// New instance manager
	private InstanceManager iMgr;

	/**
	 * Initializes the plugin before starting
	 */
	@Override
	public void onLoad() {
		this.iMgr = new InstanceManager(this);
		new ColorMeBitch(this);
	}

	/**
	 * Runs onEnable scripts
	 */
	@Override
	public void onEnable() {
		this.iMgr.initializeConfigs();
		/* Ask users to convert to Paper Spigot */
		if (!this.isPresent("com.destroystokyo.paper.util.VersionFetcher") && !this.iMgr.getConfigs().supressingPaper()) {
			this.iMgr.getLogger().info("=====================================");
			this.iMgr.getLogger().info("NOTE: DevandTesting will work on Spigot, yet we suggest you use Paper Spigot.");
			this.iMgr.getLogger().info("=====================================");
		} else {
			this.iMgr.getLogger().info("Using Paper Spigot :)");
		}
		this.iMgr.getLogger().info("DevandTesting helps fix all dev problems!");
		this.iMgr.getLogger().info("Made by tylerhyperHD");

		if (this.iMgr.getVersion().contains("ALPHA")) {
			this.iMgr.getLogger().info("=====================================");
			this.iMgr.getLogger().info("WARNING: DevandTesting is in ALPHA");
			this.iMgr.getLogger().info("Alpha builds are prone to huge issues and instability.");
			this.iMgr.getLogger().info("Please proceed with caution as there is no support for these builds.");
			this.iMgr.getLogger().info("=====================================");
		} else if (this.iMgr.getVersion().contains("BETA")) {
			this.iMgr.getLogger().info("=====================================");
			this.iMgr.getLogger().info("Notice: DevandTesting is in BETA");
			this.iMgr.getLogger().info("There might be issues related to this build not solved.");
			this.iMgr.getLogger().info("Please proceed with caution.");
			this.iMgr.getLogger().info("=====================================");
		}

		// TODO: Fix command aliases the correct way instead of this

		String[] gmexts = { "gm", "egamemode", "gamemode" };
		this.iMgr.registerMultipleCommands(gmexts, new Command_gamemode(this.iMgr));
		this.getCommand("admin").setExecutor(new Command_admin(this.iMgr));
		String[] crexts = { "creative", "gmc", "ecreative" };
		this.iMgr.registerMultipleCommands(crexts, new Command_creative(this.iMgr));
		String[] survexts = { "survival", "gms", "esurvival" };
		this.iMgr.registerMultipleCommands(survexts, new Command_survival(this.iMgr));
		this.getCommand("website").setExecutor(new Command_website(this.iMgr));
		this.getCommand("color").setExecutor(new Command_color(this.iMgr));
		this.getCommand("kill").setExecutor(new Command_kill(this.iMgr));
		this.getCommand("multirun").setExecutor(new Command_multirun(this.iMgr));
		this.getCommand("lagg").setExecutor(new Command_lagg(this.iMgr));
		this.getCommand("dab").setExecutor(new Command_dab(this.iMgr));
		this.getCommand("spectator").setExecutor(new Command_spectator(this.iMgr));
		this.getCommand("pkillswitch").setExecutor(new Command_pkillswitch(this.iMgr));
		String[] ccexts = { "clearchat", "cc" };
		this.iMgr.registerMultipleCommands(ccexts, new Command_clearchat(this.iMgr));

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new TestingListener(this.iMgr), this);
		pm.registerEvents(new ColorListener(this.iMgr), this);

		if (this.iMgr.getConfigs().isInsaneModeEnabled()) {
			this.iMgr.getLogger().warning(
					"Insane mode can be triggered right now. This might cause server chaos if it is toggled, so be careful.");
			pm.registerEvents(new InsaneListener(this.iMgr), this);
		}

		// Register an insane command fixer to help fix dead commands
		String[] multicmd = { "blowup", "purple" };
		this.iMgr.registerMultipleCommands(multicmd, new CommandsDisabled());

		if (pm.isPluginEnabled("GameModeInventories")) {
			this.iMgr.getLogger().info("GameModeInventories detected, loading support classes...");
			gminvs = new GamemodeInventories(this.iMgr);
			gminvs.getRidOfGMStuff();
		} else {
			this.iMgr.getLogger().warning(
					"GameModeInventories not enabled -- this disables admin inventory switch support. Beware.");
		}
	}

	/**
	 * Runs onDisable scripts
	 */
	@Override
	public void onDisable() {
		if (this.iMgr.isInsaneModeInitialized()) {
			this.iMgr.cleanupInsaneMode();
		}
		this.iMgr.getLogger().info("Chill out. I'm disabled.");
		Bukkit.getServer().getScheduler().cancelTasks(this);
	}
	
	/**
	 * Detects if the class is present
	 * 
	 * @param className The name of the class
	 * @return true/false if the class is present
	 */
	private boolean isPresent(String className) {
	    try {
	         Class.forName(className);
	    } catch (ClassNotFoundException e) {
	         return false;
	     }
	    return true;
	}
}
