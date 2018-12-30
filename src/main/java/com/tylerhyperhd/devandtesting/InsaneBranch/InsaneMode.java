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
package com.tylerhyperhd.devandtesting.InsaneBranch;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_blowup;
import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_purple;

public class InsaneMode {
	// Private init to allow static disable tasks method
	private static InsaneMode insane;
	private final DevandTesting plugin;
	public PurpleCalmer pcalmer;
	public boolean initialized;
	private boolean gameruleChanged;

	public InsaneMode(DevandTesting plugin) {
		this.plugin = plugin;
		InsaneMode.insane = this;
	}
	
	// This method will never be used, so we aren't using it here
	@SuppressWarnings("unused")
	private InsaneMode(DevandTesting plugin, PurpleCalmer pcalmer) {
		this.plugin = plugin;
	}

	
// TODO: Might implement this if I need to in the future.	
//	public static InsaneMode getInstance() {
//		if (insane.initialized) {
//			return insane;
//		}
//		else {
//			return null;
//		}
//	}
	
	/**
	 * Initializes all insane commands from the listener.
	 */
	public void initializeInsaneMode() {
		this.pcalmer = new PurpleCalmer(this);
		plugin.getCommand("purple").setExecutor(new Command_purple(plugin, this));
		plugin.getCommand("blowup").setExecutor(new Command_blowup(plugin));
		plugin.getServer().getPluginManager().registerEvents(new InsaneChaosCalmer(this), plugin);
		for (World world : Bukkit.getWorlds()) {
			if (world.getGameRuleValue(GameRule.DO_ENTITY_DROPS)) {
				world.setGameRule(GameRule.DO_ENTITY_DROPS, false);
				plugin.getLogger()
						.warning(world.getName() + " had entity drops on. For your safety, this has been turned off.");
				gameruleChanged = true;
			}
		}
		initialized = true;
	}

	public static void runDisableTasks() {
		if (insane.initialized) {
			if (insane.gameruleChanged) {
				for (World world : Bukkit.getWorlds()) {
					world.setGameRule(GameRule.DO_ENTITY_DROPS, true);
					insane.plugin.getLogger().warning(
							"Since we had entity drops off and you had it on previously, they have been switched back on.");
				}
			}

			for (Player player : Bukkit.getOnlinePlayers()) {
				for (ItemStack purplestuff : insane.pcalmer.getPurpleStuff()) {
					if (player.getInventory().contains(purplestuff)) {
						// Get rid of the purple stuff on restart to remove server insanity
						player.getInventory().remove(purplestuff);
					}
				}
			}
		}
	}

}
