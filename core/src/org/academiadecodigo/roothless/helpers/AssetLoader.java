package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.gameobjects.Floor;
import org.academiadecodigo.roothless.gameobjects.Player;

/**
 * Created by codecadet on 30/03/17.
 */
public class AssetLoader {

    public static Texture backGround;


    public static void load() {

        backGround = new Texture(Gdx.files.internal("data/giphy.gif"));
    }

    public static void dispose() {
        backGround.dispose();
    }

}
