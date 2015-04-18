package io.teamelite.brush_menu.system;

import org.bukkit.inventory.ItemStack;

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
public abstract class MenuItem {

    // Instance properties
    private ItemStack item;

    /**
     * MenuItem constructor
     *
     * @param item The item to represent the menu option
     */
    protected MenuItem(ItemStack item) {
        this.item = item;
    }

    /**
     * Set the item
     *
     * @param item The item to represent the menu option
     */
    public void setItem(ItemStack item) {
        this.item = item;
    }

    /**
     * Get the item
     *
     * @return The item which represents the menu option
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * This method should be called if the item was selected
     */
    public abstract void onItemSelect();

}
