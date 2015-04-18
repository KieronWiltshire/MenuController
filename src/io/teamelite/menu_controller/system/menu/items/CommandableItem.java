package io.teamelite.menu_controller.system.menu.items;

import io.teamelite.menu_controller.system.menu.InventoryMenu;
import io.teamelite.menu_controller.system.menu.MenuItem;
import org.bukkit.entity.Player;
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
public class CommandableItem extends MenuItem {

    // Instance properties
    private List<String> commands;

    /**
     * CommandableItem constructor
     *
     * @param inventory The InventoryMenu instance to handle the items
     * @param item The item to represent the menu option
     * @param commands The commands to execute when the item is selected
     */
    public CommandableItem(InventoryMenu inventory, ItemStack item, String... commands) {
        super(inventory, item);
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void onItemSelect() {
        if (this.getMenu().getInventory().getHolder() instanceof Player) {
            Player p = (Player) this.getMenu().getInventory().getHolder();
            for(String c : this.commands) {
                p.performCommand(c);
            }
        }
    }

}
