package speeddev.info.ChatProtect.Commands;

import org.bukkit.Bukkit; 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;
import speeddev.info.ChatProtect.Events.Configgets;

public class Broadcast  implements CommandExecutor
{
	  public Broadcast(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("broadcast")) {
	      if (!(sender instanceof Player))
	      {
	        sender.sendMessage("This is a player only command, sorry! Try using /say!");
	      }
	      else if (p.hasPermission("chatprotect.broadcast"))
	      {
	        StringBuilder builder = new StringBuilder();
	        for (int i = 0; i < args.length; i++) {
	          builder.append(args[i]).append(" ");
	        }
	        String message = builder.toString();
	        String msgcolored = ChatColor.translateAlternateColorCodes('&', message);
	        String BroadcastFormat = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Broadcast Format");
	        String BCFT = BroadcastFormat
	          .replaceAll("%msg%", msgcolored)
	          .replaceAll("%new%", "\n")
	          .replaceAll("%sender%", p.getName())
	          .replaceAll("%displayname%", p.getDisplayName());
	        String BCF = ChatColor.translateAlternateColorCodes('&', BCFT);
	        
	        Bukkit.broadcastMessage(BCF);
	      }
	      else
	      {
	        p.sendMessage(Configgets.Prefix + Configgets.NoAccess);
	      }
	    }
	    return true;
	  }
	}

