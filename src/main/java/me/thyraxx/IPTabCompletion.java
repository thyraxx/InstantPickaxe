package me.thyraxx;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;

public class IPTabCompletion implements TabCompleter {

    private static List<String> list = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        getLogger().log(Level.WARNING, command.getName());

        if(command.getName().equalsIgnoreCase("ip") && strings.length > 0){
            if(list.isEmpty()) {
                for (Material mats : Material.values()) {
                    if(mats.isBlock()) {
                        list.add(mats.toString());
                    }
                }
            }
        }

        return StringUtil.copyPartialMatches(strings[0], list, new ArrayList<String>());
    }
}
