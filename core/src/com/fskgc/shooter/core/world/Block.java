package com.fskgc.shooter.core.world;

import com.badlogic.gdx.graphics.Texture;
import com.fskgc.shooter.core.utils.Resource;

public class Block {
    private final int id;
    private final Texture texture;

    public Block(int id, String texturePath) {
        this.id = id;
        texture = Resource.getTexture(texturePath);
    }

    public int getId() {
        return id;
    }

    public Texture getTexture() {
        return texture;
    }
}
