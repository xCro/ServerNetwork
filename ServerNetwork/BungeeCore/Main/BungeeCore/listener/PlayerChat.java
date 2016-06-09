package ServerNetwork.BungeeCore.Main.BungeeCore.listener;

import ServerNetwork.BungeeCore.Main.BungeeCore.ProxyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Jake(BadEntites)
 */
public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(event.isCancelled() || !ProxyPlugin.getProfileHandler().getPlayers().containsKey(player.getUniqueId())) return;

        event.setFormat(ProxyPlugin.getProfileHandler().getCachedProfile(player.getUniqueId()).getRank().getTab() + " " + player.getName() + ChatColor.WHITE + ": " + event.getMessage());
    }

}
