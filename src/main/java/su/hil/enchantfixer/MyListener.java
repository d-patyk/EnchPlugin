package su.hil.enchantfixer;

import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;




public class MyListener implements Listener {
    @EventHandler
    public void PlayerItemHeldEvent(PlayerItemHeldEvent playerItemHeldEvent) {
        Player player = playerItemHeldEvent.getPlayer();
        PlayerInventory playerInventory = player.getInventory();


        for (ItemStack item : playerInventory.getContents()) {
            if (item == null || item.getType() == Material.AIR)
                continue;

            NBTCompound nbt = PowerNBT.getApi().read(item);

            if (nbt.containsKey("TokensHaste") && item.containsEnchantment(Enchantment.DIG_SPEED)) {
                System.out.println(String.format("[EnchantFixer] Efficiency has been removed from player %s. Previous nbt: %s", player.getName(), nbt.toString()));
                item.removeEnchantment(Enchantment.DIG_SPEED);
            }
        }
    }
}
