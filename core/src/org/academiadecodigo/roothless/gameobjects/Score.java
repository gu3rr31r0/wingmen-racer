package org.academiadecodigo.roothless.gameobjects;

/**
 * Created by codecadet on 31/03/17.
 */
public class Score {
    private static int score=0;

    public static int getScore() {
        return score;
    }

    public static void scoreCounter(int value){
        score += value;
    }

    public static boolean verifyStatus() {
        return (score % 10 == 0);
    }
}
