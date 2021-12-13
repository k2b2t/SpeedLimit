package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class SLHelp implements CommandExecutor {

    Logger logger = SpeedLimit.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.help")||player.hasPermission("SpeedLimit.*")||player.isOp()){
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the main config file.");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.AQUA + "Permissions:");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.reload");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.help");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Walking Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.walking");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Flying Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.flying");
                player.sendMessage(ChatColor.GREEN + "[SpeedLimit] " + ChatColor.WHITE + "Elytra Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.elytra");
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission 'SpeedLimit.help' required to execute that command!");
            }
        }else if (!(sender instanceof Player)){
            logger.info(ChatColor.YELLOW + "[---------------------------------------------------]");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the main config file.");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.AQUA + "Permissions:");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "/slreload " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.reload");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "/slhelp " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.help");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "Walking Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.walking");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "Flying Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.flying");
            logger.info(ChatColor.GREEN + "SpeedLimit " + ChatColor.WHITE + "Elytra Bypass: " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "SpeedLimit.bypass.elytra");
            logger.info(ChatColor.YELLOW + "[---------------------------------------------------]");
        }
        return true;
    }
}
