package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.List;

public class spreadBlocksList {
    // Known blocks don't output info and cannot spread
    private static List<Material> knownBlocks = List.of(Material.VINE, Material.RED_MUSHROOM, Material.FIRE);

    // Excluded blocks can still spread
    private static List<Material> excludedBlocks = List.of(Material.GRASS_BLOCK);

    // Included blocks can be bonemeal-ed
    private static List<Material> includedBlocks = List.of(
            Material.BAMBOO, Material.BAMBOO_SAPLING, Material.WEEPING_VINES, Material.TWISTING_VINES, Material.KELP);

    public static List<Material> getKnownSpreadableBlocks() {
        return knownBlocks;
    }

    public static List<Material> getExcludedSpreadableBlocks() {
        return excludedBlocks;
    }

    public static List<Material> getIncludedSpreadableBlocks() {
        return includedBlocks;
    }

    public static void addKnownSpreadableBlocks(List<Material> blocks) {
        knownBlocks.addAll(blocks);
    }

    public static void addExcludedSpreadableBlocks(List<Material> blocks) {
        excludedBlocks.addAll(blocks);
    }
}
