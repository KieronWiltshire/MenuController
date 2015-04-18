package io.teamelite.menu_controller.system;

import com.google.common.base.Optional;
import io.teamelite.menu_controller.MenuController;
import io.teamelite.menu_controller.system.menu.InventoryMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
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
public class MenuManager {

    /**
     * MenuManager constructor
     */
    private MenuManager() { /* private constructor to prevent developer access */ }

    // A HashMap to store the player's custom menus
    private static HashMap<UUID, InventoryMenu> manager = new HashMap<UUID, InventoryMenu>();

    /**
     * Create an InventoryMenu for a player
     *
     * @param player The player you wish to create a menu for
     */
    public static void createMenu(Player player, String title) {
        if (manager.containsKey(player.getUniqueId())) return;

        InventoryMenu menu = new InventoryMenu(player, title);
        Bukkit.getPluginManager().registerEvents(menu, MenuController.getPlugin());

        manager.put(player.getUniqueId(), menu);
    }

    /**
     * Get the menu for a specific player
     *
     * @param player The player you wish to retrieve the menu of
     * @return The InventoryMenu instance
     */
    public static Optional<InventoryMenu> getMenu(Player player) {
        if (manager.containsKey(player.getUniqueId())) {
            return Optional.of(manager.get(player.getUniqueId()));
        }
        return Optional.<InventoryMenu>absent();
    }

}