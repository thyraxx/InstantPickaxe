package me.thyraxx;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class InstantPickaxe extends JavaPlugin {

    @Override
    public void onEnable(){

        getServer().getPluginManager().registerEvents(new IPListener(), this);

        this.getCommand("ip").setExecutor(new IPCommand());
        this.getCommand("blacklist").setExecutor(new IPCommand());

        getLogger().log(Level.WARNING, getServer().getPluginManager().getPlugins().toString());
//        FileConfiguration fileConfig = this.getConfig();
    }


    @Override
    public void onDisable(){
        getLogger().log(Level.INFO, "InstantPickaxe Disabled");
    }
}
