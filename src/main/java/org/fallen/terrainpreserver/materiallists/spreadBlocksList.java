package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.List;

public class spreadBlocksList {
    // Known blocks don't output info on spread/grow
    private static List<Material> knownBlocks = List.of(Material.VINE, Material.TWISTING_VINES, Material.RED_MUSHROOM);

    // Excluded blocks can still spread
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
