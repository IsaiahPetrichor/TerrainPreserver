package org.fallen.terrainpreserver.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.cropList.getExcludedCrops;
import static org.fallen.terrainpreserver.materiallists.cropList.getIncludedCrops;
import static org.fallen.terrainpreserver.utils.blocksToString.formatBlockList;
import static org.fallen.terrainpreserver.utils.getPreservationSetting.InfoOptions;
import static org.fallen.terrainpreserver.utils.getPreservationSetting.getInfo;

public class cropGrowthCommand {

    public static void cropGrowthSettingsCommand(CommandSender sender, Command command, String label, String[] args) {
        // format the crop lists for display in-game
        String includedCrops = formatBlockList(getIncludedCrops());
        String excludedCrops = formatBlockList(getExcludedCrops());

        // Create formatted strings to display the lists of crops as a pleasant table
        String info = getInfo(
                includedCrops, excludedCrops, new InfoOptions("Crop Growth", "Crops that only grow with bonemeal",
                                                              "Crops that will always grow"));

        if (sender instanceof Player p) {
            // if a player uses the command, send info as a chat message
            p.sendMessage(info);
        } else {
            // if the command wasn't made by a player then, log info to server console
            GlobalLogger.info(info);
        }
    }
}
