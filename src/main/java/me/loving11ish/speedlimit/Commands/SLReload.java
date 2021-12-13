package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.Events.ElytraFlightEvent;
import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class SLReload implements CommandExecutor {

    Logger logger = SpeedLimit.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.reload")|| player.hasPermission("SpeedLimit.*")||player.isOp()){
                SpeedLimit.getPlugin().reloadConfig();
                ElytraFlightEvent.updateElytraVelocity();
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
                player.sendMessage(ChatColor.GREEN + "SpeedLimit - plugin by Loving11ish");
                player.sendMessage(ChatColor.GREEN + "SpeedLimit - Configuration file has been successfully reloaded!");
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission 'SpeedLimit.reload' required to execute that command!");
            }
        }else {
            SpeedLimit.getPlugin().reloadConfig();
            ElytraFlightEvent.updateElytraVelocity();
            logger.info(ChatColor.YELLOW + "[---------------------------------------------------]");
            logger.info(ChatColor.GREEN + "SpeedLimit - plugin by Loving11ish");
            logger.info(ChatColor.GREEN + "SpeedLimit - Configuration file has been successfully reloaded!");
            logger.info(ChatColor.YELLOW + "[---------------------------------------------------]");
        }
        return true;
    }
}
