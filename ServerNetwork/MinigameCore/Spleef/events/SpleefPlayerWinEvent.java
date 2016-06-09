package ServerNetwork.MinigameCore.Spleef.events;

import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpleefPlayerWinEvent extends Event {

  private Player player;
  private Arena arena;

  public SpleefPlayerWinEvent (Player player, Arena arena) {
    this.player = player;
    this.arena = arena;
  }

  public Player getPlayer () {
    return player;
  }

  public Arena getArena () {
    return arena;
  }

  private static HandlerList handlerList = new HandlerList ();

  public static HandlerList getHandlerList () {
    return handlerList;
  }

  @Override
  public HandlerList getHandlers () {
    return getHandlerList ();
  }
}
