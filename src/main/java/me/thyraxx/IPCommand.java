package me.thyraxx;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;

public class IPCommand implements CommandExecutor {

    private IPBlackList blackList = new IPBlackList();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender.hasPermission("instantpickaxe.blacklist")) {

            if (s.equalsIgnoreCase("ip") && strings.length > 0) {
                Material material = Material.getMaterial(strings[0]);
                if (material != null && material.isBlock()) {
                    IPBlackList.blockBlackList.add(material);
                    blackList.addBlockToBlackList(material);

                    for (Material mats : IPBlackList.blockBlackList) {
                        getLogger().log(Level.WARNING, mats.toString());
                    }

                    return true;
                }
//                else {
//                    return false;
//                }
            }
        }

        if (commandSender.hasPermission("instantpickaxe.ip")) {
            getLogger().log(Level.WARNING, "" + commandSender.hasPermission("instantpickaxe.blacklist"));

            if (s.equalsIgnoreCase("ip") && strings.length == 0) {
                if (commandSender instanceof Player) {

                    Player player = (Player) commandSender;
                    if (!PlayerUUIDList.uuidList.contains(player.getUniqueId())) {
                        PlayerUUIDList.uuidList.add(player.getUniqueId());
                        player.sendMessage("IP is " + ChatColor.GREEN + "ON");
                    } else {
                        PlayerUUIDList.uuidList.remove(player.getUniqueId());
                        player.sendMessage("IP is " + ChatColor.RED + "OFF");
                    }

                    return true;
                }
            }
        }

//        if (s.equals("blacklist") && strings[0].equals("add") && strings[1].length() != 0) {
//            //TODO: This is error prone, fix
//            Material material = Material.matchMaterial(strings[1]);
//            getLogger().log(Level.WARNING, strings.toString());
//
//            return true;
//        }

        return false;
    }
}
