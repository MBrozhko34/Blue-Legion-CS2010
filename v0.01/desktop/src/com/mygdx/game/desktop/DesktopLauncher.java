package com.mygdx.game.desktop;

import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//sets the size of the game window to be based off the size of the screen being used 
		//config.height=Toolkit.getDefaultToolkit().getScreenSize().height;
		config.height=800;
		//config.width=Toolkit.getDefaultToolkit().getScreenSize().width;
		config.width=1000;
		//locks the frame rate
		config.foregroundFPS=30;
		new LwjglApplication(new CombatUI(), config);
	}
}
