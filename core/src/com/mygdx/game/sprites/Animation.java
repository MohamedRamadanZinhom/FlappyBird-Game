package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private Array<TextureRegion> frams;
    private float MaxFrameTime;
    private float CurrentFrameTime;
    private int Frame_count;
    private int Frame;

    public Animation(TextureRegion region ,int frame_count ,float CycleTime)
    {
        frams = new Array<>();
        this.Frame_count=frame_count;
        this.MaxFrameTime=CycleTime/frame_count;
        this.Frame=0;
        int framwidth=region.getRegionWidth()/frame_count;
        for(int i=0;i<Frame_count;i++)
        {
            frams.add(new TextureRegion(region,i*framwidth,0,framwidth,region.getRegionHeight()));
        }
    }

    public void Update(float dt)
    {
        this.CurrentFrameTime+=dt;
        if(CurrentFrameTime>MaxFrameTime)
        {
            Frame++;
            CurrentFrameTime=0;
        }
        if(Frame >=Frame_count)
        {
            Frame=0;
        }
    }
    public TextureRegion GetFrame()
    {
        return frams.get(Frame);
    }

}
