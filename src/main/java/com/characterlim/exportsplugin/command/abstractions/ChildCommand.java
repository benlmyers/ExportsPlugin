package com.characterlim.exportsplugin.command.abstractions;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface ChildCommand extends CustomCommand {

    boolean onCommand(CommandSender sender, String[] args);

    List<String> completions(String arg);

    String thisCommand(ParentCommand parentCommand);
}
