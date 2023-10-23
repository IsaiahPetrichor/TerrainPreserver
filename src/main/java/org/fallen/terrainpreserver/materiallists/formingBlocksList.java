package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.List;

public class formingBlocksList {
    // Known blocks don't output info on formation
    private static List<Material> knownBlocks = List.of(Material.ICE);

    // Excluded blocks can still form
    private static List<Material> excludedBlocks = List.of(Material.STONE, Material.OBSIDIAN, Material.COBBLESTONE);

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
