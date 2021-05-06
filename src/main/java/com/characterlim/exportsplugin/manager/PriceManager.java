package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.config.ConfigManager;

import java.util.List;

public class PriceManager {

    public static int getSellPrice(String material) {
        List<String> items = ConfigManager.getExportItems();
        List<Integer> counts = ConfigManager.getExportCounts();
        int i = items.indexOf(material);
        int n = counts.get(i);
        int m = items.size();
        int base = ConfigManager.getBasePrice();
        int startPrice = base * m;
        int totalExports = totalOf(counts);
        double p = n / totalExports;
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
