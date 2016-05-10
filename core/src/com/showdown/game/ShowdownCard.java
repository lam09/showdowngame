package com.showdown.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.showdown.game.states.GameStateManager;
import com.showdown.game.states.MenuState;
import com.showdown.game.states.State1;
import com.showdown.game.states.State2;

public class ShowdownCard extends ApplicationAdapter {
	public static final int WIDTH= 1680;
	public static final int HEIGHT= 1050;

	GameStateManager gsm;

	SpriteBatch batch;
	Texture img;
	Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new State2(gsm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch, Gdx.graphics.getDeltaTime());
	}
}
