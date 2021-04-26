package com.characterlim.exportsplugin;

import com.characterlim.exportsplugin.config.ConfigManager;
import org.bukkit.entity.Player;

public class Comm {

    public static void send(Player player, String message) {
        player.sendMessage(colorify(ConfigManager.getPrefix() + message));
    }

    public static void sendPrefixless(Player player, String message) {
        player.sendMessage(colorify(message));
    }

    public static void sendHelp(Player player, String command, String explanation) {
        sendPrefixless(player, "§e/" + command + ": §7" + explanation);
    }

    public static String colorify(String message) {
        return message.replaceAll("&", "§");
    }
}
