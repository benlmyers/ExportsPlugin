package com.characterlim.exportsplugin.command.abstractions;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface CustomCommand {
    List<String> completions(String arg);
    String helpMessage = "This is a template help message!";
}
