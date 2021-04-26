package com.characterlim.exportsplugin.command;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import com.characterlim.exportsplugin.command.abstractions.ParentCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class NPCCommand implements ChildCommand {

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

    @Override
    public String thisCommand(ParentCommand parentCommand) {
        return parentCommand.thisCommand() + " " + thisCommand();
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
