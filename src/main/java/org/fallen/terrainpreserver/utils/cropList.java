package org.fallen.terrainpreserver.utils;

import org.bukkit.Material;

import java.util.ArrayList;

public class cropList {
    private static ArrayList<Material> includedCrops = new ArrayList<>();
    private static ArrayList<Material> excludedCrops = new ArrayList<>();

    cropList() {
        setIncludedCrops(includedCrops);
        setExcludedCrops(excludedCrops);
    }

    public static ArrayList<Material> getIncludedCrops() {
        return includedCrops;
    }

    public static ArrayList<Material> getExcludedCrops() {
        return excludedCrops;
    }

    public void setIncludedCrops(ArrayList<Material> includedCrops) {
        includedCrops.add(Material.WHEAT);
        includedCrops.add(Material.POTATOES);
        includedCrops.add(Material.CARROTS);
        includedCrops.add(Material.BEETROOTS);
        includedCrops.add(Material.BAMBOO);
        includedCrops.add(Material.BAMBOO_SAPLING);
        includedCrops.add(Material.MELON_STEM);
        includedCrops.add(Material.PUMPKIN_STEM);

        cropList.includedCrops = includedCrops;
    }

    public void setExcludedCrops(ArrayList<Material> excludedCrops) {
        excludedCrops.add(Material.GRASS);
        excludedCrops.add(Material.CACTUS);
        excludedCrops.add(Material.SUGAR_CANE);
        // Flowers
        excludedCrops.add(Material.POPPY);
        excludedCrops.add(Material.DANDELION);
        excludedCrops.add(Material.ORANGE_TULIP);
        excludedCrops.add(Material.PINK_TULIP);
        excludedCrops.add(Material.RED_TULIP);
        excludedCrops.add(Material.WHITE_TULIP);
        excludedCrops.add(Material.BLUE_ORCHID);
        excludedCrops.add(Material.AZURE_BLUET);
        excludedCrops.add(Material.ALLIUM);
        excludedCrops.add(Material.OXEYE_DAISY);
        excludedCrops.add(Material.CORNFLOWER);
        excludedCrops.add(Material.LILY_OF_THE_VALLEY);

        cropList.excludedCrops = excludedCrops;
    }


}