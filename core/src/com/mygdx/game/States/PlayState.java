package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.FlapyDemo;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

public class PlayState extends State {

    private static final int TUBE_COUNT=4;
    private static final int TUBE_SPACING=125;
    private static final int GROUND_Y_OFFSET=-30;


    private Bird bird;
    private Texture bg;
    private Texture ground;
    private Vector2 groundpos1,groundpos2;


    private com.badlogic.gdx.utils.Array<Tube>tubes;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird=new Bird(50,300);
        cam.setToOrtho(false, FlapyDemo.WIDTH/2,FlapyDemo.HEIGHT/2);
        bg=new Texture("bg.png");
        ground=new Texture("ground.png");
        groundpos1=new Vector2((cam.position.x-(cam.viewportWidth/2)),GROUND_Y_OFFSET);
        groundpos2=new Vector2((cam.position.x-(cam.viewportWidth/2))+ground.getWidth(),GROUND_Y_OFFSET);

        tubes = new Array<>();
        for(int i=1;i<=TUBE_COUNT;i++)
        {
            tubes.add(new Tube(i*(TUBE_SPACING+Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void HandelInput() {

        if(Gdx.input.justTouched()){
            bird.Flay();
        }

    }

    @Override
    public void Update(float dt) {

        HandelInput();
        UpdateGround();
        bird.Update(dt);

        cam.position.x= bird.getPosition().x +80;


            for(int i=0;i<tubes.size;i++)
            {
                Tube tube=tubes.get(i);

                if(cam.position.x-(cam.viewportWidth/2) > tube.getTop_pos().x +tube.getTopTube().getWidth()){
                tube.Reposition(tube.getTop_pos().x+((Tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
            }

            if(tube.Collied(bird.getBounds())){
                gsm.setState(new PlayState(gsm));
            }

        }

        if(bird.getPosition().y<=ground.getHeight()+GROUND_Y_OFFSET){
            gsm.setState(new PlayState(gsm));
        }

        cam.update();

    }

    @Override
    public void Render(SpriteBatch sp) {

        sp.setProjectionMatrix(cam.combined);
        sp.begin();
        sp.draw(bg,cam.position.x-(cam.viewportWidth/2),0);
        sp.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);
        for(Tube tube : tubes){
        sp.draw(tube.getTopTube(),tube.getTop_pos().x,tube.getTop_pos().y);
        sp.draw(tube.getBottomTube(),tube.getBottom_pos().x,tube.getBottom_pos().y);
        }
        sp.draw(ground,groundpos1.x,groundpos1.y);
        sp.draw(ground,groundpos2.x,groundpos2.y);
        sp.end();

    }

    @Override
    public void Dispose() {
        bg.dispose();
        bird.Dispose();
        for(Tube tube : tubes){ tube.Dispose();}


    }

    public void UpdateGround()
    {
        if(cam.position.x- (cam.viewportWidth/2 )> groundpos1.x+ground.getWidth() ){
            groundpos1.add(ground.getWidth()*2,0);
        }
        if(cam.position.x- (cam.viewportWidth/2 )> groundpos2.x+ground.getWidth() ){
            groundpos2.add(ground.getWidth()*2,0);
        }
    }
}
