package net.paradiserealms.bigbrother.commands;

import net.paradiserealms.bigbrother.BigBrother;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReload implements CommandExecutor {

    private BigBrother plugin;

    public CommandReload(BigBrother plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("bigbrother")) {
            if(args[0].equalsIgnoreCase("reload")) {
                Player player = (Player) sender;
                if(player.hasPermission("bigbrother.reload")) {
                    plugin.reloadConfig();
                    player.sendMessage(ChatColor.GREEN + "Big Brother blinked. Plugin reloaded.");
                }
            }
        }
        return false;
    }
}
