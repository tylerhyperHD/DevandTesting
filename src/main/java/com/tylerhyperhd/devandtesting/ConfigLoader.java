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

import java.util.List;

public class ConfigLoader {

	private ConfigExe mainconfig;

	/**
	 * Initializes the configs
	 * 
	 * @param iMgr The instance manager for the plugin
	 */
	public ConfigLoader(InstanceManager iMgr) {
		mainconfig = new ConfigExe(iMgr, "config.yml");
		mainconfig.saveDefaultConfig();
	}

	/**
	 * Gets the main config for the plugin
	 * @return The main config
	 */
	public ConfigExe getMainConfig() {
		return mainconfig;
	}
	
	/**
	 * Gets the list of overlords for the plugin
	 * @return List of overlords
	 */
	public List<String> getOverlords() {
		return mainconfig.getConfig().getStringList("Overlords");
	}

	/**
	 * Gets whether or not insane mode is enabled
	 * @return whether or not insane mode is enabled
	 */
	public boolean isInsaneModeEnabled() {
		return mainconfig.getConfig().getBoolean("insaneModeEnabled");
	}
	
	/**
	 * Gets whether or not the user wants to supress paper spigot ads
	 * @return whether or not the user wants to supress paper spigot ads
	 */
	public boolean supressingPaper() {
		return mainconfig.getConfig().getBoolean("supressPaperAds");
	}
}
