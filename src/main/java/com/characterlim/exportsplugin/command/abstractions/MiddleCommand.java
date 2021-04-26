package com.characterlim.exportsplugin.command.abstractions;

import com.characterlim.exportsplugin.communication.Comm;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public abstract class MiddleCommand extends ChildCommand {

    protected HashMap<String, ChildCommand> children = new HashMap<>();

    public boolean executeChildCommand(CommandSender commandSender, String[] args, ChildCommand child) {
        String[] subargs = new String[args.length - 1];
        System.arraycopy(args, 1, subargs, 0, args.length - 1);
        return child.onCommand(commandSender, subargs);
    }

    protected boolean doHelp(CommandSender sender) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Comm.sendHelp(player, thisCommand(), helpMessage());
            for(String key : children.keySet()) {
                ChildCommand childCommand = children.get(key);
                if(childCommand != null) Comm.sendHelp(player, childCommand.thisCommand(this), childCommand.helpMessage());
            }
            return true;
        }
        return false;
    }

}
