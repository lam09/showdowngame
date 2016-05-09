package com.showdown.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by a.lam.tuan on 6. 5. 2016.
 */
public class GameStateManager {
    public Stack<State> states;

    public GameStateManager(){
        states=new Stack<State>();
    }

    public void push(State state)
    {
        states.push(state);
    }
    public void pop()
    {
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }
    public void update(float dt)
    {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb,float delta){
        states.peek().render(sb,delta);
    }
}
