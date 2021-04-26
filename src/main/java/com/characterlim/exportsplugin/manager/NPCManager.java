package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NPCManager {

    private static NPC npc;

    public static void placeNPC(Player player) {
        setupNPC(player.getLocation());
    }

    public static void enable() {
        Location loc = ConfigManager.getNPCLocation();
        setupNPC(loc);
    }

    public static void disable() {
        CitizensAPI.getNPCRegistry().despawnNPCs(null);
    }

    private static void updateSkin() {
        SkinTrait skinTrait = npc.getOrAddTrait(SkinTrait.class);
        skinTrait.setSkinName(ConfigManager.getNPCSkin());
    }

    private static void setupNPC(Location loc) {
        try {
            npc = CitizensAPI.getNPCRegistry().getById(ConfigManager.getNPC_ID());
            npc.setName(ConfigManager.getNPCName());
        } catch(Exception e) {
            npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, ConfigManager.getNPCName());
            ConfigManager.setNPC_ID(npc.getId());
        }
        if(npc != null) npc.despawn();
        else {
            Debug.warn("No NPC could be found when enabling!");
            return;
        }
        if(loc != null) {
            npc.spawn(loc);
            ConfigManager.setNPCLocation(loc);
        }
        else {
            Debug.warn("No NPC location was found!");
            return;
        }
        updateSkin();
    }
}
