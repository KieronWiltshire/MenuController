package io.teamelite.menu_controller;


import io.teamelite.menu_controller.system.MenuManager;
import io.teamelite.menu_controller.system.json.ItemLoader;

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
public class MenuController {

    /**
     * MenuController constructor
     */
    private MenuController() { /* private constructor to prevent developer access */ }

    /**
     * Plugin proxy class
     */
    public static MenuManager getManager() { return MenuManager.instance(); }
    public static ItemLoader getLoader() { return ItemLoader.instance(); }

}
