package com.characterlim.exportsplugin.config;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static JavaPlugin plugin;
    private static Configuration config;
    private static final String PREFIX_KEY = "prefix";
    private static final String SHOULD_LOG_KEY = "log-to-console";
    private static final String NPC_SKIN_NAME_KEY = "npc-skin";

    public static void prepare(JavaPlugin plugin) {
        plugin.saveDefaultConfig();
        ConfigManager.plugin = plugin;
        config = plugin.getConfig();
        prepareDefaults();
        plugin.saveDefaultConfig();
    }

    public static void reload() {
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
    }

    public static String getNPCSkin() {
        return config.getString(NPC_SKIN_NAME_KEY);
    }

    public static void setNPCSkin(String value) {
        config.set(NPC_SKIN_NAME_KEY, value);
    }

    private static void prepareDefaults() {
        config.addDefault(PREFIX_KEY, "§b[§9Traveler§b] ");
        config.addDefault(SHOULD_LOG_KEY, true);
    }
}
