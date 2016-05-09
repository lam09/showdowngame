package com.showdown.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.showdown.game.ShowdownCard;

/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public class State1 extends State {

    public static final int ROW = 4;
    public static final int COLUMN = 3;

    private AtlasRegion bg;

    private Stage stage;
    private Array<AtlasRegion> symbols;

    int i = 1;
    private Button but;
    private Array<Button> buttons;
    private Array<Vector3> positions;
    private Array<Button.ButtonStyle> buttonStyles;
    private Array<Rectangle> bounds;
    private Integer cout_symbol;
    public State1(GameStateManager gsm)
    {
        super(gsm);
        stage = new Stage();

        but = new Button();
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up= buttonSkin.getDrawable("1");
       style.down = buttonSkin.getDrawable("1Glow");
        but.setStyle(style);
        stage.addActor(but);
        symbols = new Array<AtlasRegion>();
        for (int i=1;i<=12;i++)
        {
            AtlasRegion symbol = new AtlasRegion(textureAtlas.findRegion(""+i));
            symbols.add(symbol);
        }
        bg = new AtlasRegion(textureAtlas.findRegion("BackgroundDown_a"));
        buttons=new Array<Button>();
        buttonStyles=new Array<Button.ButtonStyle>();
        bounds = new Array<Rectangle>();
        positions = new Array<Vector3>();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if (i == 12) i = 1;
            else i++;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bg = new AtlasRegion(textureAtlas.findRegion(""+i));
    }

    @Override
    public void render(SpriteBatch sb,float delta) {
        stage.act();
        sb.begin();
        sb.draw(bg,0,0);
      //  stage.act();
        stage.draw();
//but.draw(sb,delta);
//        for(int i = 0;i<12;i++)
 //           sb.draw(symbols.get(i),positions.get(i).x,positions.get(i).y,ShowdownCard.WIDTH/3,ShowdownCard.HEIGHT/4);
    //    for (Button button:buttons)
     //   button.draw(sb,delta);
        sb.end();
    }
}
