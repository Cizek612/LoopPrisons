package co.teamloops.prison.listeners;

import co.teamloops.commons.abstracts.LoopListener;
import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.profile.ProfileAddon;
import co.teamloops.prison.profile.registry.ProfileRegistry;
import co.teamloops.prison.profile.user.Profile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener extends LoopListener<LoopPrisons> {

    private final LoopPrisons plugin;
    private final ProfileAddon addon;
    private final ProfileRegistry registry;

    public JoinListener(final LoopPrisons plugin) {
        super(plugin);

        this.plugin = plugin;
        this.addon = plugin.getProfileAddon();
        this.registry = addon.getRegistry();

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        if (this.registry.containsKey(player.getUniqueId())) return;

        this.registry.register(
                player.getUniqueId(),
                new Profile(this.addon, player.getUniqueId())
        );
    }
}
