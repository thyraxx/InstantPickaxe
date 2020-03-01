package me.thyraxx;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class IPBlackList {

    private static Set<Block> blockBlackList = new HashSet<Block>();

    public void addBlockToBlackList(Block block){
        blockBlackList.add(block);
    }

    public Set<Block> getBlockBlackList(){
        return blockBlackList;
    }

    public void saveBlockBlackListToJSON() throws IOException {
    }

    public void reloadBlockBlackList() throws FileNotFoundException {
    }

}
