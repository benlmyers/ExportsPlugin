package com.characterlim.exportsplugin.command.npc;

import com.characterlim.exportsplugin.command.abstractions.ChildCommand;
import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.manager.NPCManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PlaceNPCCommand extends ChildCommand {

    @Override
    public boolean onCommand(CommandSender commandSender, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            NPCManager.placeNPC(player);
            Comm.send(player, "The NPC has been placed at the player's feet!");
            return true;
        }
        return false;
    }

    @Override
    public List<String> completions(String arg) {
        return null;
    }

    @Override
    public String helpMessage() {
        return "Set the position of the Traveler NPC at your feet";
    }

    @Override
    public String thisCommand() {
        return "place";
    }
}
