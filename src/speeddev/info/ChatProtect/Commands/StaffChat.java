package speeddev.info.ChatProtect.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;
import speeddev.info.ChatProtect.Events.Configgets;

public class StaffChat  implements CommandExecutor
{
	  public StaffChat(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("staffchat")) {
	      if (p.hasPermission("chatprotect.staffchat"))
	      {
	        StringBuilder builder = new StringBuilder();
	        for (int i = 0; i < args.length; i++) {
	          builder.append(args[i]).append(" ");
	        }
	        String message = builder.toString();
	        String msgc = ChatColor.translateAlternateColorCodes('&', message);
	        String StaffChatFormat = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Staff Chat Format");
	        String scft = StaffChatFormat
	          .replaceAll("%msg%", msgc)
	          .replaceAll("%new%", "\n")
	          .replaceAll("%sender%", p.getName())
	          .replaceAll("%displayname%", p.getDisplayName());
	        String SCF = ChatColor.translateAlternateColorCodes('&', scft);
	        for (Player p2 : Bukkit.getOnlinePlayers()) {
	          if (p2.hasPermission("chatprotect.staffchat")) {
	            p.sendMessage(SCF);
	          }
	        }
	      }
	      else
	      {
	        p.sendMessage(Configgets.Prefix + Configgets.NoAccess);
	      }
	    }
	    return true;
	  }
	}
