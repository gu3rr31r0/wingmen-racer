package org.academiadecodigo.roothless.gameobjects;

import com.badlogic.gdx.math.Vector3;

/**
 * Created by codecadet on 30/03/17.
 */
public class Scrollabe {
    protected Vector3 position;
    private Vector3 velocity;
    private int width;
    private int height;
    private int depth;
    private boolean scrolledDown;

    public Scrollabe(int width, int height, int depth, float x, float y, float z, float speed) {
        this.position = new Vector3(x,y,z);
        this.velocity = new Vector3(0,0,speed);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.scrolledDown = false;
    }

    public void update(float delta) {

        position.add(velocity.cpy().scl(delta));

        if (position.z - depth > 0) {
            scrolledDown = true;
        }

    }

    public void reset(float newZ) {
        position.z = newZ;
        scrolledDown = false;
    }

    public float getPosX() {
        return position.x;
    }

    public float getPosY() {
        return position.y;
    }

    public float getPosZ() {
        return position.z;
    }

    public float getTailZ() {
        return getPosZ() - depth;
    }

    public void stop() {
        velocity.z = 0;
    }

    public boolean isScrolledDown() {
        return scrolledDown;
    }
}
