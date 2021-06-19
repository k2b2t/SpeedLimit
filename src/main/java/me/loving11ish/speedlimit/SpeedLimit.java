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

public final class SpeedLimit extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||Bukkit.getServer().getVersion().contains("1.17"))){
            System.out.println(ChatColor.RED + "-------------------------------------------");
            System.out.println(ChatColor.RED + "SpeedLimit - This plugin is only supported on the Minecraft versions listed below:");
            System.out.println(ChatColor.RED + "SpeedLimit - 1.13.x");
            System.out.println(ChatColor.RED + "SpeedLimit - 1.14.x");
            System.out.println(ChatColor.RED + "SpeedLimit - 1.15.x");
            System.out.println(ChatColor.RED + "SpeedLimit - 1.16.x");
            System.out.println(ChatColor.RED + "SpeedLimit - 1.17.x");
            System.out.println(ChatColor.RED + "SpeedLimit - Is now disabling!");
            System.out.println(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
        }else {
            System.out.println(ChatColor.GREEN + "-------------------------------------------");
            System.out.println(ChatColor.GREEN + "SpeedLimit - A supported Minecraft version has been detected");
            System.out.println(ChatColor.GREEN + "SpeedLimit - Continuing plugin startup");
            System.out.println(ChatColor.GREEN + "-------------------------------------------");
        }

        //Register the config file
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register commands
        getCommand("slhelp").setExecutor(new SLHelp(this));
        getCommand("slreload").setExecutor(new SLReload(this));

        //Register event listeners
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(this), this);
        getServer().getPluginManager().registerEvents(new FlightEvent(this),this);

        //Plugin load message
        System.out.println("-------------------------------------------");
        System.out.println(ChatColor.AQUA + "SpeedLimit SpeedLimit plugin by Loving11ish");
        System.out.println(ChatColor.AQUA + "SpeedLimit has been loaded successfully");
        System.out.println(ChatColor.AQUA + "SpeedLimit Version " + pluginVersion);
        System.out.println("-------------------------------------------");

        //Check for available updates
        new UpdateChecker(this, 75269).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println(ChatColor.GREEN + "*-------------------------------------------*");
                System.out.println(ChatColor.GREEN + "SpeedLimit - Plugin is up to date");
                System.out.println(ChatColor.GREEN + "*-------------------------------------------*");
            }else {
                System.out.println(ChatColor.RED + "*-------------------------------------------*");
                System.out.println(ChatColor.RED + "SpeedLimit - A new version is available!");
                System.out.println(ChatColor.RED + "*-------------------------------------------*");
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
