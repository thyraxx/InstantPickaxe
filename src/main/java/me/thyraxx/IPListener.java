package me.thyraxx;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;

public class IPListener implements Listener {

    private int unbreakingLevel = 0;

    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {
        Player player = event.getPlayer();
        ItemStack getItemInMainHand = player.getInventory().getItemInMainHand();
        Material pickaxeType = getItemInMainHand.getType();
        ItemMeta itemMeta = getItemInMainHand.getItemMeta();

        if (itemMeta instanceof Damageable) {
            Damageable damageable = (Damageable) itemMeta;

            boolean hasPickaxeInMainHand = (pickaxeType == Material.WOODEN_PICKAXE)
                    || (pickaxeType == Material.STONE_PICKAXE)
                    || (pickaxeType == Material.IRON_PICKAXE)
                    || (pickaxeType == Material.GOLDEN_PICKAXE)
                    || (pickaxeType == Material.DIAMOND_PICKAXE);

            if (hasPickaxeInMainHand) {
                if (PlayerUUIDList.uuidList.contains(player.getUniqueId())) {

                    if(getItemInMainHand.containsEnchantment(Enchantment.DURABILITY)){
                        this.unbreakingLevel = getItemInMainHand.getEnchantmentLevel(Enchantment.DURABILITY);
                    }

                    //TODO: Doesn't work as it should
                    int damageChance = (100 / (this.unbreakingLevel+1));
                    if((int)(Math.random() * 100) < damageChance) {
                        getLogger().log(Level.WARNING, "damaged");
                        damageable.setDamage(damageable.getDamage() + 1);
                        getItemInMainHand.setItemMeta(itemMeta);
                    }

                    event.setInstaBreak(true);
                    event.getBlock().breakNaturally();
                } else {
                    event.setInstaBreak(false);
                }
            }
        }
    }


}
