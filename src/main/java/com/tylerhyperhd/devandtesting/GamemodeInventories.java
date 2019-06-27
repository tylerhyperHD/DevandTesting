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

import org.bukkit.configuration.file.FileConfiguration;

import me.eccentric_nz.gamemodeinventories.GameModeInventories;

public class GamemodeInventories {

	private final InstanceManager iMgr;

	public GamemodeInventories(InstanceManager iMgr) {
		this.iMgr = iMgr;
	}

	public void getRidOfGMStuff() {
		FileConfiguration gminvconfig = GameModeInventories.plugin.getConfig();
		gminvconfig.set("dont_spam_chat", false);
		gminvconfig.set("no_drops", false);
		gminvconfig.set("no_falling_drops", false);
		gminvconfig.set("no_pickups", false);
		gminvconfig.set("remove_potions", true);
		gminvconfig.set("restrict_creative", false);
		gminvconfig.set("save_on_death", false);
		gminvconfig.set("survival_on_world_change", false);
		gminvconfig.set("track_creative_place.enabled", false);
		gminvconfig.set("bypass.inventories", false);
		gminvconfig.set("creative_blacklist", false);
		gminvconfig.set("break_bedrock", true);
		gminvconfig.set("command_blacklist", false);
		gminvconfig.set("restrict_spectator", false);
		gminvconfig.set("bypass.items", false);
		gminvconfig.set("armor", true);
		GameModeInventories.plugin.saveConfig();
		this.iMgr.getLogger().info("DevandTesting prevents editing GMInv configs for a reason. Don't touch them.");
	}
}
