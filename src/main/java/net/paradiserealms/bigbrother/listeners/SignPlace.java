package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.util.Arrays;

public class SignPlace implements Listener {

    @EventHandler
    public void onSignPlace(SignChangeEvent e) {
        Player player = e.getPlayer();
        String[] lines = e.getLines();

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.sp")) {
                online.sendMessage(ChatColor.GRAY + "[" + player + ": " + Arrays.toString(lines) + "]");
            }
        }
    }
}
