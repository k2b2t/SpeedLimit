package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.Events.ElytraFlightEvent;
import me.loving11ish.speedlimit.SpeedLimit;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class SLReload implements CommandExecutor {

    private static final String PREFIX = ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-prefix"));
    private static final String PREFIX_PLACEHOLDER = "%PREFIX%";

    Logger logger = SpeedLimit.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.reload")|| player.hasPermission("SpeedLimit.*")||player.isOp()){
                SpeedLimit.getPlugin().reloadConfig();
                SpeedLimit.getPlugin().messagesDataManager.reloadMessagesConfig();
                ElytraFlightEvent.updateElytraTriggerValue();
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-4").replace(PREFIX_PLACEHOLDER, PREFIX)));
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-no-permission").replace(PREFIX_PLACEHOLDER, PREFIX)));
            }
        }else {
            SpeedLimit.getPlugin().reloadConfig();
            SpeedLimit.getPlugin().messagesDataManager.reloadMessagesConfig();
            ElytraFlightEvent.updateElytraTriggerValue();
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Reload-successful-4").replace(PREFIX_PLACEHOLDER, PREFIX)));
        }
        return true;
    }
}
