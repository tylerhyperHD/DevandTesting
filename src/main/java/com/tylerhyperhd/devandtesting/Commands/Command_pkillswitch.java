package com.tylerhyperhd.devandtesting.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.tylerhyperhd.devandtesting.DevandTesting;

public class Command_pkillswitch implements CommandExecutor {

    private final DevandTesting dplugin;

    public Command_pkillswitch(DevandTesting plugin) {
        this.dplugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
    	
    	PluginManager dswitch = Bukkit.getServer().getPluginManager();
    	    	
        if (!dplugin.configs.getOverlords().contains(sender.getName())) {
            dplugin.noperms.nope(sender);
            return true;
        }

        if (args.length == 0) {
        	
        	Bukkit.getServer().broadcastMessage(ChatColor.RED + "All plugins except one are being disabled!!!!");
        	
        	for (Plugin plugin : dswitch.getPlugins()) {
        		if(!(plugin.equals(dplugin))) {
        			Bukkit.getServer().getLogger().warning("KILLSWITCH ACTIVATED: Disabling plugin" + plugin.getName());
        			dswitch.disablePlugin(plugin);
        		}
        	}
        	
        	
            return true;
        }
        else if (args.length == 1) {
        	if (args[0].equalsIgnoreCase("everything")) {
            	Bukkit.getServer().broadcastMessage(ChatColor.RED + "All plugins are being disabled!!!!");
            	
            	for (Plugin plugin : dswitch.getPlugins()) {
            		Bukkit.getServer().getLogger().warning("MEGA KILLSWITCH ACTIVATED: Disabling plugin" + plugin.getName());
            		dswitch.disablePlugin(plugin);
            	}
        	}
        }
        
        return true;
    }

}
