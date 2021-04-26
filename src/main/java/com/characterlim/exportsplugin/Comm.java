package com.characterlim.exportsplugin;

import com.characterlim.exportsplugin.config.ConfigManager;
import org.bukkit.entity.Player;

public class Comm {

    public static void send(Player player, String message) {
        player.sendMessage(ConfigManager.getPrefix() + message);
    }
}
