package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.ExportsPlugin;
import com.characterlim.exportsplugin.NPCTrait;
import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.config.ConfigManager;
import com.characterlim.exportsplugin.debug.Debug;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitFactory;
import net.citizensnpcs.api.trait.TraitInfo;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

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
            TraitFactory factory = CitizensAPI.getTraitFactory();
            factory.registerTrait(TraitInfo.create(NPCTrait.class).withName("sellonclick"));
            npc.addTrait(factory.getTrait("sellonclick"));
            Debug.log("The NPC's trait has been registered.");
        }
        else {
            Debug.warn("No NPC location was found!");
            return;
        }
        updateSkin();
    }
}
