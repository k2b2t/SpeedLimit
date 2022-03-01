package me.loving11ish.speedlimit.Events;

import me.loving11ish.speedlimit.SpeedLimit;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ElytraFlightEvent implements Listener {

    public static Integer taskID1;
    private static double velocityTriggerMultiplier;

    private static final String PREFIX = SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-prefix");
    private static final String PREFIX_PLACEHOLDER = "%PREFIX%";

    public static void updateElytraTriggerValue(){
        taskID1 = Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedLimit.getPlugin(), new Runnable() {
            @Override
            public void run() {
                velocityTriggerMultiplier = SpeedLimit.getPlugin().getConfig().getDouble("Elytra-speed-limit-trigger");
            }
        }, 10);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onElytraFlight(PlayerMoveEvent event){
        Player player = event.getPlayer();
        double x = event.getFrom().getX();
        double y = event.getFrom().getY();
        double z = event.getFrom().getZ();
        float yaw = event.getFrom().getYaw();
        float pitch = event.getFrom().getPitch();
        if (SpeedLimit.getPlugin().getConfig().getBoolean("Disable-all-elytra-flight")){
            if (player.isGliding()){
                Location location = new Location(player.getWorld(), x, y, z, yaw, pitch);
                player.setGliding(false);
                player.teleport(location);
                player.sendMessage(ColorUtils.translateColorCodes(
                        SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Elytras-disabled-warning")
                                .replace(PREFIX_PLACEHOLDER, PREFIX)));
            }
            return;
        }
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
        //if (player.isGliding()){
            if (Math.abs(event.getFrom().getX() - event.getTo().getX()) > velocityTriggerMultiplier
                    /*||Math.abs(event.getFrom().getY() - event.getTo().getY()) > velocityTriggerMultiplier*/
                    ||Math.abs(event.getFrom().getZ() - event.getTo().getZ()) > velocityTriggerMultiplier){
               Location oldLocation = new Location(player.getWorld(), x, y, z, yaw, pitch);
                if (SpeedLimit.getPlugin().getConfig().getBoolean("Cancel-event-completely")){
                    event.setCancelled(true);
                } else {
                    player.teleport(oldLocation);
                }
                if (SpeedLimit.getPlugin().getConfig().getBoolean("Send-warning-message")){
                    player.sendMessage(ColorUtils.translateColorCodes(
                            SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Elytra-triggered-warning")
                                    .replace(PREFIX_PLACEHOLDER, PREFIX)));
                }
            }
        //}
    }
}
