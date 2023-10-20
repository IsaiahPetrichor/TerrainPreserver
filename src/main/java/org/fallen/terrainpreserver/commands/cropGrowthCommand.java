package org.fallen.terrainpreserver.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.utils.cropList.getExcludedCrops;
import static org.fallen.terrainpreserver.utils.cropList.getIncludedCrops;

public class cropGrowthCommand {

    public static void cropGrowthSettingsCommand(CommandSender sender, Command command, String label, String[] args) {
        String header = ChatColor.WHITE + "" + ChatColor.BOLD + "----------------------------------\n" + ChatColor.AQUA + "" + ChatColor.BOLD + "Current Crop Growth Settings:\n";
        String content = ChatColor.AQUA + "Crops that only grow with bonemeal: " + ChatColor.YELLOW + getIncludedCrops() + ChatColor.AQUA + "\nCrops that can always grow: " + ChatColor.YELLOW + getExcludedCrops();
        String footer = ChatColor.WHITE + "" + ChatColor.BOLD + "\n----------------------------------";

        String info = header + content + footer;

        if (sender instanceof Player p) {
            p.sendMessage(info);
        } else {
            GlobalLogger.info(info);
        }
    }
}
