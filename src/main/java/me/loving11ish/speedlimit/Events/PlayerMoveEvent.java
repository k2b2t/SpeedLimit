package me.loving11ish.speedlimit.Events;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {

    SpeedLimit Plugin;

    public PlayerMoveEvent(SpeedLimit plugin) {
        Plugin = plugin;
    }

    @EventHandler
    public void OnPlayerWalk (org.bukkit.event.player.PlayerMoveEvent event){
        Player player = (Player) event.getPlayer();
        if (Plugin.getConfig().getList("Disabled-Worlds").contains(player.getWorld().getName())){
            player.setWalkSpeed((float) 0.2);
        }
        if (!(Plugin.getConfig().getList("Disabled-Worlds").contains(player.getWorld().getName()))){
            if (!(player.hasPermission("SpeedLimit.bypass.walking")||player.hasPermission("SpeedLimit.bypass.*")|| player.hasPermission("SpeedLimit.*")||player.isOp())) {
                if (Plugin.getConfig().getBoolean("Enable-walking-limit")) {
                    player.setWalkSpeed((float) Plugin.getConfig().getDouble("Walking-speed-limit"));
                }
            }else {
                player.setWalkSpeed((float) 0.2);
            }
        }
    }
}
