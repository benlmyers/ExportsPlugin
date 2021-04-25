package com.characterlim.exportsplugin.command;

import com.characterlim.exportsplugin.command.ChildCommand;
import org.bukkit.command.CommandSender;

public abstract class ParentCommand {

    protected void executeChildCommand(CommandSender commandSender, String[] args, ChildCommand child) {
        String[] subargs = new String[args.length - 1];
        System.arraycopy(args, 1, subargs, 0, args.length - 1);
        child.onCommand(commandSender, subargs);
    }
}
