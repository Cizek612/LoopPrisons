package co.teamloops.prison.enchants.enchants.types;

import co.teamloops.commons.blocks.BlockChanger;
import co.teamloops.commons.utils.ShapeUtil;
import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.enchants.context.EnchantContext;
import co.teamloops.prison.enchants.enchants.LoopEnchant;
import co.teamloops.prison.enchants.enums.EnchantType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class AntimatterEnchant extends LoopEnchant {

    public AntimatterEnchant(final LoopPrisons plugin) {
        super(plugin, "ANTIMATTER", EnchantType.BREAK, 1000);
    }

    @Override
    public void execute(final EnchantContext context) {

        final Location location = context.getTargetBlock().getLocation();

        for (final Block block : ShapeUtil.createLayer(location, 10)) {
            BlockChanger.setBlock(block.getLocation(), Material.AIR);
        }
    }
}