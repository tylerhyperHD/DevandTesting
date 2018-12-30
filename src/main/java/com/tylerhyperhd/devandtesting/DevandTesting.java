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
import com.tylerhyperhd.devandtesting.Commands.NoPerms;
import com.tylerhyperhd.devandtesting.InsaneBranch.InsaneMode;
import com.tylerhyperhd.devandtesting.Listener.ColorListener;
import com.tylerhyperhd.devandtesting.Listener.InsaneListener;
import com.tylerhyperhd.devandtesting.Listener.TestingListener;

public class DevandTesting extends JavaPlugin {

	public DevandTesting plugin;
	private NoPerms noperms;
	public DevLogger logger;
	public ConfigLoader configs;
	public static String version;
	public static List<String> admin = new ArrayList<String>();
	public CommandExtensions extensions;
	public GamemodeInventories gminvs;
	@SuppressWarnings("unused")
	private ColorMeBitch cmb;

	@Override
	public void onLoad() {
		plugin = this;
		DevandTesting.version = plugin.getDescription().getVersion();
		noperms = new NoPerms();
		logger = new DevLogger(plugin);
		extensions = new CommandExtensions(plugin);
		cmb = new ColorMeBitch(plugin);
	}

	@Override
	public void onEnable() {
		logger.info("DevandTesting helps fix all dev problems!");
		logger.info("Made by tylerhyperHD");

		if (version.contains("ALPHA")) {
			logger.info("=====================================");
			logger.info("WARNING: DevandTesting is in ALPHA");
			logger.info("Alpha builds are prone to huge issues and instability.");
			logger.info("Please proceed with caution as there is no support for these builds.");
			logger.info("=====================================");
		} else if (version.contains("BETA")) {
			logger.info("=====================================");
			logger.info("Notice: DevandTesting is in BETA");
			logger.info("There might be issues related to this build not solved.");
			logger.info("Please proceed with caution.");
			logger.info("=====================================");
		}

		configs = new ConfigLoader(plugin);
		plugin.getCommand("gamemode").setExecutor(new Command_gamemode(plugin));
		plugin.getCommand("admin").setExecutor(new Command_admin(plugin));
		plugin.getCommand("creative").setExecutor(new Command_creative(plugin));
		plugin.getCommand("survival").setExecutor(new Command_survival(plugin));
		plugin.getCommand("website").setExecutor(new Command_website(plugin));
		plugin.getCommand("color").setExecutor(new Command_color(plugin));
		plugin.getCommand("kill").setExecutor(new Command_kill(plugin));
		plugin.getCommand("multirun").setExecutor(new Command_multirun(plugin));
		plugin.getCommand("lagg").setExecutor(new Command_lagg(plugin));
		plugin.getCommand("dab").setExecutor(new Command_dab(plugin));
		plugin.getCommand("spectator").setExecutor(new Command_spectator(plugin));
		plugin.getCommand("pkillswitch").setExecutor(new Command_pkillswitch(plugin));
		plugin.getCommand("clearchat").setExecutor(new Command_clearchat(plugin));

		PluginManager pm = plugin.getServer().getPluginManager();
		pm.registerEvents(new TestingListener(plugin), plugin);
		pm.registerEvents(new ColorListener(plugin), plugin);

		if (configs.isInsaneModeEnabled()) {
			logger.warning(
					"Insane mode can be triggered right now. This might cause server chaos if it is toggled, so be careful.");
			pm.registerEvents(new InsaneListener(plugin), plugin);
		}

		if (pm.isPluginEnabled("GameModeInventories")) {
			logger.info("GameModeInventories detected, loading support classes...");
			gminvs = new GamemodeInventories(plugin);
			gminvs.getRidOfGMStuff();
		} else {
			logger.warning("GameModeInventories not enabled -- this disables admin inventory switch support. Beware.");
		}
	}

	@Override
	public void onDisable() {
		InsaneMode.runDisableTasks();
		logger.info("Chill out. I'm disabled.");
		Bukkit.getServer().getScheduler().cancelTasks(plugin);
	}

	// I know I don't have to create this yet it makes the code look nicer
	public CommandExtensions getExtensions() {
		return extensions;
	}
	
	public NoPerms getPermMsg() {
		return noperms;
	}
}
