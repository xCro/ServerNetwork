package ServerNetwork.BungeeCore.Main.BungeeCore.listener;

import ServerNetwork.BungeeCore.Main.BungeeCore.ProxyPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Jake(BadEntites)
 */
public class PlayerLogin implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if(!ProxyPlugin.getHubDB().isInside(player.getUniqueId())) {
            ProxyPlugin.getHubDB().injectPlayer(player.getUniqueId());
        }

        ProxyPlugin.getProfileHandler().add(player.getUniqueId());
        event.getPlayer().setScoreboard(ProxyPlugin.getScoreboard().getScoreboard());
        event.getPlayer().getScoreboard().getTeam(ProxyPlugin.getProfileHandler().getCachedProfile(player.getUniqueId()).getRank().getName());
    }

}
