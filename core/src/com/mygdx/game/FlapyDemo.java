package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.MenuState;

public class FlapyDemo extends ApplicationAdapter {

	public static final int WIDTH=400;
	public static final int HEIGHT=700;

	public static final String TITLE="Flappy Bird";

    private GameStateManager gsm;
	private SpriteBatch batch;
	//Texture img;
	private Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		//img = new Texture("badlogic.jpg");
		music=Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.Push(new MenuState(gsm));

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.Update(Gdx.graphics.getDeltaTime());
		gsm.Render(batch);



	/*	batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
		//img.dispose();
	}
}
