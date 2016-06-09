package ServerNetwork.MinigameCore.Spleef.commands;

import ServerNetwork.MinigameCore.Spleef.utils.MessageApi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {

  private static List<SpleefCommand> commandList;

  public static SpleefCommand getCommand(String label){
    for (SpleefCommand spleefCommand : commandList){
	 if (spleefCommand.getLabel ().equalsIgnoreCase (label)){
	   return spleefCommand;
	 }
    }
    return null;
  }

  public static List<SpleefCommand> getCommandList () {
    return commandList;
  }

  public CommandManager () {
    commandList = new ArrayList<SpleefCommand> ();
    commandList.add (new SpleefHelp ());
    commandList.add (new SpleefQuit ());
    commandList.add (new SpleefCreate ());
    commandList.add (new SpleefSetLobby ());
    commandList.add (new SpleefSetNPC ());
    commandList.add (new SpleefStats ());
  }

  public boolean onCommand (CommandSender commandSender, Command command, String s, String[] strings) {
    if (command.getName ().equalsIgnoreCase ("spleef")){
	 if (strings.length<1){
	   commandSender.sendMessage (MessageApi.prefix + "§cYou must have more arguments.");
	   new SpleefHelp ().executor (commandSender, strings);
	   return true;
	 }
	 SpleefCommand spleefCommand = getCommand (strings[0]);
	 if (spleefCommand==null){
	   commandSender.sendMessage (MessageApi.prefix + "§cYou didn't include a valid command.");
	   new SpleefHelp ().executor (commandSender, strings);
	   return true;
	 }else {
	   if (!commandSender.hasPermission (spleefCommand.getPermission ())){
		commandSender.sendMessage (MessageApi.noPerm);
	    return true;
	   }
	   spleefCommand.executor (commandSender, strings);
	   return true;
	 }
    }
    return false;
  }
}
