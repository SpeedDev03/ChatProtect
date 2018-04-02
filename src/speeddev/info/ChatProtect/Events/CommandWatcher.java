package speeddev.info.ChatProtect.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import speeddev.info.ChatProtect.ChatProtect;

public class CommandWatcher implements Listener
{
	  @EventHandler
	  public void onCommand(PlayerCommandPreprocessEvent e)
	  {
	    Player p = e.getPlayer();
	    String CommandSpyFormat = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Command Spy Format");
	    String CSFT = CommandSpyFormat
	      .replaceAll("%msg%", e.getMessage())
	      .replaceAll("%new%", "\n")
	      .replaceAll("%sender%", p.getName())
	      .replaceAll("%displayname%", p.getDisplayName());
	    String CSF = ChatColor.translateAlternateColorCodes('&', CSFT);
	    for (Player p2 : Bukkit.getOnlinePlayers()) {
	      if (Configgets.cmdspy.contains(p2)) {
	        p2.sendMessage(CSF);
	      } else {
	        return;
	      }
	    }
	  }
	}
