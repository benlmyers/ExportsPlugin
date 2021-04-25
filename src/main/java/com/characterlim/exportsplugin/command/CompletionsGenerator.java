package com.characterlim.exportsplugin.command;

import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class CompletionsGenerator {

    public static List<String> generate(String[] arr, String arg) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        for(String str : arr) commands.add(str);
        StringUtil.copyPartialMatches(arg, commands, completions);
        return completions;
    }
}
