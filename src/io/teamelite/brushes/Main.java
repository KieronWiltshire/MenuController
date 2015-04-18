package io.teamelite.brushes;

import io.teamelite.brushes.commands.Voxel;
import io.teamelite.brushes.events.InventoryClick;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @name 		TEBrushes
 * @author 		Liam Reffell and Kieron Wiltshire
 * @contact 	http://www.mcteamelite.com/
 * @license 	MIT License
 * @description
 * 				The plugin requires Java 1.6 or higher and depends on the VoxelSniper
 * 				Bukkit plugin. It allows a user to open up an inventory interface and
 * 				select their desired VoxelSniper brush.
 */
public class Main extends JavaPlugin {

	/**
	 * This method is called once the plugin has been enabled
	 */
	public void onEnable() {
		getCommand("voxel").setExecutor(new Voxel());
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new InventoryClick(), this);
	}
	
	public static String prefix() {
		String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Team" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Elite" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "]";
		return prefix;
	}
}
		