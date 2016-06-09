package ServerNetwork.MinigameCore.Spleef.timer;

import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class GameTimer extends BukkitRunnable {

  private Arena arena;

  public GameTimer (Arena arena) {
    this.arena = arena;
  }

  public Arena getArena () {
    return arena;
  }


}
