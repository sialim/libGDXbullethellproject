package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainGame extends ApplicationAdapter {
	public static int SCREEN_WIDTH = 500;
	public static int SCREEN_HEIGHT = 700;

	private float deltaTime = 0;
	private float distance = 0;

	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite sprite;
	Sprite background;
	Player player;
	
	@Override
	public void create () {

		player = new Player(200);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch = new SpriteBatch();

		sprite = new Sprite(new Texture("player.png"));
		sprite.setPosition(0, 0);
		sprite.setSize(20, 20);

		background = new Sprite(new Texture("background.jpg"));
		background.setPosition(0, 0);
	}

	@Override
	public void render () {
		deltaTime = Gdx.graphics.getDeltaTime();
		player.move(deltaTime);

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ScreenUtils.clear(1, 0, 0, 1);
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(background, -650, -350);
		batch.draw(sprite, player.getX(), player.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
