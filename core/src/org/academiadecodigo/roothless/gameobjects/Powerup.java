package org.academiadecodigo.roothless.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.util.Random;

/**
 * Created by codecadet on 31/03/17.
 */
public class Powerup extends Scrollabe{

    private Model model;
    private ModelBuilder modelBuilder;
    private ModelInstance instance;
    private Material material;
    private float x;
    private String name;


    public Powerup(int width, int height, int depth, float x, float y, float z, float speed) {
        super(1, 1, 1, x = Random.obstX(3, -3), 1, -42, speed);
        ModelLoader loader = new ObjLoader();
        name = ""+Random.getPowerUp();
        model = loader.loadModel(Gdx.files.internal("data/powerups/"+name));
        instance = new ModelInstance(model);
        instance.transform.translate(x,1,-42);
    }


    public ModelInstance getInstance() {
        return instance;
    }

    public void move(float distance) {
        instance.transform.translate(0,0,distance);
        position.z = position.z-distance;

    }

    public void checkCollision(Player player) {
        System.out.println("Player position: " + player.getPosition().x);
        System.out.println("Monster position " + position.x);

        if (player.getPosition().x > position.x - 0.5 && player.getPosition().x  < position.x + 0.5) {
            System.out.println("Check if collide with objects - Bonus!");
            if (name.equals("1.obj")) {
                System.out.println("collided with the asset 1");
            }
            if (name.equals("2.obj")) {
                System.out.println("collided with the asset 2");
            }
            if (name.equals("3.obj")) {
                System.out.println("collided with the asset 3");
            }
        }
    }
}
