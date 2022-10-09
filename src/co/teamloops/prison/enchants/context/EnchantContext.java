package co.teamloops.prison.enchants.context;

import lombok.Data;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Data
public class EnchantContext {

    private final Player player;
    private final ItemStack pickaxe;
    private final Block targetBlock;
    private final int pickaxeLevel;


}
