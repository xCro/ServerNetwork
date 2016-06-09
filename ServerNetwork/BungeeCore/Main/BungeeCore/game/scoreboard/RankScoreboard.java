package ServerNetwork.BungeeCore.Main.BungeeCore.game.scoreboard;

import ServerNetwork.BungeeCore.Main.BungeeCore.game.Rank;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Created by Jake(BadEntites)
 */
public class RankScoreboard {

    Scoreboard scoreboard;

    public RankScoreboard() {
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        for(Rank rank : Rank.values()) {
            if (scoreboard.getTeam(rank.getName()) == null) {
                scoreboard.registerNewTeam(rank.getName());
                scoreboard.getTeam(rank.getName()).setPrefix(rank.getTab() + " ");
            }
        }
    }

    public Scoreboard getScoreboard() {

        return this.scoreboard;
    }


}
