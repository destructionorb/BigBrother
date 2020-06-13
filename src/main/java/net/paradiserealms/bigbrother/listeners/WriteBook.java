package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

/**
 * Listener for written books on the server
 */
public class WriteBook implements Listener {
    /**
     * The event handler for the listener, when a player stops editing a written book, its contents are output to the
     * chat for users who have adequate permissions.
     * @param e a book edited by a player
     */
    @EventHandler
    public void onWriteBook(PlayerEditBookEvent e) {
        Player player = e.getPlayer();
        BookMeta writing = e.getNewBookMeta();
        String title = writing.getTitle();
        List<String> pageList = writing.getPages(); //pages need to be stored in a String List in order to be output properly
        boolean signature = e.isSigning(); //signature is deemed important, as if not signed, a book can still be edited

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.wb")) {
                online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": title=" + title + ", pages=" + pageList + ", signed=" + signature + "]");
            }
        }
    }
}
