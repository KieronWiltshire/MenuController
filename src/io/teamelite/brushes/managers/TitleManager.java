package io.teamelite.brushes.managers;

import org.bukkit.ChatColor;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TitleManager {
	public static void createSubTitle(Player p, String t, int fIT, int sT, int fOT, ChatColor c) {
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + t + "\",color:" + c.name().toLowerCase() + "}");
		  
        PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(fIT, sT, fOT);
    
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);		
	}
	
	public static void createTitle(Player p, String t, int fIT, int sT, int fOT, ChatColor c) {
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + t + "\",color:" + c.name().toLowerCase() + "}");
		  
        PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle length = new PacketPlayOutTitle(fIT, sT, fOT);
    
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);		
	}
}