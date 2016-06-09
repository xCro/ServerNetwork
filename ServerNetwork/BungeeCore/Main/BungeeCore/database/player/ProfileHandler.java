package ServerNetwork.BungeeCore.Main.BungeeCore.database.player;

import ServerNetwork.BungeeCore.Main.BungeeCore.ProxyPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Jake(BadEntites)
 */
public class ProfileHandler {

    public Map<UUID, Profile> profileMap;

    public ProfileHandler() {
        profileMap = new HashMap<>();
    }

    public Map<UUID, Profile> getPlayers()
    {
        return this.profileMap;
    }

    public void add(UUID uuid) {
        if(profileMap.containsKey(uuid)) return;
        profileMap.put(uuid, ProxyPlugin.getHubDB().getProfile(uuid));
    }

    public void remove(UUID uuid) {
        if(!profileMap.containsKey(uuid)) return;
        profileMap.remove(uuid);
    }

    public Profile getCachedProfile(UUID uuid) {
        if(profileMap.containsKey(uuid))
            return getPlayers().get(uuid);

        return null;
    }

}
