/**
 * All insane branch commands are not under MIT license and can be freely used.
 */
package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.tylerhyperhd.devandtesting.DevandTesting;
import com.tylerhyperhd.devandtesting.PermType;

import net.minecraft.server.v1_13_R2.Explosion;

public class Command_blowup implements CommandExecutor {

	private final DevandTesting plugin;

	public Command_blowup(DevandTesting plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (plugin.getExtensions().hasNoPermsTo(PermType.INSANE, sender)) {
			return plugin.getPermMsg().nope(sender);
		}
		
		if (args.length != 1) {
			return false;
		}
		
		Player player = Bukkit.getPlayer(args[0]);
		if (player == null) {
			sender.sendMessage(ChatColor.RED + "Player not found!");
			return true;
		}
		Location loc = player.getLocation();
		
		player.setVelocity(player.getVelocity().clone().add(new Vector(0, 100, 0)));
		Explosion explosion = new Explosion(((CraftWorld) loc.getWorld()).getHandle(),
				((CraftEntity) player).getHandle(), loc.getX(), loc.getY(), loc.getZ(), 5F, true, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		explosion.a();
		explosion.a(true);
		loc.getWorld().createExplosion(loc, 0F, false);
		
		player.setHealth(0.0);
		
		return true;
	}
}
