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
            Comm.send(player, "&cYou don't have enough items to make this export!");
            return false;
        } else {
            removeItems(player.getInventory(), material, itemstack.getAmount());
            return true;
        }
    }

    private static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }
}
