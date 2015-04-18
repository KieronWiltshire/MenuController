package io.teamelite.brushes;

import io.teamelite.brushes.commands.Voxel;
import io.teamelite.brushes.events.InventoryClick;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @name 		BrushMenu
 * @author 		Liam Reffell and Kieron Wiltshire
 * @contact 	http://www.mcteamelite.com/
 * @license 	MIT License
 * @description
 * 				The plugin requires Java 1.6 or higher and depends on the VoxelSniper
 * 				Bukkit plugin. It allows a user to open up an inventory interface and
 * 				select their desired VoxelSniper brush.
 */
public class BrushMenu extends JavaPlugin {

	// Plugin instance
	private static BrushMenu instance;

	/**
	 * Get the BrushMenu plugin
	 *
	 * @return The BrushMenu plugin instance
	 */
	public static BrushMenu getPlugin() {
		return instance;
	}

	/**
	 * This method is called once the plugin has been enabled
	 */
	public void onEnable() {
		instance = this;

		this.registerEvents();
		this.registerCommands();
	}

	/**
	 * This method registers the current event listeners
	 * being used by this plugin
	 */
	private void registerEvents() {
		PluginManager manager = Bukkit.getPluginManager();

		manager.registerEvents(new InventoryManager(), this);
	}

	/**
	 * This method registers the current command executors
	 * being used by this plugin.
	 */
	private void registerCommands() {
		this.getCommand("voxel").setExecutor(new Voxel());
	}

}
		