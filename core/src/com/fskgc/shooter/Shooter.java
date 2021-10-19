package com.fskgc.shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fskgc.shooter.core.utils.Camera2D;
import com.fskgc.shooter.core.world.*;

public class Shooter extends ApplicationAdapter {
    public static SpriteBatch batch;
    private Map map;
    public static Camera2D gameCamera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameCamera = new Camera2D(16);
        Blocks.defineBlock(new Block(1, "blocks/grass.png"));
        Blocks.defineBlock(new Block(2, "blocks/wood.png"));
        map = MapLoader.load("assets/map/first.map");
        MapRenderer.setMap(map);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        gameCamera.update(batch);
        batch.begin();
        MapRenderer.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
