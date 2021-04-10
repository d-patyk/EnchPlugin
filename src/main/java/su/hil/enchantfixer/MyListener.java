package su.hil.enchantfixer;

import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;




public class MyListener implements Listener {
    int i = 0; // DEBUG
    @EventHandler
    public void PlayerItemHeldEvent(PlayerItemHeldEvent playerItemHeldEvent) {
        System.out.println(String.format("+event number %d", i++)); // DEBUG

        Player player = playerItemHeldEvent.getPlayer();
        PlayerInventory playerInventory = player.getInventory();


        for (ItemStack item : playerInventory.getContents()) {
            if (item == null || item.getType() == Material.AIR)
                continue;

            NBTCompound nbt = PowerNBT.getApi().read(item);

            if (nbt.containsKey("TokensHaste") && item.containsEnchantment(Enchantment.DIG_SPEED)) {
                System.out.println("Ench removed from player ДКВ");
                item.removeEnchantment(Enchantment.DIG_SPEED);
            }
        }
    }
}
