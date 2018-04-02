package speeddev.info.ChatProtect;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import speeddev.info.ChatProtect.Commands.Broadcast;
import speeddev.info.ChatProtect.Commands.ChatLock;
import speeddev.info.ChatProtect.Commands.ChatProtectCmd;
import speeddev.info.ChatProtect.Commands.ClearChat;
import speeddev.info.ChatProtect.Commands.CommandSpy;
import speeddev.info.ChatProtect.Commands.StaffChat;
import speeddev.info.ChatProtect.Events.ChatWatcher;
import speeddev.info.ChatProtect.Events.CommandWatcher;

public class ChatProtect  extends JavaPlugin
implements Listener
{
public static ChatProtect instance = null;

public void onEnable()
{
  instance = this;
  Log.info(new Object[] { "[ChatProtect] has been enabled!" });
  
  File f = new File(getDataFolder(), "config.yml");
  if (!f.exists())
  {
    getLogger().info("There's an error. Please re-install the plugin");
    saveDefaultConfig();
  }
  if (f.exists())
  {
    saveDefaultConfig();
    saveDefaultConfig();
  }
  registerEvents();
  registerCommands();
  speeddev.info.ChatProtect.Events.Configgets.chatlock = false;
}

public void onDisable()
{
  Log.info(
    new Object[] { "[ChatProtect] has been disabled!" });
  instance = null;
}

private void registerCommands()
{
  getCommand("ChatProtect").setExecutor(new ChatProtectCmd(this));
  getCommand("broadcast").setExecutor(new Broadcast(this));
  getCommand("chatlock").setExecutor(new ChatLock(this));
  getCommand("clearchat").setExecutor(new ClearChat(this));
  getCommand("commandspy").setExecutor(new CommandSpy(this));
  getCommand("staffchat").setExecutor(new StaffChat(this));
}

private void registerEvents()
{
  Bukkit.getServer().getPluginManager().registerEvents(new ChatWatcher(), this);
  Bukkit.getServer().getPluginManager().registerEvents(new CommandWatcher(), this);
}
}
