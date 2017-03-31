package org.academiadecodigo.roothless.gameworld;

import org.academiadecodigo.roothless.gameobjects.Player;
import org.academiadecodigo.roothless.gameobjects.ScrollHandler;

/**
 * Created by codecadet on 30/03/17.
 */
public class GameWorld {

    private ScrollHandler scroll;
    private Player player;
    private float delta;
    private GameState currentState;


    public GameWorld() {


        scroll = new ScrollHandler(0, this, 5);

        player = new Player();



    }

    public ScrollHandler getScroll() {
        return scroll;
    }

    public void update(float delta) {
        scroll.update(delta);
        player.updateMotion();
    }

    public Player getPlayer() {
        return player;
    }

    public void pause() {

    }
}
