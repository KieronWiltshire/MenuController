package io.teamelite.menu_controller;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @name 		MenuController
 * @author 		Liam Reffell and Kieron Wiltshire
 * @contact 	http://www.mcteamelite.com/
 * @license 	MIT License
 * @description
 * 				The plugin requires Java 1.6 or higher.
 * 				It allows a user to open up an inventory interface and
 * 				select their saved menu options.
 */
public class MenuPlugin extends JavaPlugin {

	// Plugin instance
	private static MenuPlugin instance;

	/**
	 * Get the MenuPlugin plugin
	 *
	 * @return The MenuPlugin plugin instance
	 */
	public static MenuPlugin instance() {
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
		// No events currently need registering
	}

	/**
	 * This method registers the current command executors
	 * being used by this plugin.
	 */
	private void registerCommands() {
		// this.getCommand("voxel").setExecutor(new BrushMenu());
	}

}
