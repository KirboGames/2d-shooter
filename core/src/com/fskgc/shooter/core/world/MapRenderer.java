package com.fskgc.shooter.core.world;

import static com.fskgc.shooter.Shooter.batch;

public class MapRenderer {
    private static Map map;

    public static void setMap(Map map) {
        MapRenderer.map = map;
    }

    public static void render() {
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                if (map.getId(x, y) != 0) {
                    batch.draw(map.getBlock(x, y).getTexture(), x, y, 1, 1);
                }
            }
        }
    }
}
