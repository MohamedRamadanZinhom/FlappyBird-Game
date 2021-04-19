package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlapyDemo;

public class MenuState extends State {

   private Texture Background;
   private Texture Playbutton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlapyDemo.WIDTH/2,FlapyDemo.HEIGHT/2);
        Background=new Texture("bg.png");
        Playbutton=new Texture("playbtn.png");
    }

    @Override
    protected void HandelInput() {

        if(Gdx.input.justTouched())
        {
            gsm.Push(new PlayState(gsm));

        }

    }

    @Override
    public void Update(float dt) {

        HandelInput();
    }

    @Override
    public void Render(SpriteBatch sp) {

          sp.setProjectionMatrix(cam.combined);
          sp.begin();
         // sp.draw(Background,0,0, FlapyDemo.WIDTH,FlapyDemo.HEIGHT);
        sp.draw(Background,0,0); //for android
          sp.draw(Playbutton,cam.position.x-Playbutton.getWidth() /2,cam.position.y);
          sp.end();

    }

    @Override
    public void Dispose() {
        Background.dispose();
        Playbutton.dispose();
    }
}
