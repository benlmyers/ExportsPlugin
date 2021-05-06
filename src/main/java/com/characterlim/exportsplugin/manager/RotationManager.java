package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.ExportsPlugin;
import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class RotationManager {

    private static Material acceptedItem;

    public static void start(Plugin plugin) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                rotate();
            }
        }, 20 * 1, 20 * 60 * ConfigManager.getTimeInterval());
    }

    public static Material getAcceptedItem() {
        return acceptedItem;
    }

    public static int getSellPrice() {
        int sellPrice = PriceManager.getSellPrice(acceptedItem.toString());
        return sellPrice;
    }

    public static void rotate() {
        List<String> items = ConfigManager.getExportItems();
        Material newItem = acceptedItem;
        int count = 3;
        while(newItem == acceptedItem && count > 0) {
            newItem = Material.getMaterial(items.get((int) Math.floor(items.size() * Math.random())));
            if(newItem == null) {
                newItem = Material.BONE;
            }
            count -= 1;
        }
        acceptedItem = newItem;
        int sellPrice = PriceManager.getSellPrice(acceptedItem.toString());
        Comm.broadcast("Stacks of &9" + getFormattedName(acceptedItem) + "&b are now available for export! Sell Price: " + EconomyManager.formatted(sellPrice));
    }

    private static String getFormattedName(Material material) {
        if ( material == null ) {
            return null;
        }
        StringBuilder friendlyName = new StringBuilder();
        for ( String word : material.name().split( "_" ) ) {
            friendlyName.append( word.substring( 0, 1 ).toUpperCase() + word.substring( 1 ).toLowerCase() + " " );
        }
        return friendlyName.toString().trim();
    }
}
