package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.util.Arrays;

/**
 * Listener for signs placed on the server
 */
public class SignPlace implements Listener {

    /**
     * The event handler for this listener, it listens for sign edits, which usually only occur when they are placed
     * (WorldEdit as an example of an exception). It outputs the lines of the sign to users with adequate permissions.
     * @param e a sign edited by a player
     */
    @EventHandler
    public void onSignPlace(SignChangeEvent e) {
        Player player = e.getPlayer();
        String[] lines = e.getLines(); //the lines on a sign need to be stored in an array, or they cannot be output to chat properly

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.sp")) {
                online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": " + Arrays.toString(lines) + "]");
            }
        }
    }
}
