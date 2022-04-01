package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainMenuScreen implements Screen {

    final Drop game;
    SpriteBatch batch;
    OrthographicCamera camera;
    TextureRegion backgroundTexture;
    Music backgroundMusic;

    public MainMenuScreen(final Drop gam) {
        game = gam;

        backgroundTexture = new TextureRegion(new Texture("Background.png"), 0, 0, 800, 480);
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("аймесионьль.mp3"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0);
        game.batch.draw(backgroundTexture, 0, Gdx.graphics.getHeight());
        game.font.draw(game.batch, " Nach Poslednii Zaezd ", 350, 150);
        game.font.draw(game.batch, "Famili it Glavnoe!", 350, 100);
        game.batch.end();


        camera.update();
        game.batch.setProjectionMatrix(camera.combined);


        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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
        backgroundMusic.dispose();
    }
}