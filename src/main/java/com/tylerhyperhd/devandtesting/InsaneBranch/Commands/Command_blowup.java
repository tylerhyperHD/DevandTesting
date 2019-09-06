/**
 * All insane branch commands are not under MIT license and can be freely used.
 */
package com.tylerhyperhd.devandtesting.InsaneBranch.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.tylerhyperhd.devandtesting.InstanceManager;
import com.tylerhyperhd.devandtesting.PermType;
import com.tylerhyperhd.devandtesting.Commands.PermsManager;

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
		/*
		 * Legacy API Explosion 
		 * explosion = new Explosion(((CraftWorld)
		 * loc.getWorld()).getHandle(), ((CraftEntity) player).getHandle(), loc.getX(),
		 * loc.getY(), loc.getZ(), 5F, true, Explosion.Effect.DESTROY);
		 */
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);
		loc.getWorld().createExplosion(loc, 5F, false, false);

		player.setHealth(0.0);

		return true;
	}
}
