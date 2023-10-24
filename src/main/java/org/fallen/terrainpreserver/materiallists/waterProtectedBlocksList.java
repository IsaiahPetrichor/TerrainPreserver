package org.fallen.terrainpreserver.materiallists;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.fallen.terrainpreserver.materiallists.cropList.getExcludedCrops;
import static org.fallen.terrainpreserver.materiallists.cropList.getIncludedCrops;
import static org.fallen.terrainpreserver.materiallists.spreadBlocksList.getIncludedSpreadableBlocks;
import static org.fallen.terrainpreserver.materiallists.spreadBlocksList.getKnownSpreadableBlocks;

public class waterProtectedBlocksList {
    private static List<Material> protectedBlocks = joinLists(
            getIncludedCrops(), getExcludedCrops(), getIncludedSpreadableBlocks(), getKnownSpreadableBlocks());

    @SafeVarargs
    private static List<Material> joinLists(List<Material>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static List<Material> getWaterProtectedBlocks() {
        return protectedBlocks;
    }

    public static void addWaterProtectedBlocks(List<Material> blocks) {
        protectedBlocks.addAll(blocks);
    }
}
