package ServerNetwork.MinigameCore.Spleef.timer;

import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import ServerNetwork.MinigameCore.Spleef.utils.GameState;
import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;

public class IngameTimer extends GameTimer {

  public IngameTimer (Arena arena) {
    super (arena);
  }

  @Override
  public void run () {
    int ticks = getArena ().getTicks ();
    if (ticks>=0){
	 if ((ticks%30==0||ticks<=10)&&ticks>0){
	   getArena ().broadcastMessage (MessageApi.prefix + " The game ends in §l" + MessageApi.timerTrans (ticks) + "§r!");
	 }
	 if (ticks==0||getArena ().getPlayerList ().size ()<=1){

	   getArena ().broadcastMessage (MessageApi.prefix + "§l Cleanup has started!");
	   getArena ().setCurrentState (GameState.CLEANUP);
	   getArena ().setTicks (10);
	   this.cancel ();
	   return;
	 }
	 getArena ().setTicks (ticks--);
    }
  }
}
