package me.loving11ish.speedlimit.UpdateSystem;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("SpeedLimit.update")|| player.hasPermission("SpeedLimit.*")||player.isOp()) {
            new UpdateChecker(SpeedLimit.getPlugin(), 75269).getVersion(version -> {
                if (!(SpeedLimit.getPlugin().getDescription().getVersion().equalsIgnoreCase(version))) {
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                    player.sendMessage(ChatColor.AQUA + "       SpeedLimit " + ChatColor.RED + "- A new version is available!");
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                }
            });
        }
    }
}
