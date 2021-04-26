package com.characterlim.exportsplugin.config;

import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static JavaPlugin plugin;
    private static Configuration config;
    private static final String PREFIX_KEY = "prefix";
    private static final String SHOULD_LOG_KEY = "log-to-console";
    private static final String NPC_SKIN_NAME_KEY = "npc.skin";
    private static final String NPC_ID_KEY = "npc.id";
    private static final String NPC_NAME_KEY = "npc.name";
    private static final String NPC_LOCATION_KEY = "npc.location";

    public static void prepare(JavaPlugin plugin) {
        ConfigManager.plugin = plugin;
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
        //prepareDefaults();
        //plugin.saveDefaultConfig();
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

    private static void prepareDefaults() {
        config.addDefault(PREFIX_KEY, "§b[§9Traveler§b] ");
        config.addDefault(SHOULD_LOG_KEY, true);
    }
}
