package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

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
