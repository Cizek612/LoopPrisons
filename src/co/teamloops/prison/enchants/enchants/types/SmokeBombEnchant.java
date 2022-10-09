package co.teamloops.prison.enchants.enchants.types;

import co.teamloops.commons.utils.ShapeUtil;
import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.enchants.context.EnchantContext;
import co.teamloops.prison.enchants.enchants.LoopEnchant;
import co.teamloops.prison.enchants.enums.EnchantType;
import org.bukkit.*;
import org.bukkit.block.Block;

public class SmokeBombEnchant extends LoopEnchant {

    public SmokeBombEnchant(final LoopPrisons plugin) {
        super(plugin, "SMOKE_BOMB", EnchantType.BREAK, 1000);
    }

    @Override
    public void execute(final EnchantContext context) {

        final Location location = context.getTargetBlock().getLocation();

        for (final Block block : ShapeUtil.createSphere(location, 10)) {
            block.setType(Material.AIR);
        }
    }
}