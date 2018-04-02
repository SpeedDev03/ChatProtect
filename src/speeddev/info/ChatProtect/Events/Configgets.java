package speeddev.info.ChatProtect.Events;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import speeddev.info.ChatProtect.ChatProtect;

public class Configgets  extends JavaPlugin
implements Listener
{
	
public static String Prefix = ChatColor.translateAlternateColorCodes('&', ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Prefix") + " ");
public static String NoAccess = ChatColor.translateAlternateColorCodes('&', ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("No Access Message"));
public static String ChatLockOff = ChatColor.translateAlternateColorCodes('&', ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Chat Lock Disable Message"));
public static String ChatLockOn = ChatColor.translateAlternateColorCodes('&', ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Chat Lock Enable Message"));
public static String cc = ChatColor.translateAlternateColorCodes('&', ((ChatProtect)ChatProtect.getPlugin(ChatProtect.class)).getConfig().getString("Clear Chat Message"));
public static boolean chatlock = false;
public static ArrayList<Player> cmdspy = new ArrayList();

}
