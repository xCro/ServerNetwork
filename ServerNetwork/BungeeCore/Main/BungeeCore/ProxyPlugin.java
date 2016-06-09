package ServerNetwork.BungeeCore.Main.BungeeCore;

import ServerNetwork.BungeeCore.Main.BungeeCore.database.HubDB;
import ServerNetwork.BungeeCore.Main.BungeeCore.database.player.ProfileHandler;
import ServerNetwork.BungeeCore.Main.BungeeCore.game.scoreboard.RankScoreboard;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Jake(BadEntites)
 */
public class ProxyPlugin extends Plugin {

    public static ProxyPlugin instance;
    public static ProfileHandler profileHandler;

    private static RankScoreboard scoreboard;

    private static HubDB HubDB;

    @Override
    public void onEnable() {
        getProxy().registerChannel("Hub");

        instance = this;
        HubDB = new HubDB();
        profileHandler = new ProfileHandler();
        scoreboard = new RankScoreboard();
    }

    public static ProxyPlugin getInstance() {
        return instance;
    }

    public static HubDB getHubDB() {

        return HubDB;
    }

    public static ProfileHandler getProfileHandler() {

        return profileHandler;
    }


    public static RankScoreboard getScoreboard()
    {
        return scoreboard;
    }

}
