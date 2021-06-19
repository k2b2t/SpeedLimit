package me.loving11ish.speedlimit.Events;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FlightEvent implements Listener {

    SpeedLimit Plugin;

    public FlightEvent(SpeedLimit plugin) {
        Plugin = plugin;
    }

    @EventHandler
    public void OnFlightEvent(PlayerToggleFlightEvent event) {
        Player player = (Player) event.getPlayer();
        if (Plugin.getConfig().getList("Disabled-Worlds").contains(player.getWorld().getName())){
            player.setFlySpeed((float) 0.1);
        }
        if (!(Plugin.getConfig().getList("Disabled-Worlds").contains(player.getWorld().getName()))){
            if (!(player.hasPermission("SpeedLimit.bypass.flying")||player.hasPermission("SpeedLimit.bypass.*")|| player.hasPermission("SpeedLimit.*")||player.isOp())) {
                if (Plugin.getConfig().getBoolean("Enable-flying-limit")) {
                    player.setFlySpeed((float) Plugin.getConfig().getDouble("Flying-speed-limit"));
                }
            }else {
                player.setFlySpeed((float) 0.1);
            }
        }
    }
}
