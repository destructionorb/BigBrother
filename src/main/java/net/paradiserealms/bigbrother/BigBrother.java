package net.paradiserealms.bigbrother;

import net.paradiserealms.bigbrother.listeners.ChatMessage;
import net.paradiserealms.bigbrother.listeners.PrivateMessage;
import net.paradiserealms.bigbrother.listeners.SignPlace;
import net.paradiserealms.bigbrother.listeners.WriteBook;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
//TODO: add location to sign placement
//TODO: add lines to sign text formatting, instead of separating with commas

/**
 * The main class of the BigBrother plugin. Handles the logic for enabling and disabling the server, as well as loading
 * the config file.
 * @author destructionorb
 */
public class BigBrother extends JavaPlugin {

    /**
     * Handles the startup logic for the plugin, including outputting minor debug messages and starting listeners
     * according to the config file.
     */
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nStarting up Big Brother.\n\n" );

        //load the config file here so that it can be accessed to start the correct listeners
        loadConfig();

        //listener block
        if(getConfig().getBoolean("ChatMessage")) {
            getServer().getPluginManager().registerEvents(new ChatMessage(), this);
        }
        if(getConfig().getBoolean("SignPlace")) {
            getServer().getPluginManager().registerEvents(new SignPlace(), this);
        }
        if(getConfig().getBoolean("WriteBook")) {
            getServer().getPluginManager().registerEvents(new WriteBook(), this);
        }
        if(getConfig().getBoolean("PrivateMessage")) {
            getServer().getPluginManager().registerEvents(new PrivateMessage(), this);
        }

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nBig Brother is watching.\n\n" );
    }

    /**
     * Handles shutdown logic for the plugin, which at this point is just a minor debug message.
     */
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nBig Brother is no longer watching.\n\n");
    }

    /**
     * Loads the config file, copying defaults if no changes have been made. Saves the config after this.
     */
    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
