package org.academiadecodigo.roothless.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.util.Random;

/**
 * Created by codecadet on 31/03/17.
 */
public class Obstacle extends Scrollabe{

    private Model model;
    private ModelBuilder modelBuilder;
    private ModelInstance instance;
    private Material material;
    private float x;


    public Obstacle(int width, int height, int depth, float x, float y, float z, float speed) {
        super(1, 1, 1, x = Random.obstX(3, -3), 1, -42, speed);
        modelBuilder = new ModelBuilder();
        material = new Material(ColorAttribute.createDiffuse(Color.BLACK));
        model = modelBuilder.createBox(1,1,1, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
        instance.transform.translate(x,1,-42);


    }



    public ModelInstance getInstance() {
        return instance;
    }

    public void move(float distance) {
        instance.transform.translate(0,0,distance);
        position.z = position.z+distance;

    }

    public void checkCollision(Player player) {
        System.out.println("here!");
        if (player.getPosition().x > position.x - 0.5 && player.getPosition().x  < position.x + 0.5) {
            System.exit(1);
        }
    }
}
