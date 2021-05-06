package com.characterlim.exportsplugin.config;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

public class ConfigManager {

    private static JavaPlugin plugin;
    private static Configuration config;
    private static final String PREFIX_KEY = "prefix";
    private static final String SHOULD_LOG_KEY = "log-to-console";
    private static final String NPC_SKIN_NAME_KEY = "npc.skin";
    private static final String NPC_ID_KEY = "npc.id";
    private static final String NPC_NAME_KEY = "npc.name";
    private static final String NPC_LOCATION_KEY = "npc.location";
    private static final String BASE_PRICE_KEY = "base-price";
    private static final String EXPORT_ITEMS_KEY = "export-items";
    private static final String EXPORT_COUNTS_KEY = "export-counts";

    public static void prepare(JavaPlugin plugin) {
        ConfigManager.plugin = plugin;
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public static String getPrefix() {
        return config.getString(PREFIX_KEY);
    }

    public static void setPrefix(String value) {
        config.set(PREFIX_KEY, value);
        plugin.saveConfig();
    }

    public static boolean getShouldLog() {
        return config.getBoolean(SHOULD_LOG_KEY);
    }

    public static void setShouldLog(boolean value) {
        config.set(SHOULD_LOG_KEY, value);
        plugin.saveConfig();
    }

    public static String getNPCSkin() {
        return config.getString(NPC_SKIN_NAME_KEY);
    }

    public static void setNPCSkin(String value) {
        config.set(NPC_SKIN_NAME_KEY, value);
        plugin.saveConfig();
    }

    public static int getNPC_ID() {
        return config.getInt(NPC_ID_KEY);
    }

    public static void setNPC_ID(int value) {
        config.set(NPC_ID_KEY, value);
        plugin.saveConfig();
    }

    public static String getNPCName() {
        return config.getString(NPC_NAME_KEY);
    }

    public static void setNPCName(String value) {
        config.set(NPC_NAME_KEY, value);
        plugin.saveConfig();
    }

    public static Location getNPCLocation() {
        return config.getLocation(NPC_LOCATION_KEY);
    }

    public static void setNPCLocation(Location location) {
        config.set(NPC_LOCATION_KEY, location);
        plugin.saveConfig();
    }

    public static int getBasePrice() {
        return config.getInt(BASE_PRICE_KEY);
    }

    public static void setBasePrice(int price) {
        config.set(BASE_PRICE_KEY, price);
        plugin.saveConfig();
    }

    public static List<String> getExportItems() {
        return config.getStringList(EXPORT_ITEMS_KEY);
    }

    public static void setExportItems(List<String> items) {
        config.set(EXPORT_ITEMS_KEY, items);
        plugin.saveConfig();
    }

    public static List<Integer> getExportCounts() {
        return config.getIntegerList(EXPORT_COUNTS_KEY);
    }

    public static void setExportCounts(List<Integer> items) {
        config.set(EXPORT_COUNTS_KEY, items);
        plugin.saveConfig();
    }

    private static void prepareDefaults() {
        config.addDefault(PREFIX_KEY, "§b[§9Traveler§b] ");
        config.addDefault(SHOULD_LOG_KEY, true);
    }
}
