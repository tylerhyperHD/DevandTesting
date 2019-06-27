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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigExe {

	private final String fileName;
	private InstanceManager iMgr;

	private File configFile;
	private FileConfiguration fileConfiguration;

	/**
	 * Initializes the config files
	 * 
	 * @param iMgr The instance manager for the plugin
	 * @param fileName The file name of the config
	 */
	public ConfigExe(InstanceManager iMgr, String fileName) {
		this.iMgr = iMgr;
		
		if (this.iMgr.getPlugin() == null) {
			throw new IllegalArgumentException("plugin cannot be null");
		}
		if (!this.iMgr.getPlugin().isEnabled()) {
			throw new IllegalArgumentException("plugin must be initialized");
		}
		this.fileName = fileName;
		File dataFolder = this.iMgr.getPlugin().getDataFolder();
		if (dataFolder == null) {
			throw new IllegalStateException();
		}
		this.configFile = new File(this.iMgr.getPlugin().getDataFolder(), fileName);
	}

	public void reloadConfig() {
		fileConfiguration = YamlConfiguration.loadConfiguration(configFile);

		InputStream defConfigStream = this.iMgr.getPlugin().getResource(fileName);
		Reader targetReader = new InputStreamReader(defConfigStream);
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(targetReader);
			fileConfiguration.setDefaults(defConfig);
		}
	}

	/**
	 * Gets the configuration associated with the file
	 * 
	 * @return The config file
	 */
	public FileConfiguration getConfig() {
		if (fileConfiguration == null) {
			reloadConfig();
		}
		return fileConfiguration;
	}

	/**
	 * Saves the config file
	 */
	public void saveConfig() {
		if (fileConfiguration == null || configFile == null) {
			return;
		} else {
			try {
				getConfig().save(configFile);
			} catch (IOException ex) {
				this.iMgr.getPlugin().getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
			}
		}
	}

	/**
	 * Saves the default config values
	 */
	public void saveDefaultConfig() {
		if (!configFile.exists()) {
			this.iMgr.getPlugin().saveResource(fileName, false);
		}
	}

}
