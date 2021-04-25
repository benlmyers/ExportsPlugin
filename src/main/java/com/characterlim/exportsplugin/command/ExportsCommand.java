package com.characterlim.exportsplugin.command;

import com.characterlim.exportsplugin.ExportsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class ExportsCommand extends ParentCommand implements TabExecutor {

    private final ExportsPlugin plugin;

    public ExportsCommand(ExportsPlugin instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
