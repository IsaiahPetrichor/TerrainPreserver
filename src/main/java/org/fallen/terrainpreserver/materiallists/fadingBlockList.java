package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.List;

public class fadingBlockList {
    // Known blocks don't output info on fade
    private static List<Material> knownBlocks = List.of(Material.ICE, Material.SNOW, Material.BRAIN_CORAL,
                                                        Material.BRAIN_CORAL_BLOCK, Material.BRAIN_CORAL_FAN,
                                                        Material.BRAIN_CORAL_WALL_FAN, Material.BUBBLE_CORAL,
                                                        Material.BUBBLE_CORAL_BLOCK, Material.BUBBLE_CORAL_FAN,
                                                        Material.BUBBLE_CORAL_WALL_FAN, Material.FIRE_CORAL,
                                                        Material.FIRE_CORAL_BLOCK, Material.FIRE_CORAL_FAN,
                                                        Material.FIRE_CORAL_WALL_FAN, Material.HORN_CORAL,
                                                        Material.HORN_CORAL_BLOCK, Material.HORN_CORAL_FAN,
                                                        Material.HORN_CORAL_WALL_FAN, Material.TUBE_CORAL,
                                                        Material.TUBE_CORAL_BLOCK, Material.TUBE_CORAL_FAN,
                                                        Material.TUBE_CORAL_WALL_FAN, Material.FARMLAND);
    // Excluded blocks can still fade
    private static List<Material> excludedBlocks = List.of(Material.GRASS_BLOCK);

    public static List<Material> getKnownBlocks() {
        return knownBlocks;
    }

    public static List<Material> getExcludedBlocks() {
        return excludedBlocks;
    }

    public static void addKnownBlocks(List<Material> blocks) {
        knownBlocks.addAll(blocks);
    }

    public static void addExcludedBlocks(List<Material> blocks) {
        excludedBlocks.addAll(blocks);
    }
}
