package com.characterlim.exportsplugin.command.abstractions;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class ChildCommand implements CustomCommand {

    public abstract List<String> completions(String arg);

    public String thisCommand(ParentCommand parentCommand) {
        return parentCommand.thisCommand() + " " + thisCommand();
    }
}
