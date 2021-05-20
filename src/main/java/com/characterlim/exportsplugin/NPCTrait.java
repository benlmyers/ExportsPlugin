package com.characterlim.exportsplugin;

import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.debug.Debug;
import com.characterlim.exportsplugin.manager.EconomyManager;
import com.characterlim.exportsplugin.manager.InventoryManager;
import com.characterlim.exportsplugin.manager.PriceManager;
import com.characterlim.exportsplugin.manager.RotationManager;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
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

            if(InventoryManager.removeStackFromInventory(event.getClicker(), RotationManager.getAcceptedItem())) {
                Comm.send(event.getClicker(), "You exported &e64&7x &b" + getFormattedName(RotationManager.getAcceptedItem()) + " and received " + EconomyManager.formatted(RotationManager.getSellPrice()) + "&b.");
                EconomyManager.pay(event.getClicker(), PriceManager.getSellPrice());
                PriceManager.addCount(RotationManager.getAcceptedItem().name());
            }
        }
    }

    @EventHandler
    public void click(NPCLeftClickEvent event) {
        if(event.getNPC() == this.getNPC()) {
            Comm.send(event.getClicker(), "Accepted item: &964x " + getFormattedName(RotationManager.getAcceptedItem()) + "&b | Sell Price: " + EconomyManager.formatted(PriceManager.getSellPrice()) + "&8 (Next Up: &7" + getFormattedName(RotationManager.getAcceptedItem()) + "&8)");
        }
    }

    @Override
    public void onAttach() {
        Debug.log("The Sellonclick trait has been attached to the NPC.");
    }

    private String getFormattedName(Material material) {
        if ( material == null ) {
            return null;
        }
        StringBuilder friendlyName = new StringBuilder();
        for ( String word : material.name().split( "_" ) ) {
            friendlyName.append( word.substring( 0, 1 ).toUpperCase() + word.substring( 1 ).toLowerCase() + " " );
        }
        return friendlyName.toString().trim();
    }
}