package ServerNetwork.MinigameCore.Spleef.commands;

import ServerNetwork.MinigameCore.Spleef.Core;
import ServerNetwork.MinigameCore.Spleef.utils.ConfigApi;
import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class SpleefSetNPC extends SpleefCommand {

  public SpleefSetNPC () {
    super ("setNPC", "spleef.create", new String[]{""});
  }

  @Override
  public void executor (CommandSender sender, String[] strings) {
    if (!(sender instanceof Player)){
	 sender.sendMessage (MessageApi.prefix + "§cYou must be logged in to execute this command.");
	 return;
    }
    Player pl = (Player) sender;

    ConfigApi.setPath ("npc", pl.getLocation ());
    Core.getOurInstance ().spawnNPC ();
    pl.sendMessage (MessageApi.prefix + "§aYou have created a NPC§a at "
    + "§7(§f§l" + pl.getWorld ().getName () + "§7,§f§l" + Math.round (pl.getLocation ().getX ()) + "§7,§f§l" + Math.round (pl.getLocation ().getY ()) + "§7,§f§l" + Math.round (pl.getLocation ().getZ ()) + "§7)§a.");
  }
}
