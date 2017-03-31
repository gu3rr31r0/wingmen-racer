package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Animation;
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
    public static Texture mario1;
    public static Texture mario2;
    public static Texture mario3;
    public static Animation animation;


    public static void load() {

        backGround = new Texture(Gdx.files.internal("data/giphy.gif"));
        mario1 = new Texture(Gdx.files.internal("data/left_leg_mario.png"));
        mario2 = new Texture(Gdx.files.internal("data/still_mario.png"));
        mario3 = new Texture(Gdx.files.internal("data/right_leg_mario.png"));

        Texture[] marios = {mario1, mario2, mario3};
        animation = new Animation(0.06f, marios);
        animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

    }

    public static void dispose() {
        backGround.dispose();
        mario1.dispose();
        mario2.dispose();
        mario3.dispose();
    }

}
