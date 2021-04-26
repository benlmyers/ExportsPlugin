package com.characterlim.exportsplugin.manager;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NPCManager {

    private static NPC npc;

    public static void placeNPC(Player player) {
        npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Traveler");
        npc.spawn(player.getLocation());
        SkinTrait skinTrait = npc.getOrAddTrait(SkinTrait.class);
        System.out.println(skinTrait.getSkinName());
        skinTrait.setSkinName("CodeSensei_Ben");
    }

    public static void reload() {

    }
}
