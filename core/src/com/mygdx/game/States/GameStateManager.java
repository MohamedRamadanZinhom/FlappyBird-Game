package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager()
    {
        states=new Stack<State>();
    }
    public void Push(State state)
    {
        states.push(state);
    }
    public void Pop()
    {
        states.pop().Dispose();
    }
    public void setState(State state)
    {
        states.pop().Dispose();
        states.push(state);

    }

    public void Update(float dt)
    {
        states.peek().Update(dt);
    }
    public void Render(SpriteBatch sp)
    {
        states.peek().Render(sp);
    }

}
