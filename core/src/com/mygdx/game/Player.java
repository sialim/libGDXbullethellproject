package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
    private final float BASE_SPEED = 200;

    private int health;
    private float speed;
    private float x;
    private float y;

    public Player(int health) {
        this.health = health;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(float deltaTime) {
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            speed = BASE_SPEED / 2.0f;
        } else {
            speed = BASE_SPEED;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += speed * deltaTime;
            if (y > (MainGame.SCREEN_HEIGHT/2)) {
                y = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= speed * deltaTime;
            if (y < -(MainGame.SCREEN_HEIGHT/2)) {
                y = 0;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
             x -= speed * deltaTime;
             if (x < -(MainGame.SCREEN_WIDTH/2)) {
                 x = 0;
             }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * deltaTime;
            if (x > (MainGame.SCREEN_WIDTH/2)) {
                x = 0;
            }
        }
    }
}
