package com.characterlim.exportsplugin.manager;

import com.characterlim.exportsplugin.communication.Comm;
import com.characterlim.exportsplugin.debug.Debug;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class EconomyManager {

    private static Economy econ = null;

    public static boolean prepare(Plugin plugin) {
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            Debug.warn("The registered service provider for Vault could not be found!");
            return false;
        }
        econ = rsp.getProvider();
        if(econ != null) {
            Debug.log("The registered service provider for Vault has been hooked successfully.");
        }
        return econ != null;
    }

    public static void pay(Player player, float amount) {
        EconomyResponse r = econ.depositPlayer(player, amount);
        if(r.transactionSuccess()) {
            Comm.send(player, "You have been paid &e" + econ.format(r.amount) + " for your exports!");
        } else {
            Comm.send(player, "An error occurred: &c" + r.errorMessage);
        }
    }
}
