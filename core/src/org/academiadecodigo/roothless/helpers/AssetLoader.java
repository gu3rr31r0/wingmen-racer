package org.academiadecodigo.roothless.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import org.academiadecodigo.roothless.gameobjects.Floor;
import org.academiadecodigo.roothless.gameobjects.Player;
import org.academiadecodigo.roothless.gameworld.GameRenderer;
import org.academiadecodigo.roothless.util.Random;

import java.io.InputStream;

/**
 * Created by codecadet on 30/03/17.
 */
public class AssetLoader {

    public static void setBackGround(Texture backGround) {
        AssetLoader.backGround = backGround;

    }

    public static Texture backGround;
    public static Texture mario1, mario2,mario3,mario4,mario5,mario6;

    public static Animation animation;
    public static Animation animationgm;
    public static BitmapFont font;
    public static BitmapFont shadow;
    public static Preferences pref;


    public static void load() {

        backGround = new Texture(Gdx.files.internal(Random.loadscreen()));
        mario1 = new Texture(Gdx.files.internal("data/player/mario_pizza_left.png"));
        mario2 = new Texture(Gdx.files.internal("data/player/mario_pizza_still.png"));
        mario3 = new Texture(Gdx.files.internal("data/player/mario_pizza_right.png"));

        mario4 = new Texture(Gdx.files.internal("data/player/mario_gm_left.png"));
        mario5 = new Texture(Gdx.files.internal("data/player/mario_gm_still.png"));
        mario6 = new Texture(Gdx.files.internal("data/player/mario_gm_right.png"));


        Texture[] marios = {mario1, mario2, mario3};
        animation = new Animation(0.06f, marios);
        animation.setPlayMode(Animation.PlayMode.LOOP);

        Texture[] mariosgm = {mario4, mario5, mario6};
        animationgm = new Animation(0.06f, mariosgm);
        animationgm.setPlayMode(Animation.PlayMode.LOOP);

        font = new BitmapFont(Gdx.files.internal("data/score/text.fnt"));
        font.getData().setScale(1f, 1f);

        shadow = new BitmapFont(Gdx.files.internal("data/score/shadow.fnt"));
        shadow.getData().setScale(1f, 1f);

        pref = Gdx.app.getPreferences("MarioPizzaDelivery");

        if(!pref.contains("highScore")){
            pref.putInteger("highScore",0);
        }

    }

    public static void setHighScore(int value){
        pref.putInteger("highScore",value);
        pref.flush();
    }

    public static int getHighScore(){
        return pref.getInteger("highScore");
    }

    public static void dispose() {
        backGround.dispose();
        mario1.dispose();
        mario2.dispose();
        mario3.dispose();
    }
}
