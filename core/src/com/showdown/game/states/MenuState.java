package com.showdown.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.showdown.game.ShowdownCard;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public  class MenuState extends State {


    AtlasRegion bg;


    public MenuState(GameStateManager gsm) {

        super(gsm);
        bg=textureAtlas.findRegion("BackgroundDown_a");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
        {
            gsm.set(new State1(gsm));
            //dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb,float delta) {
    sb.begin();
//if(bg==null)System.out.print("back ground is null");
//else
        sb.draw(bg,0,0, ShowdownCard.WIDTH,ShowdownCard.HEIGHT);
        //sb.draw(bg,0,0,0,0,bg.getRegionHeight(),bg.getRegionWidth(),1f,1f,0,true);
        sb.end();
    }
}
