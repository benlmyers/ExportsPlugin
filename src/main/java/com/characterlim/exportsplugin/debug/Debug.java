package com.characterlim.exportsplugin.debug;

import com.characterlim.exportsplugin.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Debug {

    private static Logger logger;

    public static void prepare(JavaPlugin instance) {
        logger = instance.getLogger();
    }

    public static void log(String message) {
        if(ConfigManager.getShouldLog()) logger.info(message);
    }

    public static void warn(String message) {
        if(ConfigManager.getShouldLog()) logger.warning(message);
    }

    public static void severe(String message) {
        logger.severe(message);
    }
}
