package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import org.bukkit.Material;

import java.util.List;

public class PriceManager {

    public static void check() {
        List<String> items = ConfigManager.getExportItems();
        List<Integer> counts = ConfigManager.getExportCounts();
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
            ConfigManager.setExportCounts(counts);
        }
    }

    public static int getSellPrice(String material) {
        List<String> items = ConfigManager.getExportItems();
        List<Integer> counts = ConfigManager.getExportCounts();
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

    public static void addCount(String material) {
        List<String> items = ConfigManager.getExportItems();
        List<Integer> counts = ConfigManager.getExportCounts();
        int i = items.indexOf(material);
        int n = counts.get(i);
        n += 1;
        counts.set(i, n);
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
