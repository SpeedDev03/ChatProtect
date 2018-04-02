package speeddev.info.ChatProtect.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;
import speeddev.info.ChatProtect.Events.Configgets;

public class CommandSpy implements CommandExecutor
{
	  public CommandSpy(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("commandspy")) {
	      if (p.hasPermission("chatprotect.commandspy"))
	      {
	        if (Configgets.cmdspy.contains(p))
	        {
	          Configgets.cmdspy.remove(p);
	          p.sendMessage(Configgets.Prefix + "You are no longer spying on users commands!");
	        }
	        else
	        {
	          Configgets.cmdspy.add(p);
	          p.sendMessage(Configgets.Prefix + "You are now spying on users commands!");
	        }
	      }
	      else {
	        p.sendMessage(Configgets.Prefix + Configgets.NoAccess);
	      }
	    }
	    return true;
	  }
	}
