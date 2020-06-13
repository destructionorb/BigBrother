package net.paradiserealms.bigbrother.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Listener for chat messages on the server
 */
public class ChatMessage implements Listener {

    /**
     * One of the event handlers for the listener, listens for any message sent in chat without the use of another
     * command. The most straightforward of these handlers, honestly. Outputs the message to users with adequate
     * permissions.
     * @param e a chat message sent by a player
     */
    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        for(Player online : Bukkit.getOnlinePlayers()) {
            if(online.hasPermission("bigbrother.cm")) {
                online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": " + message + "]");
            }
        }
    }

    /**
     * The other event handler for the listener, listens for chat messages sent through common HeroChat channels.
     * Works similarly to the onPrivateMessage handler, filtering through commands sent for HeroChat channel shortcuts.
     * Outputs the message with the command prefix for users with adequate permissions, similarly to the
     * onPrivateMessage handler.
     * @param e a command sent by a player
     */
    @EventHandler
    public void onHeroChatMessage(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        String command = e.getMessage();
        String commandSplit[] = command.split(" ", 2);
        command = commandSplit[0];

        //if block consisting of "common HeroChat channel commands"
        if(command.equals("/g") || command.equals("/h") || command.equals("/t") || command.equals("/l")) {
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(online.hasPermission("bigbrother.cm")) {
                    online.sendMessage(ChatColor.GRAY + "[" + player.getName() + ": " + e.getMessage() + "]");
                }
            }
        }
    }
}
