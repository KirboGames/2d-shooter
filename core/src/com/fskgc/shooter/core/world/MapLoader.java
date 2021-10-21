package com.fskgc.shooter.core.world;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.HashMap;

public class MapLoader {
    public static Map load(String mapPath) {
        Map map = new Map();

        parse(map, Gdx.files.internal(mapPath).readString());

        return map;
    }

    private static void parse(Map map, String mapString) {
        String[] lines = mapString.split("\\r?\\n");
        ArrayList<String> paramLines = new ArrayList<>();
        ArrayList<String> world = new ArrayList<>();
        int i = 0;
        while (!lines[i].equals("$")) {
            paramLines.add(lines[i]);
            i++;
        }
        i++;
        while (i < lines.length) {
            world.add(lines[i]);
            i++;
        }
        parseWorld(map, world, parseParams(paramLines));
    }

    private static HashMap<String, String> parseParams(ArrayList<String> stringArray) {
        HashMap<String, String> params = new HashMap<>();
        for (String string : stringArray) {
            String[] param = string.split(":");
            params.put(param[0], param[1]);
        }
        return params;
    }

    private static void parseWorld(Map map, ArrayList<String> world, HashMap<String, String> params) {
        int w = Integer.parseInt(params.get("width"));
        int h = Integer.parseInt(params.get("height"));
        map.createMap(w, h);
        for (int y = 0; y < h; y++) {
            String[] ids = world.get(y).split(" ");
            for (int x = 0; x < w; x++) {
                map.setBlock(x, h - y - 1, Integer.parseInt(ids[x]));
            }
        }
    }
}