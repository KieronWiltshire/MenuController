package io.teamelite.brushes;

import io.teamelite.brushes.commands.Voxel;
import io.teamelite.brushes.events.InventoryClick;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		if(Bukkit.getServer().getPluginManager().getPlugin("VoxelSniper") == null) {
			getLogger().log(Level.SEVERE, "VoxelSniper was not found on the server!");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
		getCommand("voxel").setExecutor(new Voxel());
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new InventoryClick(), this);
	}
	
	public static String prefix() {
		String prefix = ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "[" + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Team" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Elite" + ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "]";
		return prefix;
	}
}
		