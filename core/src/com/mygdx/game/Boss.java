package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class Boss extends Entity {

    private String name;
    private double maxHP;
    private double hp;
    private int atk;
    private int phase;
    private Bullet bullet;
    private CollisionRect rect;
    private Array<Bullet> bullets;

    private float fireCooldown = 0.25f;
    private float timeSinceLastShot = 0.0f;

    private float moveCooldown = 0.5f;
    private float timeSinceLastMove = 0.0f;

    public Boss(float maxHealth, float damage, CollisionRect rect, Sprite sprite) {
        super(maxHealth, damage, rect, sprite);
    }
}