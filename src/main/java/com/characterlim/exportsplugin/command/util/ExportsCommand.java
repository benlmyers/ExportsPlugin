package com.characterlim.exportsplugin.command.util;

import com.characterlim.exportsplugin.Comm;
import com.characterlim.exportsplugin.ExportsPlugin;
import com.characterlim.exportsplugin.command.CompletionsGenerator;
import com.characterlim.exportsplugin.command.abstractions.ParentCommand;
import com.characterlim.exportsplugin.config.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExportsCommand extends ParentCommand implements TabExecutor {

    private final ExportsPlugin plugin;
    private final String[] children = {"help", "reload"};

    public ExportsCommand(ExportsPlugin instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 0) {
            return doHelp(commandSender);
        } else {
            String arg = args[0].toLowerCase();
            if(arg.equals("reload")) return doReload(commandSender);
            else if(arg.equals("help")) return doHelp(commandSender);
            else {
                return false;
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 1) {
            return completions(args[0]);
        } else if(args.length == 2) {
            //...
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> completions(String arg) {
        return CompletionsGenerator.generate(children, arg);
    }

    private boolean doReload(CommandSender sender) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ConfigManager.reload();
            Comm.send(player, "The plugin has successfully reloaded 3!");
            return true;
        }
        return false;
    }

    private boolean doHelp(CommandSender sender) {
        return false;
    }
}
