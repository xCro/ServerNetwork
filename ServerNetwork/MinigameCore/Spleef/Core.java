package ServerNetwork.MinigameCore.Spleef;

import ServerNetwork.MinigameCore.Spleef.commands.CommandManager;
import ServerNetwork.MinigameCore.Spleef.utils.Arena;
import ServerNetwork.MinigameCore.Spleef.utils.ArenaManager;
import ServerNetwork.MinigameCore.Spleef.utils.ConfigApi;
import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.logging.Level;

public class Core extends JavaPlugin{

  private static Core ourInstance;

  public static Core getOurInstance () {
    return ourInstance;
  }

  private ArenaManager arenaManager;
  private Villager gameNPC;

  public final int MIN_PLAYERS = 1;

  public Villager getGameNPC () {
    return gameNPC;
  }

  public ArenaManager getArenaManager () {
    return arenaManager;
  }

  @Override
  public void onLoad () {
    super.onLoad ();
  }

  @Override
  public void onDisable () {
    if (gameNPC!=null){
	 gameNPC.remove ();gameNPC=null;
    }
    for (Arena a : arenaManager.getArenas ()){
	 Core.getOurInstance ().getArenaManager ().cleanUp (a);
    }
  }

  @Override
  public void onEnable () {
    ourInstance=this;
    arenaManager = new ArenaManager ();

    getCommand ("spleef").setExecutor (new CommandManager());
    spawnNPC ();

    Bukkit.getPluginManager ().registerEvents (new GameListener (), this);
  }

  public void spawnNPC(){
    if (gameNPC!=null){
	 gameNPC.remove ();gameNPC=null;
    }
    try {
	 Villager villager = ConfigApi.getLocationPath ("npc").getWorld ().spawn (ConfigApi.getLocationPath ("npc"), Villager.class);
	 villager.setCustomName ("" + ChatColor.GREEN + ChatColor.BOLD + "Select A Game");
	 villager.setCustomNameVisible (true);
	 villager.addPotionEffect (new PotionEffect (PotionEffectType.SLOW, 1000000000, 1000000000, false, false));
	 gameNPC=villager;
    }catch (NullPointerException ignore){
	 getLogger ().log (Level.WARNING, MessageApi.prefix + "§cGameNPC is not set!");
    }

  }

}
