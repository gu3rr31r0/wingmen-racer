package org.academiadecodigo.roothless.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import org.academiadecodigo.roothless.gameworld.GameRenderer;
import org.academiadecodigo.roothless.gameworld.GameWorld;
import org.academiadecodigo.roothless.helpers.InputHandler;

/**
 * Created by codecadet on 30/03/17.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private InputHandler inputHandler;
    private float runTime;


    public GameScreen() {

        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);

        inputHandler = new InputHandler(gameWorld);

        Gdx.input.setInputProcessor(inputHandler);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        runTime += delta;

        gameWorld.update(delta);
        gameRenderer.render(runTime);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
