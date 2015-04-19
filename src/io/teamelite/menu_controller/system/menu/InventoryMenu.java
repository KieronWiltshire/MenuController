package io.teamelite.menu_controller.system.menu;

import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;
import java.util.Map;

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
public final class InventoryMenu implements Listener {

    // Instance properties
    private Inventory inventory;
    private HashMap<Integer, MenuItem> items;

    /**
     * MenuInventory constructor
     *
     * @param holder The holder of the inventory
     */
    public InventoryMenu(InventoryHolder holder, String title) {
        this.inventory = Bukkit.createInventory(holder, InventoryType.CHEST, title);
        this.items = new HashMap<Integer, MenuItem>();
    }

    /**
     * Get the inventory
     *
     * @return The Inventory instance
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Add a MenuItem to the inventory
     *
     * @param slot The inventory slot of the item
     * @param item The item to add to the inventory menu
     */
    protected void addItem(int slot, MenuItem item) {
        this.items.put(slot, item);

        // Add the item to the inventory instance
        for (Map.Entry<Integer, MenuItem> entry : this.items.entrySet()) {
            this.getInventory().setItem(entry.getKey(), entry.getValue().getItem());
        }
    }

    /**
     * Add a MenuItem to the inventory
     *
     * @param item The item to add to the inventory menu
     */
    protected void addItem(MenuItem item) {
        for(int i = 0; i < inventory.getSize(); i++) {
            if (!this.items.containsKey(i)) {
                this.addItem(i, item);
                return;
            }
        }
    }

    /**
     * Remove an item from the inventory
     *
     * @param slot The item slot of which to remove
     */
    protected void removeItem(int slot) {
        if (this.items.containsKey(slot)) {
            this.items.remove(slot);

            // Remove it from the Inventory instance itself
            // TODO
        }
    }

    /**
     * Remove an item from the inventory
     *
     * @param item The item to remove
     */
    protected void removeItem(MenuItem item) {
        if (this.items.containsValue(item)) {
            for (Map.Entry<Integer, MenuItem> entry : this.items.entrySet()) {
                if (entry.getValue().equals(item)) {
                    this.removeItem(entry.getKey());
                }
            }
        }
    }

    /**
     * Get all of the menu items
     *
     * @return A list of all of the MenuItem instances
     */
    protected ImmutableList<MenuItem> getMenuItems() {
        return ImmutableList.copyOf(this.items.values());
    }

    @EventHandler
    private void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().equals(this.inventory)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory().equals(this.inventory)) {
            if (this.items.containsKey(e.getSlot())) {
                this.items.get(e.getSlot()).onItemSelect();
            }
        }
    }

}
