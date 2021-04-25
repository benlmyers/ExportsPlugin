package com.characterlim.exportsplugin.debug;

import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import org.bukkit.plugin.java.JavaPlugin;

public class DependencyChecker {

    private JavaPlugin plugin;
    private String[] externalPlugins;

    public DependencyChecker(JavaPlugin instance, String[] externalPlugins) {
        this.plugin = instance;
        this.externalPlugins = externalPlugins;
    }

    public boolean check() {
        boolean result = true;
        for(String externalPlugin : externalPlugins) {
            boolean check = check(externalPlugin);
            if(!check) result = false;
        }
        if(result) Debug.log("All dependencies found successfully!");
        return result;
    }

    private boolean check(String plugin) {
        boolean exists = this.plugin.getServer().getPluginManager().getPlugin(plugin) != null;
        if(exists) Debug.log("Successfully hooked into " + plugin + ".");
        return exists;
    }
}
