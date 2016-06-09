package ServerNetwork.MinigameCore.Spleef.commands;

import ServerNetwork.MinigameCore.Spleef.Core;
import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class SpleefQuit extends SpleefCommand {

  public SpleefQuit () {
    super ("quit", new String[]{""});
  }

  @Override
  public void executor (CommandSender sender, String[] strings) {
    if (!(sender instanceof Player)){
	 sender.sendMessage (MessageApi.prefix + "§cYou must be logged in to execute this command.");
	 return;
    }

    Player p = (Player) sender;
    Arena a = Core.getOurInstance ().getArenaManager ().getArena (p);

    if (a==null){
	 sender.sendMessage (MessageApi.prefix + "§cYou must be in an arena to leave one...");
	 return;
    }

    Core.getOurInstance ().getArenaManager ().quitArena (p);
    p.sendMessage (MessageApi.prefix + "You have left the arena §l" + a.getName () + "§r!");
  }
}
