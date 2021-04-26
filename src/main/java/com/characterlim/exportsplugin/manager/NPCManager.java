package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.config.ConfigManager;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NPCManager {

    private static NPC npc;

    public static void placeNPC(Player player) {
        try {
            npc = CitizensAPI.getNPCRegistry().getById(ConfigManager.getNPC_ID());
        } catch(Exception e) {
            npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Merchant");
            ConfigManager.setNPC_ID(npc.getId());
        }
        npc.despawn();
        npc.spawn(player.getLocation());
        updateSkin();
    }

    public static void reload() {

    }

    public static void disable() {
        CitizensAPI.getNPCRegistry().despawnNPCs(null);
    }

    private static void updateSkin() {
        SkinTrait skinTrait = npc.getOrAddTrait(SkinTrait.class);
        skinTrait.setSkinName(ConfigManager.getNPCSkin());
    }
}
