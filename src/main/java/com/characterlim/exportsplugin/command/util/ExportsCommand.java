package com.characterlim.exportsplugin.command.util;

import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.ExportsPlugin;
import com.characterlim.exportsplugin.command.CompletionsGenerator;
import com.characterlim.exportsplugin.command.npc.NPCCommand;
import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import com.characterlim.exportsplugin.command.abstractions.ParentCommand;
import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.manager.NPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ExportsCommand extends ParentCommand implements TabExecutor {

    private final ExportsPlugin plugin;

    public ExportsCommand(ExportsPlugin instance) {
        this.plugin = instance;
        children.put("npc", new NPCCommand());
        children.put("help", null);
        children.put("reload", null);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        return onCommand(commandSender, args);
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
    public boolean onCommand(CommandSender commandSender, String[] args) {
        if(args.length == 0) {
            return doHelp(commandSender);
        } else {
            String arg = args[0].toLowerCase();
            if(arg.equals("reload")) return doReload(commandSender);
            else if(arg.equals("help")) return doHelp(commandSender);
            else {
                ChildCommand child = children.get(arg);
                if(child != null) {
                    return executeChildCommand(commandSender, args, child);
                } else return false;
            }
        }
    }

    @Override
    public List<String> completions(String arg) {
        return CompletionsGenerator.generate(children.keySet(), arg);
    }

    @Override
    public String helpMessage() {
        return "The base command for the ExportsPlugin";
    }

    @Override
    public String thisCommand() {
        return "exports";
    }

    private boolean doReload(CommandSender sender) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ConfigManager.reload();
            NPCManager.reload();
            Comm.send(player, "The plugin has successfully reloaded!");
            return true;
        }
        return false;
    }
}
