package com.fskgc.shooter.core.world;

import java.util.HashMap;

public class Blocks {
    private static final HashMap<Integer, Block> blocks = new HashMap<>();

    public static void defineBlock(Block block) {
        blocks.put(block.getId(), block);
    }

    public static Block getBlock(int id) {
        return blocks.get(id);
    }
}
