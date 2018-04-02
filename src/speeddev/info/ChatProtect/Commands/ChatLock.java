package speeddev.info.ChatProtect.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;
import speeddev.info.ChatProtect.Events.Configgets;

public class ChatLock  implements CommandExecutor
{
	  public ChatLock(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("chatlock")) {
	      if (p.hasPermission("chatprotect.chatlock"))
	      {
	        if (Configgets.chatlock)
	        {
	          Configgets.chatlock = false;
	          String CLOFF = Configgets.ChatLockOff
	            .replaceAll("%new%", "\n")
	            .replaceAll("%sender%", p.getName())
	            .replaceAll("%displayname%", p.getDisplayName());
	          Bukkit.broadcastMessage(CLOFF);
	        }
	        else
	        {
	          Configgets.chatlock = true;
	          String CLON = Configgets.ChatLockOn
	            .replaceAll("%new%", "\n")
	            .replaceAll("%sender%", p.getName())
	            .replaceAll("%displayname%", p.getDisplayName());
	          Bukkit.broadcastMessage(CLON);
	        }
	      }
	      else {
	        p.sendMessage(Configgets.Prefix + Configgets.NoAccess);
	      }
	    }
	    return true;
	  }
	}

