package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.academiadecodigo.roothless.gameobjects.Player;
import org.academiadecodigo.roothless.gameworld.GameWorld;

/**
 * Created by codecadet on 30/03/17.
 */
public class InputHandler implements InputProcessor {


    private Player player;

    public InputHandler(GameWorld gameWorld) {
        player = gameWorld.getPlayer();
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.LEFT:
                player.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                player.setRightMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode) {
            case Input.Keys.LEFT:
                player.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                player.setRightMove(false);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
