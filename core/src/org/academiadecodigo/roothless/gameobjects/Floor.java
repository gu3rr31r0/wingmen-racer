package org.academiadecodigo.roothless.gameobjects;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.util.Random;

/**
 * Created by codecadet on 30/03/17.
 */
public class Floor extends Scrollabe{

    private Model model;
    private ModelBuilder modelBuilder;
    private ModelInstance instance;
    private Material material;


    public Floor(int width, int height, int depth, float x, float y, float z, float speed) {
        super(width, height, depth, x, y, z, speed);
        modelBuilder = new ModelBuilder();
        material = new Material(ColorAttribute.createDiffuse(Random.getRandomColor()));
        model = modelBuilder.createBox(7,1,7,material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
    }

    public ModelInstance getModelInstance() {
        return instance;
    }

    @Override
    public void reset(float newZ) {
        instance.model.materials.get(0).set(ColorAttribute.createDiffuse(Random.getRandomColor()));
        instance.transform.translate(0,0,newZ-7);
        super.reset(newZ);
    }
}
