package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class BulletPattern {

    public BulletPattern() {
    }

    public Array<Bullet> createStraightPattern(float startX, float startY, float angle, int count, float speed) {
        Array<Bullet> bullets = new Array<>();
        for (int i = 0; i < count; i++) {
            bullets.add(new Bullet(startX, startY, angle, speed));
        }
        return bullets;
    }

    public Array<Bullet> createRadialPattern(float startX, float startY, int count, float speed) {
        Array<Bullet> bullets = new Array<>();
        float angleStep = 360.0f / count;

        for (int i = 0; i < count; i++) {
            float angle = i * angleStep;
            bullets.add(new Bullet(startX, startY, angle, speed));
        }
        return bullets;
    }

    public Array<Bullet> createFanPattern(float startX, float startY, float centerAngle, float spreadAngle, int count, float speed) {
        Array<Bullet> bullets = new Array<>();
        float angleStep = spreadAngle / (count - 1);

        for (int i = 0; i < count; i++) {
            float angle = centerAngle - (spreadAngle / 2) + (i * angleStep);
            bullets.add(new Bullet(startX, startY, angle, speed));
        }
        return bullets;
    }
}