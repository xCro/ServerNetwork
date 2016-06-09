package ServerNetwork.MinigameCore.Spleef.timer;

import ServerNetwork.MinigameCore.Spleef.Core;
import ServerNetwork.MinigameCore.Spleef.events.SpleefPlayerWinEvent;
import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;
import org.bukkit.Bukkit;

public class CleanupTimer extends GameTimer {

  public CleanupTimer (Arena arena) {
    super (arena);
  }

  private String winner;

  @Override
  public void run () {
    int ticks = getArena ().getTicks ();
    if (ticks>=0){
	 if (ticks%2==0) {
	   if (getArena ().getPlayerList ().size () == 1) {
		if (winner==null){
		  Bukkit.getPluginManager ().callEvent (new SpleefPlayerWinEvent (getArena ().getPlayerList ().get (0), getArena ()));
		  winner = getArena ().getPlayerList ().get (0).getDisplayName ();
		}
		getArena ().broadcastMessage ("§8▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀");
		getArena ().broadcastMessage (" ");
		getArena ().broadcastMessage (" The player §l" + winner + "§f has won!");
		getArena ().broadcastMessage (" ");
		getArena ().broadcastMessage ("§8▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀");
	   } else {
		getArena ().broadcastMessage ("§8▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀");
		getArena ().broadcastMessage (" ");
		getArena ().broadcastMessage (" §7Nobody has won the game :(");
		getArena ().broadcastMessage (" ");
		getArena ().broadcastMessage ("§8▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀ ▀");
	   }
	 }
	 getArena ().broadcastMessage (MessageApi.prefix + " Do (/spleef quit) leave early. Time left " + MessageApi.timerTrans (ticks));
	 if (ticks==0){
	   Core.getOurInstance ().getArenaManager ().cleanUp (getArena ());
	 }
	 getArena ().setTicks (ticks-=1);
    }
  }
}
