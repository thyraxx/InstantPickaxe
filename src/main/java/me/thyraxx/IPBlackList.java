package me.thyraxx;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IPBlackList {

    private File file = new File(InstantPickaxe.getPlugin(InstantPickaxe.class).getDataFolder() + File.separator + "config.yml");

    public static Set<Material> blockBlackList = new HashSet<Material>();

    public void addBlockToBlackList(Material material) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Collection<String> list = config.getStringList("blacklist");
        if (!list.contains(material.toString())) {

            list.add(material.toString());
            config.set("blacklist", list);

            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        blockBlackList.clear();

        for (String materialName : list) {
            blockBlackList.add(Material.getMaterial(materialName));
        }
    }

    public void saveBlockBlackListToJSON() throws IOException {
    }

    public void reloadBlockBlackList() throws FileNotFoundException {
    }

}
