package me.loving11ish.speedlimit.UpdateSystem;

import me.loving11ish.speedlimit.SpeedLimit;
import me.loving11ish.speedlimit.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class UpdateChecker {

    private Plugin plugin;
    private int resourceId;

    private static final String PREFIX = ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Plugin-prefix"));
    private static final String PREFIX_PLACEHOLDER = "%PREFIX%";
    private static final String ERROR_PLACEHOLDER = "%ERROR%";

    Logger logger = SpeedLimit.getPlugin().getLogger();

    public UpdateChecker(Plugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                logger.warning(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Update-check-failure-1").replace(PREFIX_PLACEHOLDER, PREFIX).replace(ERROR_PLACEHOLDER, exception.getMessage())));
                logger.warning(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Update-check-failure-2").replace(PREFIX_PLACEHOLDER, PREFIX).replace(ERROR_PLACEHOLDER, exception.getMessage())));
                logger.warning(ColorUtils.translateColorCodes(SpeedLimit.getPlugin().messagesDataManager.getMessagesConfig().getString("Update-check-failure-3").replace(PREFIX_PLACEHOLDER, PREFIX).replace(ERROR_PLACEHOLDER, exception.getMessage())));
            }
        });
    }
}
