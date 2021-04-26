package com.characterlim.exportsplugin.command;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class NPCCommand implements ChildCommand {

    private final String helpMessage = "Manage the NPC that the user clicks to sell their items in bulk";

    public NPCCommand() {
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        return false;
    }

    @Override
    public List<String> completions(String arg) {
        return null;
    }
}
