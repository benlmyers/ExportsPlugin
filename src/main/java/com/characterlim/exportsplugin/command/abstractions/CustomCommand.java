package com.characterlim.exportsplugin.command.abstractions;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface CustomCommand {
    boolean onCommand(CommandSender commandSender, String[] args);
    List<String> completions(String arg);
    String helpMessage();
    String thisCommand();
}
