package org.fallen.terrainpreserver.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.commands.cropGrowthCommand.cropGrowthSettingsCommand;

public class terpRouterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String[] subCommandsArr = {"help", "crops", "nature"};
        List<String> subCommands = Arrays.stream(subCommandsArr).toList();

        boolean invalidSubCommand = args.length > 0 && !subCommands.contains(args[0].toLowerCase());

        if (args.length < 1) {
            if (sender instanceof Player p) {
                p.sendMessage(command.getUsage());
            } else {
                GlobalLogger.info(command.getUsage());
            }
        } else if (invalidSubCommand || args[0].equalsIgnoreCase("help")) {
            if (invalidSubCommand) {
                if (sender instanceof Player p) {
                    p.sendMessage(ChatColor.RED + "Invalid sub-command!\n");
                } else {
                    GlobalLogger.info(ChatColor.RED + "Invalid sub-command!\n");
                }
            }
            String header = ChatColor.WHITE + "" + ChatColor.BOLD + "----------------------------------\n" + ChatColor.AQUA + "" + ChatColor.BOLD + "Available sub-commands:\n";
            String content = ChatColor.YELLOW + subCommands.toString();
            String footer = ChatColor.WHITE + "" + ChatColor.BOLD + "\n----------------------------------";

            String info = header + content + footer;

            if (sender instanceof Player p) {
                p.sendMessage(info);
            } else {
                GlobalLogger.info(info);
            }

        } else if (args[0].equalsIgnoreCase("crops")) {
            cropGrowthSettingsCommand(sender, command, label, args);
        }

        return true;
    }
}
