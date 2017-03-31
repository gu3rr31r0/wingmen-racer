package org.academiadecodigo.roothless.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.academiadecodigo.roothless.WingRunner;
import org.academiadecodigo.roothless.gameworld.GameRenderer;
import org.academiadecodigo.roothless.gameworld.GameWorld;
import org.academiadecodigo.roothless.helpers.AssetLoader;
import org.academiadecodigo.roothless.helpers.InputHandler;
import org.academiadecodigo.roothless.helpers.MenuKeyboard;

/**
 * Created by codecadet on 31/03/17.
 */
public class InitialScreen implements Screen {

   private MenuKeyboard inputHandler;
   private WingRunner wingRunner;
   private SpriteBatch batcher;



    public InitialScreen(WingRunner wingRunner) {
        batcher = new SpriteBatch();
        this.inputHandler = new MenuKeyboard();
        this.wingRunner = wingRunner;
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        batcher.begin();
        batcher.draw(new TextureRegion(AssetLoader.menu), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batcher.end();

        if (!inputHandler.onMenu()) {
           wingRunner.loadGame();
        }

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
