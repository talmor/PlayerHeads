/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.shininet.bukkit.playerheads;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
* @author meiskam
*/

public final class PlayerHeads extends JavaPlugin implements Listener {

    private PlayerHeadsCommandExecutor commandExecutor;
    private PlayerHeadsListener listener;
    public Logger logger;
    public FileConfiguration configFile;
    private static boolean updateReady = false;
    private static String updateName = "";
    private static long updateSize = 0;

    @Override
    public void onEnable(){
        logger = getLogger();
        configFile = getConfig();
        configFile.options().copyDefaults(true);
        saveDefaultConfig();

        Lang.init(this);
        initMetrics();
        initUpdater();

        listener = new PlayerHeadsListener(this);
        commandExecutor = new PlayerHeadsCommandExecutor(this);
        getServer().getPluginManager().registerEvents(listener, this);
        getCommand("PlayerHeads").setExecutor(commandExecutor);
    }

    @Override
    public void onDisable() {
        EntityDeathEvent.getHandlerList().unregister(listener);
        PlayerInteractEvent.getHandlerList().unregister(listener);
        PlayerJoinEvent.getHandlerList().unregister(listener);
        BlockBreakEvent.getHandlerList().unregister(listener);
    }

    private void initMetrics() {
        try {
            BukkitMetrics metrics = new BukkitMetrics(this);
            metrics.start();
        } catch (Exception e) {
            logger.warning(Lang.ERROR_METRICS);
        }  
    }

    private void initUpdater() {
        try {
            if (configFile.getBoolean("updatecheck") && !(updateReady)) {
                Updater updater = new Updater(this, Config.updateSlug, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false); // Start Updater but just do a version check
                updateReady = updater.getResult() == Updater.UpdateResult.UPDATE_AVAILABLE; // Determine if there is an update ready for us
                updateName = updater.getLatestVersionString(); // Get the latest version
                updateSize = updater.getFileSize(); // Get latest size
            }
        } catch (Exception e) {
            logger.warning(Lang.ERROR_UPDATER);
        }
    }

    public boolean getUpdateReady() {
        return updateReady;
    }

    public String getUpdateName() {
        return updateName;
    }

    public long getUpdateSize() {
        return updateSize;
    }
}
