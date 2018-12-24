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
package com.tylerhyperhd.devandtesting.Commands;

import com.tylerhyperhd.devandtesting.ConfigExe;
import com.tylerhyperhd.devandtesting.DevandTesting;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;

public class Command_spectator implements CommandExecutor {

    private final DevandTesting plugin;

    public Command_spectator(DevandTesting plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player sender_p = (Player) sender;

        ConfigExe configu = plugin.configs.getMainConfig();
        FileConfiguration configs = configu.getConfig();
        
        if (!sender.hasPermission("devandtesting.admin")) {
            plugin.noperms.nope(sender);
            return true;
        }
        
        if (configs.getBoolean(sender_p.getUniqueId().toString() + ".inAdmin") == true) {
            sender.sendMessage(ChatColor.GOLD + "You must be in " + ChatColor.GREEN + "PLAY" + ChatColor.GOLD + " mode to use this command!");
            return true;
        }
                
        sender_p.setGameMode(GameMode.SPECTATOR);
        return true;
    }

}
