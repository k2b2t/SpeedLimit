package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SLHelp implements CommandExecutor {

    SpeedLimit Plugin;

    public SLHelp(SpeedLimit plugin) {
        Plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.help")){
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the main config file.");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.AQUA + "Permissions:");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.reload");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.help");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Walking Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.walking");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Flying Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.flying");
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission 'SpeedLimit.help' required to execute that command!");
            }
        }else if (!(sender instanceof Player)){
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the main config file.");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.AQUA + "Permissions:");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.reload");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.help");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Walking Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.walking");
            System.out.println(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Flying Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.flying");
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
        }
        return true;
    }
}
