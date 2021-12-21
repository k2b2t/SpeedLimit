package me.loving11ish.speedlimit.Commands;

import me.loving11ish.speedlimit.SpeedLimit;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class SLHelp implements CommandExecutor {

    private static final String PREFIX = ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-prefix"));
    private static final String PREFIX_PLACEHOLDER = "%PREFIX%";

    Logger logger = SpeedLimit.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("SpeedLimit.help")||player.hasPermission("SpeedLimit.*")||player.isOp()){
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-4").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-5").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-6").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-7").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-8").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-9").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-10").replace(PREFIX_PLACEHOLDER, PREFIX)));
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-11").replace(PREFIX_PLACEHOLDER, PREFIX)));
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Help-no-permission").replace(PREFIX_PLACEHOLDER, PREFIX)));
            }
        }else {
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-4").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-5").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-6").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-7").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-8").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-9").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-10").replace(PREFIX_PLACEHOLDER, PREFIX)));
            logger.info(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-help-11").replace(PREFIX_PLACEHOLDER, PREFIX)));
        }
        return true;
    }
}
