package com.fskgc.shooter.core.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.fskgc.shooter.core.utils.Resource;

import static com.fskgc.shooter.Shooter.batch;

public class Player {
    public float x, y;
    public float width = 2;
    public float height = 2;
    private Texture playerTexture = Resource.getTexture("Player.png");

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) y+= 0.05;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-= 0.05;
    }
    public void render() {
        batch.draw(playerTexture, x, y, width, height);
    }
}