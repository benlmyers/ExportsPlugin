package com.characterlim.exportsplugin.command.npc;

import com.characterlim.exportsplugin.command.CompletionsGenerator;
import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import com.characterlim.exportsplugin.command.abstractions.MiddleCommand;
import com.characterlim.exportsplugin.command.abstractions.ParentCommand;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.List;

public class NPCCommand extends MiddleCommand {

    private final HashMap<String, ChildCommand> children = new HashMap<>();

    public NPCCommand() {
        children.put("place", new PlaceNPCCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        if(args.length == 0) {
            return doHelp(sender);
        } else {
            String arg = args[0].toLowerCase();
            if(arg.equals("help")) return doHelp(sender);
            else {
                ChildCommand child = children.get(arg);
                if(child != null) {
                    return executeChildCommand(sender, args, child);
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
        return "Manage the NPC that the user clicks to sell their items in bulk";
    }

    @Override
    public String thisCommand() {
        return "npc";
    }
}
