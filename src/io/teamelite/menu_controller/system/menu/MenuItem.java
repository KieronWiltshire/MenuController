package io.teamelite.menu_controller.system.menu;

import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

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
public abstract class MenuItem implements Cloneable {

    // Instance properties
    private transient InventoryMenu menu;
    private String name;
    private ItemStack item;

    /**
     * MenuItem constructor
     *
     * @param menu The inventory menu
     * @param item The item to represent the menu option
     */
    protected MenuItem(InventoryMenu menu, String name, ItemStack item) {
        this.menu = menu;
        this.name = name;
        this.setItem(item);
    }

    /**
     * Set the menu
     *
     * @param menu The menu which will contain the item
     */
    public void setMenu(InventoryMenu menu) {
        if (this.menu != null) {
            for(Iterator<MenuItem> iter = this.menu.getMenuItems().iterator(); iter.hasNext();) {
                this.getMenu().removeItem(this);
            }
        }
        this.menu = menu;
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
     * Set the name
     *
     * @param name The name of the menu option
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name
     *
     * @return The name of the menu option
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the item
     *
     * @param item The item to represent the menu option
     */
    public void setItem(ItemStack item) {
        if (item == null) {
            this.getMenu().removeItem(this);
        } else {
            this.item = item;
            this.getMenu().addItem(this);
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
