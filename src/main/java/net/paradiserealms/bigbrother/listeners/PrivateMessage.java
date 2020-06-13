package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Listener for private messages on the server.
 */
public class PrivateMessage implements Listener {

    /**
     * The event handler for the listener. What it really does is listen to all commands, and then split off the
     * first part of that string, delineated by a space. If that matches any of the known commands for private messages
     * below, it outputs the playername, command, and message contents to all users with adequate permissions.
     * @param e a command sent by a player
     */
    @EventHandler
    public void onPrivateMessage(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        String command = e.getMessage();
        String[] commandSplit = command.split(" ", 2);
        command = commandSplit[0];

        //if block consisting of known "private message commands"
        if(command.equals("/w") || command.equals("/m") || command.equals("/msg") || command.equals("/whisper") || command.equals("/r")) {
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(online.hasPermission("bigbrother.pm")) {
                    online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": " + e.getMessage() + "]");
                }
            }
        }
    }
}
