package org.fallen.terrainpreserver.utils;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class cropList {
    private static final Material[] includedCrops = {Material.WHEAT, Material.POTATOES, Material.CARROTS, Material.BEETROOTS,
            Material.BAMBOO, Material.BAMBOO_SAPLING, Material.MELON_STEM, Material.PUMPKIN_STEM};
    private static final Material[] excludedCrops = {Material.GRASS, Material.CACTUS, Material.SUGAR_CANE, Material.POPPY,
            Material.DANDELION, Material.ORANGE_TULIP, Material.PINK_TULIP, Material.RED_TULIP, Material.WHITE_TULIP,
            Material.BLUE_ORCHID, Material.AZURE_BLUET, Material.ALLIUM, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY};

    public static List<Material> getIncludedCrops() {
        return Arrays.stream(includedCrops).toList();
    }

    public static List<Material> getExcludedCrops() {
        return Arrays.stream(excludedCrops).toList();
    }
}