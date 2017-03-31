package org.academiadecodigo.roothless.util;

import com.badlogic.gdx.graphics.Color;
import sun.nio.cs.ext.MacThai;

/**
 * Created by codecadet on 30/03/17.
 */
public class Random {

    public static Color getRandomColor(){

        int colorNumber = (int)(Math.random()*7);

        switch(colorNumber){

            case 0:
                System.out.println("Blue");
                return Color.BLUE;
            case 1:
                System.out.println("Coral");
                return Color.CORAL;
            case 2:
                System.out.println("Brown");
                return Color.BROWN;
            case 3:
                System.out.println("Cor de merda");
                return Color.CHARTREUSE;
            case 4:
                System.out.println("Cyean");
                return Color.CYAN;
            case 5:
                System.out.println("Tijoçlo");
                return Color.FIREBRICK;
            case 6:
                System.out.println("Gaja");
                return Color.GOLD;
            default:
                System.out.println("Bcaipinha");
                return Color.LIME;

        }

    }

    public static float obstX(float max, float min) {

        float r = (float) (Math.random() * (max - min)) + min;

        return r;
    }

}
