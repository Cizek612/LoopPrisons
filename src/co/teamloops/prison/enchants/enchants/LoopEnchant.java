package co.teamloops.prison.enchants.enchants;

import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.enchants.context.EnchantContext;
import co.teamloops.prison.enchants.enums.EnchantType;
import lombok.Getter;


@Getter
public abstract class LoopEnchant {

    protected final LoopPrisons plugin;
    protected String name;
    protected EnchantType type;
    protected int maxLevel;

    public LoopEnchant(final LoopPrisons plugin, final String name, final EnchantType type, final int maxLevel) {
        this.plugin = plugin;
        this.name = name;
        this.type = type;
        this.maxLevel = maxLevel;
    }

    public abstract void execute(final EnchantContext context);
}
