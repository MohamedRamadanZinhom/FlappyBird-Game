package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

    private static final int FLUCTUATION=130;
    private static final int TUBE_GAP=100;
    private static final int LOWEST_OPENING=120;
    public static final int TUBE_WIDTH=52;


    private Texture TopTube,BottomTube;
    private Vector2 top_pos,bottom_pos;
    private Rectangle bounds_top,bounds_bottom;


    private Random rand;

    public Tube(float x)
    {
        TopTube=new Texture("toptube.png");
        BottomTube=new Texture("bottomtube.png");
        rand=new Random();

        top_pos=new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        bottom_pos=new Vector2(x,top_pos.y-TUBE_GAP-BottomTube.getHeight());

        bounds_top=new Rectangle(top_pos.x,top_pos.y,TopTube.getWidth(),TopTube.getHeight());
        bounds_bottom=new Rectangle(bottom_pos.x,bottom_pos.y,BottomTube.getWidth(),BottomTube.getHeight());

    }


    public Texture getTopTube() {
        return TopTube;
    }

    public Texture getBottomTube() {
        return BottomTube;
    }

    public Vector2 getTop_pos() {
        return top_pos;
    }

    public Vector2 getBottom_pos() {
        return bottom_pos;
    }

    public void Reposition(float x){

        top_pos.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        bottom_pos.set(x,top_pos.y-TUBE_GAP-BottomTube.getHeight());
        bounds_top.setPosition(top_pos.x,top_pos.y);
        bounds_bottom.setPosition(bottom_pos.x,bottom_pos.y);

    }

    public boolean Collied( Rectangle player ){

        return player.overlaps(bounds_top) || player.overlaps(bounds_bottom);
    }


    public void Dispose() {
        TopTube.dispose();
        BottomTube.dispose();
    }
}
