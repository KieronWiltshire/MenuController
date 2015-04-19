package io.teamelite.menu_controller.system;

import com.google.common.base.Optional;
import io.teamelite.menu_controller.MenuPlugin;
import io.teamelite.menu_controller.system.menu.InventoryMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

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

    private static MenuManager instance;

    /**
     * Get the MenuManager
     *
     * @return The MenuManager instance
     */
    public static MenuManager instance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    // Instance properties
    private HashMap<UUID, InventoryMenu> manager;

    /**
     * MenuManager constructor
     */
    private MenuManager() { this.manager = new HashMap<UUID, InventoryMenu>(); }

    /**
     * Create an InventoryMenu
     *
     * @param player The player you wish to create a menu for
     */
    public InventoryMenu createMenu(Player player, String title) {
        if (manager.containsKey(player.getUniqueId())) return null;

        InventoryMenu menu = new InventoryMenu(player, title);
        Bukkit.getPluginManager().registerEvents(menu, MenuPlugin.instance());

        manager.put(player.getUniqueId(), menu);

        return menu;
    }

    /**
     * Destroy an InventoryMenu
     *
     * @param player The player you wish to destroy the menus of
     */
    public void destroyMenu(Player player) {
        if (this.manager.containsKey(player.getUniqueId())) {
            HandlerList.unregisterAll(this.manager.get(player.getUniqueId()));
            this.manager.remove(player.getUniqueId());
        }
    }

    /**
     * Get the menu for a specific player
     *
     * @param player The player you wish to retrieve the menu of
     * @return The InventoryMenu instance
     */
    public Optional<InventoryMenu> getMenu(Player player) {
        if (this.manager.containsKey(player.getUniqueId())) {
            return Optional.of(this.manager.get(player.getUniqueId()));
        }
        return Optional.<InventoryMenu>absent();
    }

}