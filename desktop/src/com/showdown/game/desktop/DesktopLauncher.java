package com.showdown.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.showdown.game.ShowdownCard;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=ShowdownCard.WIDTH;
		config.height=ShowdownCard.HEIGHT;
		new LwjglApplication(new ShowdownCard(), config);
	}
}
