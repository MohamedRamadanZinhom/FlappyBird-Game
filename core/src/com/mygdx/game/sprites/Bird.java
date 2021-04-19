package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    private static final int GRAVITY=-15;
    private static final int MOVEMENT=100;
    private Vector3 Velocity;
    private Vector3 Position;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Sound flap;



  //  private Texture bird;

    Texture img=new Texture("birdanimation.png");

    public Bird(int X ,int Y ) {
        Position = new Vector3(X,Y,0);
        Velocity=new Vector3(0,0,0);


        birdAnimation=new Animation(new TextureRegion( img ) ,3,0.5f);


        bounds=new Rectangle(X,Y,img.getWidth()/3,img.getHeight());
        flap= Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));

    }

    public void Update(float dt)
    {
        birdAnimation.Update(dt);
        if(Position.y>0) { Velocity.add(0, GRAVITY, 0); }

         Velocity.scl(dt);

        Position.add(MOVEMENT *dt ,Velocity.y,0);
        if(Position.y < 0)
            Position.y=0;


        Velocity.scl(1/dt);
        bounds.setPosition(Position.x,Position.y);

    }
    public TextureRegion getBird() {
        return birdAnimation.GetFrame();
    }

    public Vector3 getVelocity() {
        return Velocity;
    }

    public Vector3 getPosition() {
        return Position;
    }

    public void Flay()
    {
        Velocity.y=200;
        flap.play(0.5f);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void Dispose() {
        img.dispose();
        flap.dispose();
    }
}
