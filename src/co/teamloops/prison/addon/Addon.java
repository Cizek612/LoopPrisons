package co.teamloops.prison.addon;


import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.addon.registry.AddonRegistry;
import lombok.Getter;

@Getter
public abstract class Addon {

    protected final LoopPrisons plugin;
    protected final AddonRegistry addonRegistry;
    protected final String name;

    public Addon(final LoopPrisons plugin, final String name) {
        this.plugin = plugin;
        this.addonRegistry = plugin.getAddonRegistry();
        this.name = name;

        this.addonRegistry.register(this.name, this);
    }

    public abstract void onEnable();
    public abstract void onDisable();

    public abstract void onRegister();
    public abstract void onUnregister();
}