package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.gameobjects.Floor;

/**
 * Created by codecadet on 30/03/17.
 */
public class AssetLoader {

    public static Floor floor1;
    public static ModelInstance floor1Instance;
    public static Floor floor2;
    public static ModelInstance floor2Instance;
    public static Floor floor3;
    public static ModelInstance floor3Instance;
    public static Floor floor4;
    public static ModelInstance floor4Instance;
    public static Texture backGround;

    public static void load() {

        ModelBuilder modelBuilder = new ModelBuilder();

        backGround = new Texture(Gdx.files.internal("data/backGround.jpg"));

        Model mFloor2 = modelBuilder.createBox(7,1,7,
                new Material(ColorAttribute.createDiffuse(Color.YELLOW)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        Model floor1 = modelBuilder.createBox(7,1,7,
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        Model floor3 = modelBuilder.createBox(7,1,7,
                new Material(ColorAttribute.createDiffuse(Color.BLUE)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        Model floor4 = modelBuilder.createBox(7,1,7,
                new Material(ColorAttribute.createDiffuse(Color.BROWN)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);




        floor1Instance = new ModelInstance(floor1);
        floor1Instance.transform.translate(0,0,0);

        floor2Instance = new ModelInstance(floor2);
        floor2Instance.transform.translate(0,0,-7);

        floor3Instance = new ModelInstance(floor3);
        floor3Instance.transform.translate(0,0,-14);

        floor4Instance = new ModelInstance(floor4);
        floor4Instance.transform.translate(0,0,-21);

    }

    public static void dispose() {


    }
}
