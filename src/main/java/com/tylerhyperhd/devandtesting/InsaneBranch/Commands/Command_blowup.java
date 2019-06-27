/**
 * All insane branch commands are not under MIT license and can be freely used.
 */
package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.PermType;
import com.tylerhyperhd.devandtesting.Commands.PermsManager;

import net.minecraft.server.v1_14_R1.Explosion;

public class Command_blowup extends PermsManager {

	/**
	 * 
	 * 
	 * @param iMgr
	 */
	public Command_blowup(InstanceManager iMgr) {
		super(iMgr);
	}

	/**
	 * 
	 * @param sender
	 * @param cmd
	 * @param string
	 * @param args
	 * @return
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (super.getInstanceMgr().hasNoPermsTo(PermType.INSANE, sender)) {
			return super.nope(sender);
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
				((CraftEntity) player).getHandle(), loc.getX(), loc.getY(), loc.getZ(), 5F, true, Explosion.Effect.DESTROY);
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
