package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FlapyDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= FlapyDemo.WIDTH;
		config.height= FlapyDemo.HEIGHT;
		config.title= FlapyDemo.TITLE;


		new LwjglApplication(new FlapyDemo(), config);
	}
}
