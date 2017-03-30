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
    private float runTime;


    public GameScreen() {

        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld));



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        runTime += delta;

        gameRenderer.render(runTime);

        gameWorld.update(delta);

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
