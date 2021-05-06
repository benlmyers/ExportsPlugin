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

    private Material acceptedItem;
    private Plugin plugin;

    public RotationManager(Plugin instance) {
        this.plugin = instance;
    }

    public void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
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
                Comm.broadcast("Stacks of &9" + acceptedItem.toString().toLowerCase() + "&b are now being exported! Sell Price: " + EconomyManager.formatted(sellPrice));
            }
        }, 20 * 1, 20 * 10);
    }
}
