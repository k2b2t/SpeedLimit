package me.loving11ish.speedlimit;

import me.loving11ish.speedlimit.Commands.SLHelp;
import me.loving11ish.speedlimit.Commands.SLReload;
import me.loving11ish.speedlimit.Events.ElytraFlightEvent;
import me.loving11ish.speedlimit.Events.FlightEvent;
import me.loving11ish.speedlimit.Events.PlayerMoveEvent;
import me.loving11ish.speedlimit.FileManager.MessagesDataManager;
import me.loving11ish.speedlimit.UpdateSystem.JoinEvent;
import me.loving11ish.speedlimit.UpdateSystem.UpdateChecker;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SpeedLimit extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    private static SpeedLimit plugin;

    public MessagesDataManager messagesDataManager;

    private final String PREFIX_PLACEHOLDER = "%PREFIX%";

    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

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
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register & save the messages config
        this.messagesDataManager = new MessagesDataManager();
        this.messagesDataManager.MessagesDataManager(this);


        //Register commands
        getCommand("slhelp").setExecutor(new SLHelp());
        getCommand("slreload").setExecutor(new SLReload());

        //Register event listeners
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
        getServer().getPluginManager().registerEvents(new FlightEvent(), this);
        getServer().getPluginManager().registerEvents(new ElytraFlightEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        //Run elytra velocity update task
        ElytraFlightEvent.updateElytraTriggerValue();

        //Plugin load message
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "SpeedLimit SpeedLimit plugin by Loving11ish");
        logger.info(ChatColor.AQUA + "SpeedLimit has been loaded successfully");
        logger.info(ChatColor.AQUA + "SpeedLimit Version " + ChatColor.LIGHT_PURPLE + pluginVersion);
        logger.info("-------------------------------------------");

        //Check for available updates
        String PREFIX = this.messagesDataManager.getMessagesConfig().getString("Plugin-prefix");
        new UpdateChecker(this, 75269).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-no-update-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-no-update-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-no-update-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
            }else {
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-update-available-1").replace(PREFIX_PLACEHOLDER, PREFIX)));
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-update-available-2").replace(PREFIX_PLACEHOLDER, PREFIX)));
                logger.info(ColorUtils.translateColorCodes(messagesDataManager.getMessagesConfig().getString("Plugin-update-available-3").replace(PREFIX_PLACEHOLDER, PREFIX)));
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
