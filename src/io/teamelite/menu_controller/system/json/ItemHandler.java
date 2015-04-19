package io.teamelite.menu_controller.system.json;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.teamelite.menu_controller.MenuController;
import io.teamelite.menu_controller.system.menu.InventoryMenu;
import io.teamelite.menu_controller.system.menu.MenuItem;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

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
    private ItemHandler() {
        this.items = new ArrayList<MenuItem>();
        this.load();
    }

    /**
     * Loads the list with items generated from their respective json files
     */
    private void load() {
        Gson g = GsonFactory.getPrettyGson();
        File dir = MenuController.getPlugin().getItemDirectory();
        if (dir != null && dir.exists() && dir.listFiles().length > 0) {
            for (File f : dir.listFiles()) {
                try {
                    JsonReader content = new JsonReader(new FileReader(f));


                } catch (FileNotFoundException e) {
                    Bukkit.getLogger().log(Level.INFO, "Unable to retrieve JSON from " + f.getName() + ".");
                }
            }
        }
    }

    /**
     * Save a MenuItem to json flat file
     *
     * @param item The MenuItem you wish to save
     */
    public void save(MenuItem item) {
        // TODO
    }

    /**
     * Get all of the currently loaded items
     *
     * @param menu The menu to retrieve the items from
     * @return A list of all of the loaded items
     */
    public ImmutableList<MenuItem> getLoadedItems(InventoryMenu menu) {
        // This is probably a bad way of doing this, and I should probably rework it
        List<MenuItem> clones = new ArrayList<MenuItem>();
        for (MenuItem i : this.items) {
            try {
                MenuItem m = (MenuItem) i.clone();
                m.setMenu(menu);
                
                clones.add(m);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        return ImmutableList.copyOf(clones);
    }

}
