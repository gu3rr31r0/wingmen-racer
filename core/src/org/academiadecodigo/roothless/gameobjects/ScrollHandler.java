package org.academiadecodigo.roothless.gameobjects;

import org.academiadecodigo.roothless.gameworld.GameWorld;

/**
 * Created by codecadet on 30/03/17.
 */
public class ScrollHandler {

    private GameWorld gameWorld;
    private Floor floor1, floor2, floor3, floor4, floor5, floor6, floor7;

    public Floor getFloor1() {
        return floor1;
    }

    public Floor getFloor2() {
        return floor2;
    }

    public Floor getFloor3() {
        return floor3;
    }

    public Floor getFloor4() {
        return floor4;
    }

    public ScrollHandler(float zPos, GameWorld gameWorld, float speed) {
        this.gameWorld = gameWorld;

        floor1 = new Floor(7,1,7, 0,0, zPos, speed);
        floor2 = new Floor(7,1,7, 0,0, floor1.getTailZ(), speed);
        floor3 = new Floor(7,1,7, 0,0, floor2.getTailZ(), speed);
        floor4 = new Floor(7,1,7, 0,0, floor3.getTailZ(), speed);
        floor5 = new Floor(7,1,7, 0,0, floor4.getTailZ(), speed);
        floor6 = new Floor(7,1,7, 0,0, floor5.getTailZ(), speed);
        floor7 = new Floor(7,1,7, 0,0, floor6.getTailZ(), speed);

    }

    public void update(float delta) {

        if (floor1.isScrolledDown()) {
            floor1.reset(floor7.getTailZ());

        } else if (floor2.isScrolledDown()) {
            floor2.reset(floor1.getTailZ());

        }else if (floor3.isScrolledDown()) {
            floor3.reset(floor2.getTailZ());

        } else if (floor4.isScrolledDown()) {
            floor4.reset(floor3.getTailZ());

        } else if (floor5.isScrolledDown()) {
            floor5.reset(floor4.getTailZ());

        } else if (floor5.isScrolledDown()) {
            floor5.reset(floor4.getTailZ());

        } else if (floor6.isScrolledDown()) {
            floor6.reset(floor5.getTailZ());

        } else if (floor7.isScrolledDown()) {
            floor7.reset(floor6.getPosZ());
        }

        floor1.update(delta);
        floor2.update(delta);
        floor3.update(delta);
        floor4.update(delta);
        floor5.update(delta);
        floor6.update(delta);
        floor7.update(delta);

    }

    public Floor getFloor5() {
        return floor5;
    }

    public Floor getFloor6() {
        return floor6;
    }

    public Floor getFloor7() {
        return floor7;
    }
}
