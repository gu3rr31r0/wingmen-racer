package org.academiadecodigo.roothless.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by codecadet on 30/03/17.
 */
public class Player {

    private Model model;
    private ModelBuilder modelBuilder;
    private ModelInstance playerInstance;
    private Material material;

    private Vector3 position;
    private Vector3 velocity;
    private Vector3 acceleration;
    private int width;
    private int height;

    boolean leftMove;
    boolean rightMove;

    public Player() {
        position=new Vector3(0, 0, 0);
        modelBuilder = new ModelBuilder();
        material = new Material(ColorAttribute.createDiffuse(Color.WHITE));
        model = modelBuilder.createBox(1, 0.3f, 1, material, VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        playerInstance = new ModelInstance(model);
        playerInstance.transform.translate(0,2.5f,4);
    }

    public ModelInstance getPlayerInstance() {
        return playerInstance;
    }


    public void updateMotion() {

/*        if (leftMove) {
            if (position.x < -3.5) {
                return;
            }
            position.x -= 0.5 * Gdx.graphics.getDeltaTime();


        }
        if (rightMove) {
            position.x += 0.5 * Gdx.graphics.getDeltaTime();

        }*/

        if (leftMove) {

            if (position.x > -2.5) {
                playerInstance.transform.translate(-0.05f, 0, 0);
                position.x = position.x - 0.05f;
            }



            //if (!Intersector.overlaps())


        }
        if (rightMove) {
            if (position.x < 2.5) {
                playerInstance.transform.translate(0.05f, 0, 0);
                position.x = position.x + 0.05f;
            }


        }
    }


    public void setLeftMove(boolean t) {
        if (rightMove && t) rightMove = false;
        leftMove = t;
    }

    public void setRightMove(boolean t) {
        if (leftMove && t) leftMove = false;
        rightMove = t;
    }

    public Vector3 getPosition() {
        return position;
    }
}
