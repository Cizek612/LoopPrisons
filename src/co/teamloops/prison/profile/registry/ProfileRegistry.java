package co.teamloops.prison.profile.registry;


import co.teamloops.commons.patterns.Registry;
import co.teamloops.prison.profile.ProfileAddon;
import co.teamloops.prison.profile.user.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileRegistry implements Registry<UUID, Profile> {

    private final transient ProfileAddon addon;
    private final Map<UUID, Profile> users;


    public ProfileRegistry(final ProfileAddon addon) {
        this.addon = addon;
        this.users = new HashMap<>();
    }

    @Override
    public Map<UUID, Profile> getRegistry() {
        return this.users;
    }
}