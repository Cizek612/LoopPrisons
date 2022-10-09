package co.teamloops.prison;

import co.teamloops.prison.addon.registry.AddonRegistry;
import co.teamloops.prison.enchants.EnchantAddon;
import co.teamloops.prison.listeners.JoinListener;
import co.teamloops.prison.profile.ProfileAddon;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class LoopPrisons extends JavaPlugin {

    public AddonRegistry addonRegistry;
    public ProfileAddon profileAddon;
    public EnchantAddon enchantAddon;

    @Override
    public void onEnable() {

        this.registerAddons();
        this.loadBuiltInAddons();
        this.loadListeners();
    }

    @Override
    public void onDisable() {
        this.addonRegistry.disable();
    }

    private void registerAddons() {
        this.addonRegistry = new AddonRegistry(this);
    }

    private void loadBuiltInAddons() {
        this.profileAddon = new ProfileAddon(this);
        this.enchantAddon = new EnchantAddon(this);

        this.addonRegistry.load();
    }

    private void loadListeners() {
        new JoinListener(this);
    }

}