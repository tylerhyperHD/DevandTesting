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
import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_blowup;
import com.tylerhyperhd.devandtesting.InsaneBranch.Commands.Command_purple;

public class InsaneMode {
	private InstanceManager iMgr;
	private PurpleCalmer pcalmer;
	public boolean initialized;
	private boolean gameruleChanged;
	private boolean invChanged;
	
	/**
	 * 
	 * 
	 * @param iMgr
	 */
	public InsaneMode(InstanceManager iMgr) {
		this.iMgr = iMgr;
		initializeInsaneMode();
	}

	/**
	 * Gets the purple calmer class to generate purple stuff.
	 * 
	 * @return Purple Calmer method
	 */
	public PurpleCalmer getPurpleStuff() {
		return pcalmer;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean hasInvChanged() {
		return this.invChanged;
	}

	/**
	 * 
	 * 
	 * @param invChanged
	 */
	private void setInvChanged(boolean invChanged) {
		this.invChanged = invChanged;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean isInitialized() {
		return this.initialized;
	}

	/**
	 * 
	 * 
	 * @param initialized
	 */
	private void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean hasGameruleChanged() {
		return this.gameruleChanged;
	}

	/**
	 * 
	 * 
	 * @param gameruleChanged
	 */
	private void setGameRuleChanged(boolean gameruleChanged) {
		this.gameruleChanged = gameruleChanged;
	}

	/**
	 * Initializes all insane commands from the listener.
	 */
	private void initializeInsaneMode() {
		this.pcalmer = new PurpleCalmer();
		iMgr.getPlugin().getCommand("purple").setExecutor(new Command_purple(this.iMgr, this));
		iMgr.getPlugin().getCommand("blowup").setExecutor(new Command_blowup(this.iMgr));
		iMgr.getPlugin().getServer().getPluginManager().registerEvents(new InsaneChaosCalmer(this),
				this.iMgr.getPlugin());
		for (World world : Bukkit.getWorlds()) {
			if (world.getGameRuleValue(GameRule.DO_MOB_LOOT)) {
				world.setGameRule(GameRule.DO_MOB_LOOT, false);
				iMgr.getLogger()
						.warning(world.getName() + " had entity drops on. For your safety, this has been turned off.");
				this.setGameRuleChanged(true);
			}
			// Not using else if due to us wanting to find both of these
			if (!(world.getGameRuleValue(GameRule.KEEP_INVENTORY))) {
				world.setGameRule(GameRule.KEEP_INVENTORY, true);
				iMgr.getLogger().warning(
						"Keeping inventory was set to true in world " + world.getName() + " to prevent issues.");
				this.setInvChanged(true);
			}
		}
		this.setInitialized(true);
	}

	/**
	 * 
	 * 
	 */
	public void runDisableTasks() {
		if (this.isInitialized()) {
			if (this.hasGameruleChanged()) {
				for (World world : Bukkit.getWorlds()) {
					world.setGameRule(GameRule.DO_MOB_LOOT, true);
				}
				this.iMgr.getLogger().warning(
						"Since we had entity drops off and you had it on previously, they have been switched back on.");
			}
			if (this.hasInvChanged()) {
				for (World world : Bukkit.getWorlds()) {
					world.setGameRule(GameRule.KEEP_INVENTORY, false);
				}
				this.iMgr.getLogger().info("Keep inventory has been fixed now.");
			}

			for (Player player : Bukkit.getOnlinePlayers()) {
				for (ItemStack purplestuff : this.getPurpleStuff().getPurpleStuff()) {
					if (player.getInventory().contains(purplestuff)) {
						// Get rid of the purple stuff on restart to remove server insanity
						player.getInventory().remove(purplestuff);
					}
				}
			}
		}
	}

}
