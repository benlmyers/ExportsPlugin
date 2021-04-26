package com.characterlim.exportsplugin.command.util;

import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompletionsGenerator {

    public static List<String> generate(String[] arr, String arg) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        for(String str : arr) commands.add(str);
        StringUtil.copyPartialMatches(arg, commands, completions);
        return completions;
    }

    public static List<String> generate(Set<String> set, String arg) {
        return generate(set.toArray(new String[0]), arg);
    }
}
