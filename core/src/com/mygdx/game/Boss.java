package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class Boss extends Entity {

    private String name;
    private float maxHP;
    private float hp;
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

    @Override
    public void move(float deltaTime) {
        if(super.getX() > (float) Gdx.graphics.getWidth() / 2) {

        }
    }

    public void initiateSequence() {
        while(super.getY() < (float) Gdx.graphics.getHeight() /2) {
            super.setY(super.getY()-1);
        }
    }

    @Override
    public void shoot() {
        // figure this out later.
    }

    public Boss(float maxHealth, float damage, CollisionRect rect, Sprite sprite, Bullet bullet) {
        super(maxHealth, damage, rect, sprite);
        this.bullet = bullet;
    }


    public void updatePhase() {
        if (hp > maxHP * 2 / 3) {
            phase = 1;
        } else if (hp > maxHP / 3) {
            phase = 2;
        } else if (hp > 0) {
            phase = 3;
        } else {
            phase = 0;
        }
    }

    public int getAtk() {
        return atk;
    }

    public void takeDamage(float dmg) {
        hp -= dmg;
        if (hp < 0) {
            hp = 0;
        }
        updatePhase();
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public String toString() {
        updatePhase();
        if (hp == 0) {
            return name + " is dead";
        }
        return name + " has " + hp + "/" + maxHP + " health and " + atk + " attack power and is at phase " + phase;
    }
}