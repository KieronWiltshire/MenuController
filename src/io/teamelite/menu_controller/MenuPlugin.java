package io.teamelite.menu_controller;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author Liam Reffell and Kieron Wiltshire
 * @name MenuController
 * @contact http://www.mcteamelite.com/
 * @license MIT License
 * @description The plugin requires Java 1.6 or higher.
 * It allows a user to open up an inventory interface and
 * select their saved menu options.
 */
public class MenuPlugin extends JavaPlugin implements Listener {

    // Plugin instance
    private static MenuPlugin instance;

    /**
     * Get the MenuPlugin
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

        // Create the 'items' directory if it doesn't already exist
        if (!this.getItemDirectory().exists()) {
            this.getItemDirectory().mkdirs();
        }

        this.registerEvents();
        this.registerCommands();
    }

    /**
     * This method registers the current event listeners
     * being used by this plugin
     */
    private void registerEvents() {
        // No events currently need registering
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    /**
     * This method registers the current command executors
     * being used by this plugin.
     */
    private void registerCommands() {
        // this.getCommand("voxel").setExecutor(new BrushMenu());
    }

    /**
     * Get the items directory
     *
     * @return The File instance of the items directory
     */
    public File getItemDirectory() {
        return new File(this.getDataFolder(), "items");
    }

}
