package ServerNetwork.MinigameCore.Spleef.commands;

import org.bukkit.command.CommandSender;

public final class SpleefHelp extends SpleefCommand {

  public SpleefHelp () {
    super ("help", new String[]{""});
  }

  @Override
  public void executor (CommandSender sender, String[] strings) {
    sender.sendMessage (" ");
    sender.sendMessage ("§7-----§e§lSpleef Help§7-----");
    for (SpleefCommand command : CommandManager.getCommandList ()){
	 if (sender.hasPermission (command.getPermission ())) {
	   String args = " ";
	   for (String str : command.getStrings ()) {
		args = args + str;
	   }
	   sender.sendMessage ("§7 • §f/spleef " + command.getLabel () + args);
	 }
    }
    sender.sendMessage (" ");
  }
}
