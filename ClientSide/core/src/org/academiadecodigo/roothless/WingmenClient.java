package org.academiadecodigo.roothless;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

public class WingmenClient extends Game {

	private UDPConnector udpConnector;
	private Texture back;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		back = new Texture(Gdx.files.internal("clientstart.png"));

		batch = new SpriteBatch();


		System.out.println("cria");
		udpConnector = new UDPConnector();
		InputHandler inputHandler = new InputHandler(udpConnector);
		udpConnector.setInputHandler(inputHandler);
		Gdx.input.setInputProcessor(inputHandler);


	}

	@Override
	public void render () {

		batch.begin();
		batch.draw(new TextureRegion(back), 0,0 , Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();



		udpConnector.render();
	}

}
