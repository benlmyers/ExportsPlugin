package com.characterlim.exportsplugin.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface ChildCommand {

    boolean onCommand(CommandSender sender, String[] args);

    List<String> completions(String arg);
}
