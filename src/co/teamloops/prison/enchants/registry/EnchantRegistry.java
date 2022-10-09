package co.teamloops.prison.enchants.registry;

import co.teamloops.commons.patterns.Registry;
import co.teamloops.prison.enchants.enchants.LoopEnchant;

import java.util.HashMap;
import java.util.Map;

public class EnchantRegistry implements Registry<String, LoopEnchant> {

    private final Map<String, LoopEnchant> enchants;

    public EnchantRegistry() {
        this.enchants = new HashMap<>();
    }

    @Override
    public Map<String, LoopEnchant> getRegistry() {
        return this.enchants;
    }
}
