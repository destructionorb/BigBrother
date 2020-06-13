package net.paradiserealms.bigbrother;

import net.paradiserealms.bigbrother.commands.CommandReload;
import net.paradiserealms.bigbrother.listeners.ChatMessage;
import net.paradiserealms.bigbrother.listeners.PrivateMessage;
import net.paradiserealms.bigbrother.listeners.SignPlace;
import net.paradiserealms.bigbrother.listeners.WriteBook;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
//TODO: figure out how to do commands that allow parts of the plugin and the entire plugin to be disabled individually
//TODO: comment out the plugin
//TODO: set up the config to allow users to select which parts of the plugin they want active

public class BigBrother extends JavaPlugin {

    @Override
    public void onEnable() {
        //Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nStarting up Big Brother.\n\n" );
        //listener block
        getServer().getPluginManager().registerEvents(new ChatMessage(), this);
        getServer().getPluginManager().registerEvents(new SignPlace(), this);
        getServer().getPluginManager().registerEvents(new WriteBook(), this);
        getServer().getPluginManager().registerEvents(new PrivateMessage(), this);

        getCommand("bigbrother").setExecutor(new CommandReload(this));

        loadConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nBig Brother is watching.\n\n" );
    }

    @Override
    public void onDisable() {
        //Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nBig Brother is no longer watching.\n\n");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
