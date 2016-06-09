package ServerNetwork.MinigameCore.Spleef.events;

import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import ServerNetwork.MinigameCore.Spleef.utils.GameState;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpleefArenaGameStateChangeEvent extends Event implements Cancellable {

  private Arena arena;
  private GameState newState;

  public SpleefArenaGameStateChangeEvent (Arena arena, GameState newState) {
    this.arena = arena;
    this.newState = newState;
  }

  public Arena getArena () {
    return arena;
  }

  public GameState getNewState () {
    return newState;
  }

  @Override
  public boolean isCancelled () {
    return false;
  }

  @Override
  public void setCancelled (boolean b) {

  }

  private static HandlerList handlerList = new HandlerList ();

  public static HandlerList getHandlerList () {
    return handlerList;
  }

  @Override
  public HandlerList getHandlers () {
    return handlerList;
  }
}
