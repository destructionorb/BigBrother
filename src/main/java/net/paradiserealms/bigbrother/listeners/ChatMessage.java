package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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

    @EventHandler
    public void onHeroChatMessage(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        String command = e.getMessage();
        String commandSplit[] = command.split(" ", 2);
        command = commandSplit[0];

        if(command.equals("/g") || command.equals("/h") || command.equals("/t") || command.equals("/l")) {
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(online.hasPermission("bigbrother.cm")) {
                    online.sendMessage(ChatColor.GRAY + "[" + player + ": " + e.getMessage() + "]");
                }
            }
        }
    }
}
