package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import sun.jvm.hotspot.utilities.BitMap;

public class GameScreen implements Screen {

    private static Array<Bullet> globalBullets;

    final MainGame mainGame;
    final BulletPattern bulletPattern;

    private Texture playerBulletTexture;
    
    private Texture bossBulletTexture;

    private float deltaTime = 0;
    private float distance = 0;

    OrthographicCamera camera;
    SpriteBatch batch;
    Sprite sprite;
    Sprite background;
    Player player;

    float timeSinceTextDisplayed;

    BitmapFont font;

    Sprite bossSprite;
    Boss hongMeiling;

    public GameScreen(final MainGame mainGame, final BulletPattern bulletPattern) {
        this.mainGame = mainGame;
        this.bulletPattern = bulletPattern;
    }
    @Override
    public void show() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1.5f);

        timeSinceTextDisplayed = 0.0f;

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        // Player sprite
        sprite = new Sprite(new Texture("player.png"));
        sprite.setPosition(0, 0);
        sprite.setSize(20, 20);

        // Player bullet sprite
        playerBulletTexture = new Texture("playerbullet.jpg");

        // Boss sprite
        bossSprite = new Sprite(new Texture("hongmeiling.png"));
        bossSprite.setPosition(0, 200);
        sprite.setSize(30, 30);

        // Boss bullet sprite
        bossBulletTexture = new Texture("bossbullet.png");

        globalBullets = new Array<>();

        background = new Sprite(new Texture("background.jpg"));
        background.setPosition(0, 0);

        player = new Player(200, 50, new CollisionRect(0, 0, 20, 20), sprite);
        hongMeiling = new Boss(50000.0f, 1.0f, new CollisionRect(0, 0, 30, 30), bossSprite);
        hongMeiling.setX(0.0f);
        hongMeiling.setY(200.0f);
    }

    @Override
    public void render(float v) {
        deltaTime = Gdx.graphics.getDeltaTime();

        player.handleShooting(deltaTime);
        player.move(deltaTime);
        player.updateBullets(deltaTime);



        player.getCollisionRect().move(player.getX(), player.getY());

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(1, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(background, -650, -350);

        for (Bullet bullet : player.getBullets()) { /*Rendering all the bullets gathered from the player's personal bullet list*/
            batch.draw(playerBulletTexture, bullet.getPosition().x, bullet.getPosition().y, 10, 20);
        }

        batch.draw(player.getSprite(), player.getX(), player.getY());

        batch.draw(hongMeiling.getSprite(), hongMeiling.getX(), hongMeiling.getY());

        // Text goes here
        font.draw(batch, "Fair is foul, and foul is far.\nHover through the fog and filthy air.", -150, -200);

        timeSinceTextDisplayed += deltaTime;
        if (timeSinceTextDisplayed >= 5.0f) {
            font.setColor(0, 0, 0, 0);
            //hongMeiling.initiateSequence();
        }

        batch.end();
    }

    @Override
    public void resize(int x, int y) {
        //super.resize(x, y);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        playerBulletTexture.dispose();
    }

    /*String message = "screaming in public restrooms prank\nAAAAAAAAAAAAAA";
        layout.setText(font, message);
		float width = layout.width;
		float height = layout.height;
        font.draw(mainGame.getBatch(), message, (Gdx.graphics.getWidth() - width) / 2, (Gdx.graphics.getHeight() + height) / 2);
        batch.begin();
        font.draw(batch, message, 200, 200);
		batch.draw(img, x, y);
		batch.end();
     */
}