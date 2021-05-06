package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.communication.Comm;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public static boolean removeStackFromInventory(Player player, Material material) {

        ItemStack itemstack = new ItemStack(material,64);

        if(!(player.getInventory().contains(itemstack))) {
            Comm.send(player, "&eYou don't have enough items to make this export!");
            return false;
        } else {
            player.getInventory().remove(itemstack);
            return true;
        }
    }
}
