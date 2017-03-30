package org.academiadecodigo.roothless.gameobjects;

import org.academiadecodigo.roothless.gameworld.GameWorld;

/**
 * Created by codecadet on 30/03/17.
 */
public class ScrollHandler {

    private GameWorld gameWorld;
    private Floor floor1, floor2, floor3, floor4;

    public ScrollHandler(float zPos, GameWorld gameWorld, float speed) {
        this.gameWorld = gameWorld;

        floor1 = new Floor(7,1,7, 0,0, zPos, speed);
        floor2 = new Floor(7,1,7, 0,0, floor1.getTailZ(), speed);
        floor3 = new Floor(7,1,7, 0,0, floor2.getTailZ(), speed);
        floor4 = new Floor(7,1,7, 0,0, floor3.getTailZ(), speed);


    }

    public void update(float delta) {

        floor1.update(delta);
        floor2.update(delta);
        floor3.update(delta);
        floor4.update(delta);

        if (floor1.isScrolledDown()) {
            floor1.reset(floor4.getTailZ());

        } else if (floor2.isScrolledDown()) {
            floor2.reset(floor1.getTailZ());

        }else if (floor3.isScrolledDown()) {
            floor3.reset(floor2.getTailZ());

        } else if (floor4.isScrolledDown()) {
            floor4.reset(floor3.getTailZ());
        }

    }

}
