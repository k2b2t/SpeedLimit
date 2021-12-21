package me.loving11ish.speedlimit.UpdateSystem;

import me.loving11ish.speedlimit.SpeedLimit;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private static final String PREFIX = ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-prefix"));
    private static final String PREFIX_PLACEHOLDER = "%PREFIX%";

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("SpeedLimit.update")|| player.hasPermission("SpeedLimit.*")||player.isOp()) {
            new UpdateChecker(SpeedLimit.getPlugin(), 75269).getVersion(version -> {
                if (!(SpeedLimit.getPlugin().getDescription().getVersion().equalsIgnoreCase(version))) {
                    player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-no-update-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
                    player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-no-update-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
                    player.sendMessage(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-no-update-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
                }
            });
        }
    }
}
