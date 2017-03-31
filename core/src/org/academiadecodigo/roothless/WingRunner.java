package org.academiadecodigo.roothless;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import org.academiadecodigo.roothless.helpers.AssetLoader;
import org.academiadecodigo.roothless.screen.GameScreen;
import org.academiadecodigo.roothless.screen.InitialScreen;

public class WingRunner extends Game {


	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new GameScreen());
		//setScreen(new InitialScreen());

	}



	@Override
	public void dispose () {

		//super.dispose();
		//AssetLoader.dispose();

	}
}
