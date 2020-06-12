package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

public class WriteBook implements Listener {

    @EventHandler
    public void onWriteBook(PlayerEditBookEvent e) {
        Player player = e.getPlayer();
        BookMeta writing = e.getNewBookMeta();
        boolean signature = e.isSigning();

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.wb")) {
                online.sendMessage(ChatColor.GRAY + "[" + player + ": " + writing + ", signed: " + signature + "]");
            }
        }
    }
}
