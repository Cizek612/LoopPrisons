package co.teamloops.prison.enchants;


import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.addon.Addon;
import co.teamloops.prison.enchants.enchants.types.AntimatterEnchant;
import co.teamloops.prison.enchants.enchants.types.SmokeBombEnchant;
import co.teamloops.prison.enchants.listeners.EnchantListener;
import co.teamloops.prison.enchants.registry.EnchantRegistry;
import lombok.Getter;

@Getter
public class EnchantAddon extends Addon {

    public EnchantRegistry registry;

    public EnchantAddon(final LoopPrisons plugin) {
        super(plugin, "Enchants");
    }

    @Override
    public void onEnable() {
        this.registry.register("SMOKE_BOMB", new SmokeBombEnchant(this.plugin));
        this.registry.register("ANTIMATTER", new AntimatterEnchant(this.plugin));

        new EnchantListener(this.plugin);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onRegister() {
        this.registry = new EnchantRegistry();
    }

    @Override
    public void onUnregister() {

    }
}
