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
public class ItemLoader {

    /**
     * ItemLoader constructor
     */
    private ItemLoader() { /* private constructor to prevent developer access */ }

    // A HashMap to store the player's custom menus
    private static List<MenuItem> items = new ArrayList<MenuItem>();


}
