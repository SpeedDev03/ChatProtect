package speeddev.info.ChatProtect.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import speeddev.info.ChatProtect.ChatProtect;
import speeddev.info.ChatProtect.Events.Configgets;

public class ClearChat implements CommandExecutor
{
	  public ClearChat(ChatProtect instance) {}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("clearchat")) {
	      if (p.hasPermission("chatprotect.clearchat"))
	      {
	        String CC = Configgets.cc
	          .replaceAll("%new%", "\n")
	          .replaceAll("%sender%", p.getName())
	          .replaceAll("%displayname%", p.getDisplayName());
	        for (Player p2 : Bukkit.getOnlinePlayers()) {
	          if (!p2.isOp()) {
	            for (int i = 0; i < 200; i++) {
	              Bukkit.broadcastMessage("  " + ChatColor.AQUA + " ");
	            }
	          } else {
	            p2.sendMessage(ChatColor.GREEN + "Because you're an operator, you can not see chat being cleared.");
	          }
	        }
	        Bukkit.broadcastMessage(CC);
	      }
	      else
	      {
	        p.sendMessage(Configgets.Prefix + Configgets.NoAccess);
	      }
	    }
	    return true;
	  }
	}
