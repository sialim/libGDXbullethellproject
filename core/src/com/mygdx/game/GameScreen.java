package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
    private MainGame mainGame;

    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
    }
    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(.1f, .1f, .15f, 1);
    }

    @Override
    public void resize(int x, int y) {
        super.resize(x, y);
    }
}
