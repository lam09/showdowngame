package com.showdown.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public abstract class State {
    protected TextureAtlas textureAtlas;
    protected GameStateManager gsm;
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected Skin buttonSkin;
    protected State(GameStateManager gsm){
        textureAtlas = new TextureAtlas(Gdx.files.internal("state1/game.atlas"));
        buttonSkin = new Skin();
        buttonSkin.addRegions(textureAtlas);
        this.gsm = gsm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 240, 400);
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb,float delta);
}
