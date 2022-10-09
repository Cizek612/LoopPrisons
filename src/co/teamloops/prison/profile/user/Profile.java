package co.teamloops.prison.profile.user;

import co.teamloops.prison.profile.ProfileAddon;
import lombok.Data;

import java.util.UUID;

@Data
public class Profile {

    private transient final ProfileAddon addon;
    private final UUID uuid;
    private int rawBlocksBroken;
    private long tokens;

    public Profile(final ProfileAddon addon, final UUID uuid) {
        this.addon = addon;
        this.uuid = uuid;
        this.rawBlocksBroken = 0;
        this.tokens = 0L;

        this.addon.getRegistry().register(this.uuid, this);
    }

    public void setTokens(final long amount) {
        this.tokens = amount;
    }

    public void addTokens(final long amount) {
        this.tokens += amount;
    }

    public void removeTokens(final long amount) {
        this.tokens -= amount;
    }
}
