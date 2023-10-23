package org.fallen.terrainpreserver.utils;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class blocksToString {
    public static String formatBlockList(List<Material> blocks) {
        // Initialize final list
        List<String> finalStringList = new ArrayList<>();
        // Iterate through blocks
        blocks.forEach(block -> {
            if (!block.toString().isEmpty()) {
                // Grab each word in the blocks name and delete the '_'
                List<String> materialLowerCase = List.of(block.toString().toLowerCase().split("_"));

                // Capitalizing each word
                materialLowerCase = materialLowerCase.stream().map(
                        word -> word.substring(0, 1).toUpperCase() + word.substring(1)).collect(Collectors.toList());

                // turn list of words into the block name as a string and add it to the final list of blocks
                finalStringList.add(String.join(" ", materialLowerCase));
            }
        });
        // return formatted display string (remove brackets, make commas into new lines, and add a dash before each block in the list)
        return " - " + finalStringList.toString().replace("[", "").replace("]", "").replaceAll(", ", "\n - ");
    }
}
