package co.teamloops.prison.enchants.listeners;

import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.enchants.context.EnchantContext;
import co.teamloops.prison.enchants.enchants.LoopEnchant;
import co.teamloops.prison.enchants.enums.EnchantType;
import co.teamloops.prison.enchants.registry.EnchantRegistry;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class EnchantListener implements Listener {

    private final LoopPrisons plugin;
    private final EnchantRegistry enchantRegistry;

    public EnchantListener(final LoopPrisons plugin) {
        this.plugin = plugin;
        this.enchantRegistry = plugin.getEnchantAddon().getRegistry();

        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onBreak(final BlockBreakEvent event) {

        final NBTItem nbtItem = new NBTItem(event.getPlayer().getItemInHand());

        if (!nbtItem.hasKey("pickaxe")) return;

        final List<LoopEnchant> accessableEnchants = new ArrayList<>();

        for (final LoopEnchant value : this.enchantRegistry.values()) {
            if (value.getType() != EnchantType.BREAK) continue;
            accessableEnchants.add(value);
        }

        final EnchantContext context = new EnchantContext(
                event.getPlayer(),
                event.getPlayer().getInventory().getItemInHand(),
                event.getBlock(),
                nbtItem.getInteger("level")
        );

        // ADD PICKAXE SKIN, AND OTHER PICKAXE INFORMATION LIKE LEVELS TO ENCHANT CONTEXT
        for(final LoopEnchant value : accessableEnchants) {
            if(!nbtItem.hasKey(value.getName())) return;

            this.enchantRegistry.get(value.getName()).get().execute(context);
        }
    }
}

