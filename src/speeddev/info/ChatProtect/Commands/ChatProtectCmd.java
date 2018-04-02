package speeddev.info.ChatProtect.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;


public class ChatProtectCmd  implements CommandExecutor
{
	  public ChatProtectCmd(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("ChatProtect")) {
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[ChatProtect]: &bProtects your chat."));
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[ChatProtect]: &bMade by: SpeedDev"));
	    }
	    return true;
	  }
	}

