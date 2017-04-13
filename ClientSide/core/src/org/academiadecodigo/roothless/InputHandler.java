package org.academiadecodigo.roothless;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by codecadet on 31/03/17.
 */
public class InputHandler implements InputProcessor {

    private UDPConnector udpConnector;

    private boolean sendMessage;

    public boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public InputHandler(UDPConnector udpConnector) {
        System.out.println("Here");
        this.udpConnector = udpConnector;
        sendMessage = false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.RIGHT == keycode) {
            sendMessage = true;
            udpConnector.sendMessage("right");
            return true;
        }
        if (Input.Keys.LEFT == keycode) {
            sendMessage = true;
            udpConnector.sendMessage("left");
            return true;
        }
        if (Input.Keys.SPACE == keycode) {
            sendMessage = true;
            udpConnector.sendMessage("start");
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
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
