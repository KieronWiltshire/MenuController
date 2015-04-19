package io.teamelite.menu_controller.system;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import io.teamelite.menu_controller.MenuPlugin;
import io.teamelite.menu_controller.system.menu.InventoryMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.util.*;

/**
 * @author Liam Reffell and Kieron Wiltshire
 * @name MenuController
 * @contact http://www.mcteamelite.com/
 * @license MIT License
 * @description The plugin requires Java 1.6 or higher.
 * It allows a user to open up an inventory interface and
 * select their saved menu options.
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
    private HashMap<UUID, List<InventoryMenu>> manager;

    /**
     * MenuManager constructor
     */
    private MenuManager() {
        this.manager = new HashMap<UUID, List<InventoryMenu>>();
    }

    /**
     * Create an InventoryMenu
     *
     * @param player The player you wish to create a menu for
     */
    public void createMenu(Player player, String title) {
        for(Map.Entry<UUID, List<InventoryMenu>> entry : this.manager.entrySet()) {
            for (InventoryMenu m : entry.getValue()) {
                if (m.getInventory().getTitle().equalsIgnoreCase(title)) return;
            }
        }

        InventoryMenu menu = new InventoryMenu(player, title);
        Bukkit.getPluginManager().registerEvents(menu, MenuPlugin.instance());

        if (!this.manager.containsKey(player)) {
            this.manager.put(player.getUniqueId(), new ArrayList<InventoryMenu>());
        }
        this.manager.get(player.getUniqueId()).add(menu);
    }

    /**
     * Destroy an InventoryMenu
     *
     * @param player The player you wish to destroy the menus of
     */
    public void destroyMenu(Player player) {
        if (this.manager.containsKey(player.getUniqueId())) {
            for (InventoryMenu m : this.manager.get(player.getUniqueId())) {
                HandlerList.unregisterAll(m);
            }
            this.manager.remove(player.getUniqueId());
        }
    }

    /**
     * Destroy an InventoryMenu
     *
     * @param title The Title of the inventory menu
     */
    public void destroyMenu(String title) {
        for (List<InventoryMenu> list : this.manager.values()) {
            for (Iterator<InventoryMenu> iter = list.iterator(); iter.hasNext();) {
                InventoryMenu m = iter.next();
                if (m.getInventory().getTitle().equalsIgnoreCase(title)) {
                    HandlerList.unregisterAll(m);
                    iter.remove();
                }
            }
        }
    }

    /**
     * Destroy an InventoryMenu
     *
     * @param menu The menu to destroy
     */
    public void destroyMenu(InventoryMenu menu) {
        this.destroyMenu(menu.getInventory().getTitle());
    }

    /**
     * Destroy an InventoryMenu
     *
     * @param player The player you wish to destroy the menus of
     * @param title The Title of the inventory menu
     */
    public void destroyMenu(Player player, String title) {
        if (this.manager.containsKey(player.getUniqueId())) {
            for (Iterator<InventoryMenu> iter = this.manager.get(player.getUniqueId()).iterator(); iter.hasNext(); ) {
                InventoryMenu m = iter.next();
                if (m.getInventory().getTitle().equalsIgnoreCase(title)) {
                    HandlerList.unregisterAll(m);
                    iter.remove();
                }
            }
        }
    }

    /**
     * Get all of the menus for a specific player
     *
     * @param player The player you wish to get the menus of
     * @return The menus of the specified player
     */
    public Optional<ImmutableList<InventoryMenu>> getMenu(Player player) {
        if (this.manager.containsKey(player.getUniqueId())) {
            List<InventoryMenu> list = new ArrayList<InventoryMenu>();
            for (Iterator<InventoryMenu> iter = this.manager.get(player.getUniqueId()).iterator(); iter.hasNext();) {
                list.add(iter.next());
            }
            return Optional.of(ImmutableList.copyOf(list));
        }
        return Optional.<ImmutableList<InventoryMenu>>absent();
    }

    /**
     * Get the menu for a specific player
     *
     * @param player The player you wish to retrieve the menu of
     * @return The InventoryMenu instance
     */
    public Optional<InventoryMenu> getMenu(Player player, String title) {
        if (this.manager.containsKey(player.getUniqueId())) {
            for (Iterator<InventoryMenu> iter = this.manager.get(player.getUniqueId()).iterator(); iter.hasNext();) {
                InventoryMenu m = iter.next();
                if (m.getInventory().getTitle().equalsIgnoreCase(title)) {
                    return Optional.of(m);
                }
            }
        }
        return Optional.<InventoryMenu>absent();
    }

}