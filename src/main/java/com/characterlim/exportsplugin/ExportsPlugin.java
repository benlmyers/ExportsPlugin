package com.characterlim.exportsplugin;

import com.characterlim.exportsplugin.command.ExportsCommand;
import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import com.characterlim.exportsplugin.debug.DependencyChecker;
import com.characterlim.exportsplugin.manager.EconomyManager;
import com.characterlim.exportsplugin.manager.NPCManager;
import com.characterlim.exportsplugin.manager.PriceManager;
import com.characterlim.exportsplugin.manager.RotationManager;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class ExportsPlugin extends JavaPlugin {

    private final TabExecutor exportsCommand = new ExportsCommand(this);
    private final String[] pluginNames = {"Citizens", "Vault"};
    private DependencyChecker dependencyChecker;

    @Override
    public void onEnable() {
        ConfigManager.prepare(this);
        Debug.prepare(this);
        EconomyManager.prepare(this);
        this.getCommand("exports").setExecutor(exportsCommand);
        this.getCommand("exports").setTabCompleter(exportsCommand);
        dependencyChecker = new DependencyChecker(this, pluginNames);
        dependencyChecker.check();
        NPCManager.enable();
        Debug.log("Setup complete.");
        RotationManager.start(this);
        PriceManager.check();
    }

    @Override
    public void onDisable() {
        NPCManager.disable();
        PriceManager.disable();
    }
}
