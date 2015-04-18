package io.teamelite.menu_controller.system.json;

import io.teamelite.menu_controller.system.menu.InventoryMenu;
import io.teamelite.menu_controller.system.menu.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
public class ItemLoader {

    private static ItemLoader instance;

    /**
     * Get the ItemLoader
     *
     * @return The ItemLoader instance
     */
    public static ItemLoader instance() {
        if (instance == null) {
            instance = new ItemLoader();
        }
        return instance;
    }

    // Instance properties
    private List<MenuItem> items;

    /**
     * ItemLoader constructor
     */
    private ItemLoader() { this.items = new ArrayList<MenuItem>(); }


}
