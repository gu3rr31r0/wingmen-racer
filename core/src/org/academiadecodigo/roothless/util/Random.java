package org.academiadecodigo.roothless.util;

import com.badlogic.gdx.graphics.Color;
import sun.nio.cs.ext.MacThai;

/**
 * Created by codecadet on 30/03/17.
 */
public class Random {

    public static Color getRandomColor(){

        int colorNumber = (int)(Math.random()*17);

        switch(colorNumber){

            case 0:
                return Color.BLUE;
            case 1:
                return Color.CORAL;
            case 2:
                return Color.BROWN;
            case 3:
                return Color.CHARTREUSE;
            case 4:
                return Color.CYAN;
            case 5:
                return Color.FIREBRICK;
            case 6:
                return Color.GOLD;
            case 7:
                return Color.GOLDENROD;
            case 8:
                return Color.BLACK;
            case 9:
                return Color.FOREST;
            case 10:
                return Color.LIGHT_GRAY;
            case 11:
                return Color.DARK_GRAY;
            case 12:
                return Color.MAGENTA;
            case 13:
                return Color.MAROON;
            case 14:
                return Color.OLIVE;
            case 15:
                return Color.SALMON;
            case 16:
                return Color.TEAL;
            default:
                return Color.LIME;

        }

    }

    public static float obstX(float max, float min) {

        float r = (float) (Math.random() * (max - min)) + min;
        return r;
    }

    public static String loadscreen() {
        String backpath = "data/backgrounds/";
        Float r = obstX(1.0f, 4.0f);
        return backpath+"back"+r.intValue()+".jpg";


    }
}
