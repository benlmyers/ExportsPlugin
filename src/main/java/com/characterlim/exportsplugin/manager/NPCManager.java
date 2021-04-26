package com.characterlim.exportsplugin.manager;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NPCManager {

    private static NPC npc;

    public static void placeNPC(Player player) {
        npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Traveler");
    }
}
