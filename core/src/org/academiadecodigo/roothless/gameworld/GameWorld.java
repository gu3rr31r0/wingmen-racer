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
    private int playerPosZ;

    public GameWorld(int playerPosZ) {
        this.playerPosZ = playerPosZ;

        scroll = new ScrollHandler(0, this, 1);

    }

    public void update(float delta) {
        scroll.update(delta);
    }

    public Player getPlayer() {
        return player;
    }
}
