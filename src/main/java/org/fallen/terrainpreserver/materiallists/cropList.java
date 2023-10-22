package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.List;

public class cropList {
    // Included blocks means you can use Bonemeal to grow them.
    private static List<Material> includedCrops = List.of(Material.WHEAT, Material.POTATOES, Material.CARROTS, Material.BEETROOTS,
            Material.BAMBOO, Material.BAMBOO_SAPLING, Material.MELON_STEM, Material.PUMPKIN_STEM);
    // Excluded blocks means they can always grow
    private static List<Material> excludedCrops = List.of(Material.GRASS, Material.CACTUS, Material.SUGAR_CANE, Material.POPPY,
            Material.DANDELION, Material.ORANGE_TULIP, Material.PINK_TULIP, Material.RED_TULIP, Material.WHITE_TULIP,
            Material.BLUE_ORCHID, Material.AZURE_BLUET, Material.ALLIUM, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY);

    public static List<Material> getIncludedCrops() {
        return includedCrops;
    }

    public static List<Material> getExcludedCrops() {
        return excludedCrops;
    }

    public static void addIncludedCrops(List<Material> blocks) {
        includedCrops.addAll(blocks);
    }

    public static void addExcludedCrops(List<Material> blocks) {
        excludedCrops.addAll(blocks);
    }
}