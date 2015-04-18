package io.teamelite.brush_menu.system.menu;

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
    private transient InventoryMenu menu;
    private ItemStack item;

    /**
     * MenuItem constructor
     *
     * @param menu The inventory menu
     * @param item The item to represent the menu option
     */
    protected MenuItem(InventoryMenu menu, ItemStack item) {
        this.menu = menu;
        this.setItem(item);
    }

    /**
     * Get the menu
     *
     * @return The InventoryMenu instance
     */
    public InventoryMenu getMenu() {
        return this.menu;
    }

    /**
     * Set the item
     *
     * @param item The item to represent the menu option
     */
    public void setItem(ItemStack item) {
        if (item == null) {
            this.getInventory().removeItem(this);
        } else {
            this.item = item;
            this.getInventory().addItem(this);
        }
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
