package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SLReload implements CommandExecutor {

    SpeedLimit Plugin;

    public SLReload(SpeedLimit plugin) {
        Plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.reload")|| player.hasPermission("SpeedLimit.*")||player.isOp()){
                Plugin.reloadConfig();
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] plugin by Loving11ish");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] Configuration file has been successfully reloaded!");
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission 'SpeedLimit.reload' required to execute that command!");
            }
        }else if (!(sender instanceof Player)){
            Plugin.reloadConfig();
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
            System.out.println(ChatColor.GREEN + "SpeedLimit plugin by Loving11ish");
            System.out.println(ChatColor.GREEN + "SpeedLimit Configuration file has been successfully reloaded!");
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
        }
        return true;
    }
}
