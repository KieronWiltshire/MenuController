package io.teamelite.menu_controller.system.json;

import io.teamelite.menu_controller.system.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

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
public class ItemHandler {

    private static ItemHandler instance;

    /**
     * Get the ItemHandler
     *
     * @return The ItemHandler instance
     */
    public static ItemHandler instance() {
        if (instance == null) {
            instance = new ItemHandler();
        }
        return instance;
    }

    // Instance properties
    private List<MenuItem> items;

    /**
     * ItemHandler constructor
     */
    private ItemHandler() { this.items = new ArrayList<MenuItem>(); }


}
