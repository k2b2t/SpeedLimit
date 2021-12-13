package me.loving11ish.speedlimit.Events;

import me.loving11ish.speedlimit.SpeedLimit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ElytraFlightEvent implements Listener {

    public static Integer taskID1;
    private static double vDouble;

    public static void updateElytraVelocity(){
        taskID1 = Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedLimit.getPlugin(), new Runnable() {
            @Override
            public void run() {
                vDouble = SpeedLimit.getPlugin().getConfig().getDouble("Elytra-speed-limit");
            }
        }, 20);
    }

    @EventHandler
    public void onElytraFlight(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (!(SpeedLimit.getPlugin().getConfig().getBoolean("Enable-elytra-limit"))){
            return;
        }
        if (SpeedLimit.getPlugin().getConfig().getList("Disabled-Worlds").contains(player.getWorld().getName())){
            return;
        }
        if (player.hasPermission("SpeedLimit.bypass.elytra")||player.hasPermission("SpeedLimit.bypass")
                ||player.hasPermission("SpeedLimit.*")||player.isOp()){
            return;
        }
        if (player.isGliding()){
            if (Math.abs(event.getFrom().getX() - event.getTo().getX()) > vDouble
                    ||Math.abs(event.getFrom().getZ() - event.getTo().getZ()) > vDouble){
                event.setCancelled(true);
                if (SpeedLimit.getPlugin().getConfig().getBoolean("Send-warning-message")){
                    player.sendMessage(ChatColor.RED + "You are flying too fast! Slow down!");
                }
            }
        }
    }
}
