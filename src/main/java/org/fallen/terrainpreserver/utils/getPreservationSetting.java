package org.fallen.terrainpreserver.utils;

import org.bukkit.ChatColor;

public class getPreservationSetting {
    public static String getInfo(String includedBlocks, String excludedBlocks, InfoOptions options) {
        String header = ChatColor.WHITE + "" + ChatColor.BOLD + "----------------------------------\n" + ChatColor.AQUA + "" + ChatColor.BOLD + "Current " + options.settingsType + " Settings:\n";
        String content = ChatColor.AQUA + options.includedBlocksTitle + ": \n" + ChatColor.YELLOW + includedBlocks + ChatColor.AQUA + "\n" + options.excludedBlocksTitle + ": \n" + ChatColor.YELLOW + excludedBlocks;
        String footer = ChatColor.WHITE + "" + ChatColor.BOLD + "\n----------------------------------";

        return header + content + footer;
    }

    public static class InfoOptions {
        public String settingsType = "";
        public String includedBlocksTitle = "";
        public String excludedBlocksTitle = "";

        public InfoOptions(String settingsType, String includedBlocksTitle, String excludedBlocksTitle) {
            this.settingsType = settingsType;
            this.includedBlocksTitle = includedBlocksTitle;
            this.excludedBlocksTitle = excludedBlocksTitle;
        }
    }
}
