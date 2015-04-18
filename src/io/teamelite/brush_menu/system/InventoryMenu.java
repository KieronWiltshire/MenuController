package io.teamelite.brush_menu.system;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

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
public class InventoryMenu {

    // Instance properties
    private Inventory inventory;

    /**
     * MenuInventory constructor
     *
     * @param holder The holder of the inventory
     */
    public InventoryMenu(InventoryHolder holder, String title) {
        this.inventory = Bukkit.createInventory(holder, InventoryType.CHEST, title);
    }

    /**
     * Get the inventory
     *
     * @return The Inventory instance
     */
    public Inventory getInventory() {
        return this.inventory;
    }

}
