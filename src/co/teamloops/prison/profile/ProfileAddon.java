package co.teamloops.prison.profile;

import co.teamloops.prison.LoopPrisons;
import co.teamloops.prison.addon.Addon;
import co.teamloops.prison.profile.registry.ProfileRegistry;
import co.teamloops.prison.profile.user.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

@Getter
public class ProfileAddon extends Addon {

    public ProfileRegistry registry;

    public ProfileAddon(final LoopPrisons plugin) {
        super(plugin, "Profile");
    }

    @Override @SneakyThrows
    public void onEnable() {
        final File file = new File(plugin.getDataFolder(), "player-data.json");

        if (!file.exists()) {
            file.getParentFile().mkdir();
            plugin.saveResource("player-data.json", false);
            return;
        }

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final Profile[] profiles = gson.fromJson(new FileReader(file), Profile[].class);

        for (final Profile profile : profiles) {
            this.registry.getRegistry().put(profile.getUuid(), profile);
        }
    }

    @Override @SneakyThrows
    public void onDisable() {
        final File file = new File(plugin.getDataFolder(), "player-data.json");

        if (!file.exists()) {
            file.getParentFile().mkdir();
            plugin.saveResource("player-data.json", false);
        }

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (final Writer writer = new FileWriter(file)) {
            gson.toJson(this.registry.values(), writer);
            writer.flush();
        }
    }

    @Override
    public void onRegister() {
        this.registry = new ProfileRegistry(this);
    }

    @Override
    public void onUnregister() {
    }
}