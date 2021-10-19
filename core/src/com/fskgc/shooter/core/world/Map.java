package com.fskgc.shooter.core.world;

import com.badlogic.gdx.Gdx;

public class Map {
    private int[][] map;

    public void createMap(int width, int height) {
        map = new int[width][height];
        Gdx.app.log("Map", "created map with size x: " + width + ", y: " + height);
    }

    public void setBlock(int x, int y, int id) {
        map[x][y] = id;
        Gdx.app.log("Map", "setblock x: " + x + ", y: " + y + ", id: " + id);
    }

    public Block getBlock(int x, int y) {
        return Blocks.getBlock(map[x][y]);
    }

    public int getId(int x, int y) {
        return map[x][y];
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }
}
