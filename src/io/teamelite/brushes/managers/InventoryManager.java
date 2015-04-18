package io.teamelite.brushes.managers;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {
	private static Inventory newInv;
	
	public static Inventory createInventory(Player owner, int slots, String name) {
		newInv = Bukkit.createInventory(owner, slots, name);
		return newInv;
	}
	
	public static void setInventory(Player player, Inventory inventory) {
		player.openInventory(inventory);
	}
	
	public static void addItem(Material mat, int amnt, String lore, String name, int slot, Inventory inv) {
		ItemStack is = new ItemStack(mat, amnt);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lore));
		is.setItemMeta(im);
		inv.setItem(slot, is);	
	}
}
