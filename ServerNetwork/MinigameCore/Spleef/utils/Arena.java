package ServerNetwork.MinigameCore.Spleef.utils;

import ServerNetwork.MinigameCore.Spleef.events.SpleefArenaGameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Arena {

  private Location spawn;
  private String name;
  public List<Player> playerList = new ArrayList<Player> ();
  public List<BlockState> blocks = new ArrayList<BlockState> ();
  private GameState currentState;
  private int ticks;

  public Arena (Location spawn, String name) {
    this.spawn = spawn;
    this.name = name;
    this.currentState = GameState.WAITING;
    this.ticks = 20;
  }

  public Location getSpawn () {
    return spawn;
  }

  public String getName () {
    return name;
  }

  public List<Player> getPlayerList () {
    return playerList;
  }

  public List<BlockState> getBlocks () {
    return blocks;
  }

  public GameState getCurrentState () {
    return currentState;
  }

  public void setCurrentState (GameState currentState) {
    Bukkit.getPluginManager ().callEvent (new SpleefArenaGameStateChangeEvent (this, currentState));
    this.currentState = currentState;
  }

  public int getTicks () {
    return ticks;
  }

  public void setTicks (int ticks) {
    this.ticks = ticks;
  }

  public void broadcastMessage(String message){
    for(Player p : getPlayerList ()){
	 p.sendMessage (message);
    }
  }
}
