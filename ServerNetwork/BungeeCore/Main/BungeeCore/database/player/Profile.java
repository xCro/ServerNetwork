package ServerNetwork.BungeeCore.Main.BungeeCore.database.player;

import ServerNetwork.BungeeCore.Main.BungeeCore.game.Rank;

import java.util.UUID;

/**
 * Created by Jake(BadEntites)
 */
public class Profile {

    public UUID uuid;
    public Rank rank;

    public Profile(UUID uuid, Rank rank) {
        this.uuid = uuid;
        this.rank = rank;
    }

    public UUID getUuid() {

        return this.uuid;
    }
    
    public Rank getRank() {

        return this.rank;
    }

}
