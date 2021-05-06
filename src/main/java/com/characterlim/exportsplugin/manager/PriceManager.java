package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import org.bukkit.Material;

import java.util.List;

public class PriceManager {

    private static List<String> items;
    private static List<Integer> counts;

    public static void check() {
        items = ConfigManager.getExportItems();
        counts = ConfigManager.getExportCounts();
        for(int i = items.size() - 1; i > 0; i--) {
            Material material = Material.getMaterial(items.get(i));
            if(material == null) {
                Debug.warn("An invalid material was found! Removing \"" + items.get(i) + "\".");
                items.remove(i);
                counts.remove(i);
                continue;
            }
        }
        if(items.size() > counts.size()) {
            int diff = items.size() - counts.size();
            for(int i = 0; i < diff; i++) {
                counts.add(1);
            }
        }
    }

    public static int getSellPrice(String material) {
        int i = items.indexOf(material);
        int n = counts.get(i);
        int m = items.size();
        int base = ConfigManager.getBasePrice();
        int startPrice = base * m;
        int totalExports = totalOf(counts);
        double p = (double)n / (double)totalExports;
        double price = startPrice / p;
        return (int) Math.ceil(price);
    }

    public static int getSellPrice() {
        return getSellPrice(RotationManager.getAcceptedItem().toString());
    }

    public static void addCount(String material) {
        int i = items.indexOf(material);
        int n = counts.get(i);
        n += 1;
        Debug.log("Count added to index " + i + ": " + n);
        counts.set(i, n);
        Debug.log("New count: " + counts.get(i));
    }

    public static void disable() {
        ConfigManager.setExportItems(items);
        ConfigManager.setExportCounts(counts);
    }

    private static int totalOf(List<Integer> list) {
        int count = 0;
        for(Integer val: list) {
            count += val;
        }
        return count;
    }
}
