package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMessage implements Listener {

    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.cm")) {
                online.sendMessage(ChatColor.GRAY + "[" + player + ": " + message + "]");
            }
        }
    }
}
