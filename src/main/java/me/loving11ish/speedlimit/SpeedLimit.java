package me.loving11ish.speedlimit;

import me.loving11ish.speedlimit.Commands.SLHelp;
import me.loving11ish.speedlimit.Commands.SLReload;
import me.loving11ish.speedlimit.Events.FlightEvent;
import me.loving11ish.speedlimit.Events.PlayerMoveEvent;
import me.loving11ish.speedlimit.UpdateSystem.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SpeedLimit extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    private static SpeedLimit plugin;
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")
                ||Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")
                ||Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18"))){
            logger.warning(ChatColor.RED + "-------------------------------------------");
            logger.warning(ChatColor.RED + "SpeedLimit - This plugin is only supported on the Minecraft versions listed below:");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.13.x");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.14.x");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.15.x");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.16.x");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.17.x");
            logger.warning(ChatColor.RED + "SpeedLimit - 1.18.x");
            logger.warning(ChatColor.RED + "SpeedLimit - Is now disabling!");
            logger.warning(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }else {
            logger.info(ChatColor.GREEN + "-------------------------------------------");
            logger.info(ChatColor.GREEN + "SpeedLimit - A supported Minecraft version has been detected");
            logger.info(ChatColor.GREEN + "SpeedLimit - Continuing plugin startup");
            logger.info(ChatColor.GREEN + "-------------------------------------------");
        }

        //Register the config file
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register commands
        getCommand("slhelp").setExecutor(new SLHelp());
        getCommand("slreload").setExecutor(new SLReload());

        //Register event listeners
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
        getServer().getPluginManager().registerEvents(new FlightEvent(),this);

        //Plugin load message
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "SpeedLimit SpeedLimit plugin by Loving11ish");
        logger.info(ChatColor.AQUA + "SpeedLimit has been loaded successfully");
        logger.info(ChatColor.AQUA + "SpeedLimit Version " + pluginVersion);
        logger.info("-------------------------------------------");

        //Check for available updates
        new UpdateChecker(this, 75269).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ChatColor.GREEN + "*-------------------------------------------*");
                logger.info(ChatColor.AQUA + "SpeedLimit" + ChatColor.GREEN + " - Plugin is up to date");
                logger.info(ChatColor.GREEN + "*-------------------------------------------*");
            }else {
                logger.warning(ChatColor.RED + "*-------------------------------------------*");
                logger.warning(ChatColor.AQUA + "SpeedLimit" + ChatColor.RED + " - A new version is available!");
                logger.warning(ChatColor.RED + "*-------------------------------------------*");
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static SpeedLimit getPlugin() {
        return plugin;
    }
}
