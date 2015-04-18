package io.teamelite.menu_controller.commands;

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
public class Voxel /* implements CommandExecutor */ {

	// private Inventory inv;

	/* TODO rewrite
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("voxel")) {
			if(sender.hasPermission("teamelite.voxel.use")) {
				if(!p.getInventory().contains(new ItemStack(Material.ARROW, 1))) {
					p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
					p.sendMessage(Main.prefix() + ChatColor.RESET + ChatColor.RED.toString() + " It seemed you didn't have an arrow.. here's one free of charge from us!");
				}
				inv = InventoryManager.createInventory(null, 9, "TeamElite Brushes");
				InventoryManager.addItem(Material.CLAY_BALL, 1, ChatColor.GOLD + "Sets 3 Layers of Clay", ChatColor.DARK_RED + "Overlay Brush 1", 1, inv);
				InventoryManager.addItem(Material.GRASS, 1, ChatColor.GOLD + "Sets 2 Layers of Grass", ChatColor.DARK_RED + "Overlay Brush 2", 3, inv);
				InventoryManager.addItem(Material.INK_SACK, 1, ChatColor.GOLD + "Creates a Sand Ball Size 5", ChatColor.DARK_RED + "Mountain Brush", 5, inv);
				InventoryManager.addItem(Material.WATER_BUCKET, 1, ChatColor.GOLD + "Creates a Air Ball Size 4", ChatColor.DARK_RED + "River Brush", 7, inv);
				InventoryManager.setInventory(p, inv);
			} else {
				sender.sendMessage(Main.prefix() + ChatColor.RESET + ChatColor.RED.toString() + " You do not have the correct permissions to use the VoxelGUI");
			}
		}
		return true;
	}
	*/

}
