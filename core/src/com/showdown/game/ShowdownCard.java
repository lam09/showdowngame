package com.showdown.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.showdown.game.states.GameStateManager;

public class ShowdownCard extends ApplicationAdapter {
	public static final int WIDTH= 150;
	public static final int HEIGHT= 800;

	GameStateManager gsm;

	SpriteBatch batch;
	Texture img;
	Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/background.mp3"));
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(img, 0, 0);
		batch.end();
	}
}
