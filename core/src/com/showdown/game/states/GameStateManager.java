package com.showdown.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public class GameStateManager {
    private ArrayList<State> states;
    private int currentState;
    public void push(State state){
        states.add(state);
    }

    public void pop(){
    }

    public void set(State state){
    }

    public void update(float dt){
        states.get(currentState).update(dt);
    }

    public boolean gotonextstate()
    {
        if(states.get(currentState+1)!= null) {
            currentState++;
            return true;
        } else return false;
    }

    public void render(SpriteBatch sb){
        states.get(currentState).render(sb);
    }
}
