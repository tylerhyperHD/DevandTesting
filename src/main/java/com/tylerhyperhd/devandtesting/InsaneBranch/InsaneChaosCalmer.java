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

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class InsaneChaosCalmer implements Listener {

	private final InsaneMode insane;

	public InsaneChaosCalmer(InsaneMode insane) {
		this.insane = insane;
	}

	/**
	 * This adds insta-kill to the insane mode. It can only be used on mobs.
	 * 
	 * @param event EntityDamageByEntityEvent
	 */
	@EventHandler
	public void onEntityDamageEvent(EntityDamageByEntityEvent event) {
		Entity victim = event.getEntity();
		if (!(victim.getType().equals(EntityType.PLAYER))) {
			event.setCancelled(true);
			victim.setFireTicks(victim.getMaxFireTicks());
			victim.setVelocity(victim.getVelocity().clone().add(new Vector(0, 1000, 0))); // Shoot up in air
			Location loc = victim.getLocation();
			loc.getWorld().createExplosion(loc, 0F, false); // Make explosive noise when it happens
			victim.remove();
		}

	}

	/**
	 * Disables dropping purple items.
	 * 
	 * @param event PlayerDropItemEvent
	 */
	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		ItemStack itemdropped = event.getItemDrop().getItemStack();

		for (ItemStack purplestuff : insane.getPurpleStuff().getPurpleStuff()) {
			if (itemdropped.equals(purplestuff)) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.DARK_RED + "Dropping purple items are prohibited in insane mode.");
			}
		}
	}
}
