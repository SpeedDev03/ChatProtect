package speeddev.info.ChatProtect.Events;

import speeddev.info.ChatProtect.ChatProtect;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatWatcher  implements Listener
{
	  @EventHandler
	  public void PlayerChat(AsyncPlayerChatEvent e)
	  {
	    Player p = e.getPlayer();
	    
	    String ChatLockMessage = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Chat Locked Message");
	    String CLMDT = ChatLockMessage
	      .replaceAll("%new%", "\n")
	      .replaceAll("%sender%", p.getName())
	      .replaceAll("%displayname%", p.getDisplayName());
	    String CLMD = ChatColor.translateAlternateColorCodes('&', CLMDT);
	    if ((Configgets.chatlock) && 
	      (!p.hasPermission("chatprotect.chatlock")))
	    {
	      e.setCancelled(true);
	      
	      p.sendMessage(CLMD);
	    }
	    String AntiSwearMessage = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Anti Swear Message");
	    String ASMT = AntiSwearMessage
	      .replaceAll("%new%", "\n")
	      .replaceAll("%sender%", p.getName())
	      .replaceAll("%displayname%", p.getDisplayName());
	    String ASM = ChatColor.translateAlternateColorCodes('&', ASMT);
	    if ((((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getBoolean("Anti Swear Filter")) && 
	      (!p.hasPermission("chatprotect.allowswear")))
	    {
	      List<String> AntiWord = ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getStringList("Swears");
	      String msg = e.getMessage().toLowerCase();
	      for (int x = 0; x < AntiWord.toArray().length; x++)
	      {
	        String word = (String)AntiWord.toArray()[x];
	        word = word.toLowerCase();
	        if (msg.contains(word))
	        {
	          e.setCancelled(true);
	          if (((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getBoolean("Anti Swear Msg Send")) {
	            p.sendMessage(Configgets.Prefix + " " + ASM);
	          }
	        }
	      }
	    }
	  }
	}
