package com.characterlim.exportsplugin.command.util;

import com.characterlim.exportsplugin.ExportsPlugin;
import com.characterlim.exportsplugin.command.CompletionsGenerator;
import com.characterlim.exportsplugin.command.abstractions.ParentCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class ExportsCommand extends ParentCommand implements TabExecutor {

    private final ExportsPlugin plugin;
    private final String[] children = {"help", "reload"};

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

    @Override
    public List<String> completions(String arg) {
        return CompletionsGenerator.generate(children, arg);
    }
}
