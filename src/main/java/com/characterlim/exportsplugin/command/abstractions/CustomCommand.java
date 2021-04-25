package com.characterlim.exportsplugin.command.abstractions;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface CustomCommand {

    void executeChildCommand(CommandSender commandSender, String[] args, ChildCommand child);

    List<String> completions(String arg);
}
