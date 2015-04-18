package io.teamelite.brush_menu.system.menu.items;

import io.teamelite.brush_menu.system.menu.InventoryMenu;
import io.teamelite.brush_menu.system.menu.MenuItem;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * @name 		BrushMenu
 * @author 		Liam Reffell and Kieron Wiltshire
 * @contact 	http://www.mcteamelite.com/
 * @license 	MIT License
 * @description
 * 				The plugin requires Java 1.6 or higher and depends on the VoxelSniper
 * 				Bukkit plugin. It allows a user to open up an inventory interface and
 * 				select their desired VoxelSniper brush.
 */
public class BrushItem extends MenuItem {

    // Instance properties
    private List<String> commands;

    /**
     * BrushItem constructor
     *
     * @param inventory The InventoryMenu instance to handle the items
     * @param item The item to represent the menu option
     * @param commands The commands to execute when the item is selected
     */
    protected BrushItem(InventoryMenu inventory, ItemStack item, String... commands) {
        super(inventory, item);
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void onItemSelect() {
        // TODO
    }

}
