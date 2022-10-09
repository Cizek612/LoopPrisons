package co.teamloops.prison.addon.registry;

import co.teamloops.commons.patterns.Registry;
import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.addon.Addon;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AddonRegistry implements Registry<String, Addon> {

    private final transient LoopPrisons plugin;
    @Getter private final Map<String, Addon> registry;


    public AddonRegistry(final LoopPrisons plugin) {
        this.plugin = plugin;
        this.registry = new HashMap<>();
    }


    @Override
    public void register(@NotNull String key, @NotNull Addon value) {
        Registry.super.register(key, value);

        value.onRegister();
    }

    @Override
    public void unregister(@NotNull String key) {
        this.get(key).get().onUnregister();

        Registry.super.unregister(key);
    }

    public void load() {
        for (final Addon addon : this.registry.values()) {
            addon.onEnable();
        }
    }

    public void disable() {
        for (final Addon addon : this.registry.values()) {
            addon.onDisable();
        }
    }
}