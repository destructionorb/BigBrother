package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PrivateMessage implements Listener {

    @EventHandler
    public void onPrivateMessage(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        String command = e.getMessage();
        String commandSplit[] = command.split(" ", 2);
        command = commandSplit[0];

        if(command.equals("/w") || command.equals("/m") || command.equals("/msg") || command.equals("/whisper") || command.equals("/r")) {
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(online.hasPermission("bigbrother.pm")) {
                    online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": " + e.getMessage() + "]");
                }
            }
        }
    }
}
