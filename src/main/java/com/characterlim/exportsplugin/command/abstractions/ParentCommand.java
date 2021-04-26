package com.characterlim.exportsplugin.command.abstractions;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import com.characterlim.exportsplugin.command.abstractions.CustomCommand;
import org.bukkit.command.CommandSender;

public abstract class ParentCommand implements CustomCommand {

    public void executeChildCommand(CommandSender commandSender, String[] args, ChildCommand child) {
        String[] subargs = new String[args.length - 1];
        System.arraycopy(args, 1, subargs, 0, args.length - 1);
        child.onCommand(commandSender, subargs);
    }

    protected String[] childCommands;
}
