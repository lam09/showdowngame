package com.showdown.game.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.showdown.game.ShowdownCard;


/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public class State2 extends State {

    private Stage stage;
    private Array<Texture> gamePlan;
    private int show_plan;
    TextButton next_plan ;
    private Stage stage_plan;
    private Skin skin_plan;
    //private int i=0;
    public State2(GameStateManager gsm) {
        super(gsm);
        skin_plan = new Skin();
        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin_plan.add("white", new Texture(pixmap));

        // Store the default libgdx font under the name "default".
        BitmapFont bfont=new BitmapFont(Gdx.files.internal("font/font.fnt"));
        skin_plan.add("default",bfont);

        stage_plan = new Stage();
        gamePlan = new Array<Texture>();
        for (int i=1;i<=5;i++)
        {
            Texture plan = new Texture("game_plan/"+i+".jpg");
            gamePlan.add(plan);
        }
        show_plan = 0;
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin_plan.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin_plan.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin_plan.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin_plan.newDrawable("white", Color.LIGHT_GRAY);

        textButtonStyle.font = skin_plan.getFont("default");
        next_plan = new TextButton("NEXT", textButtonStyle);
        next_plan.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(show_plan < 4) show_plan++;
                else show_plan =0;
            }
        });
        stage_plan.addActor(next_plan);
        Gdx.input.setInputProcessor(stage_plan);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb,float delta) {
        stage_plan.act();
        sb.begin();
        sb.draw(gamePlan.get(show_plan), 0, 0, ShowdownCard.WIDTH, ShowdownCard.HEIGHT);
        sb.end();
        sb.begin();
        stage_plan.draw();
        sb.end();
    }
}
