package org.academiadecodigo.roothless.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.roothless.WingmenClient;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Di Mario Client";
		config.width = 768;
		config.height = 768;
		new LwjglApplication(new WingmenClient(), config);
	}
}
