package com.fskgc.shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fskgc.shooter.core.physic.Physic;
import com.fskgc.shooter.core.utils.Camera2D;
import com.fskgc.shooter.core.world.*;

public class Shooter extends ApplicationAdapter {
    public static SpriteBatch batch;
    private Map map;
    public static Camera2D gameCamera;

    Box2DDebugRenderer DR;

    @Override
    public void create() {
        DR = new Box2DDebugRenderer();
        batch = new SpriteBatch();
        gameCamera = new Camera2D(16);
        Blocks.defineBlock(new Block(1, "blocks/grass.png"));
        Blocks.defineBlock(new Block(2, "blocks/wood.png"));
        map = MapLoader.load("map/first.map");
        MapRenderer.setMap(map);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        gameCamera.update(batch);
        batch.begin();
        MapRenderer.render();
        batch.end();
        batch.begin();
        DR.render(Physic.getWorld(), gameCamera.CAMERA.combined);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
