package com.characterlim.exportsplugin;

import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.debug.Debug;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class NPCTrait extends Trait {

    ExportsPlugin plugin = null;

    public NPCTrait() {
        super("sellonclick");
        plugin = JavaPlugin.getPlugin(ExportsPlugin.class);
    }

    @EventHandler
    public void click(NPCRightClickEvent event) {
        if(event.getNPC() == this.getNPC()) {
            Comm.send(event.getClicker(), "You right-clicked me!");
        }
    }

    @EventHandler
    public void click(NPCLeftClickEvent event) {
        if(event.getNPC() == this.getNPC()) {
            Comm.send(event.getClicker(), "You left-clicked me!");
        }
    }

    @Override
    public void onAttach() {
        Debug.log("The Sellonclick trait has been attached to the NPC.");
    }
}