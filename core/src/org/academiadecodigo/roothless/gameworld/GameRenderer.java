package org.academiadecodigo.roothless.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

import org.academiadecodigo.roothless.gameobjects.Obstacle;
import org.academiadecodigo.roothless.gameobjects.Player;
import org.academiadecodigo.roothless.gameobjects.Powerup;
import org.academiadecodigo.roothless.gameobjects.Score;
import org.academiadecodigo.roothless.helpers.AssetLoader;
import org.academiadecodigo.roothless.util.Random;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 30/03/17.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private PerspectiveCamera cam;
    private Environment environment;
    private ModelBatch modelBatch;
    private ModelInstance floor1, floor2, floor3, floor4, floor5, floor6, floor7, playerInstance;
    private Texture back;
    private SpriteBatch batcher;
    private boolean firstObj;
    private int counter;
    private List<Obstacle> obstacles;
    private List<Powerup> powerups;
    private Player player;
    private Texture mario1, mario2, mario3;
    private Animation animation,animationgm;
    private float speed;
    private boolean flyModeOn;
    private int highScore = AssetLoader.getHighScore();

    public GameRenderer(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        speed = 5;
        obstacles = new LinkedList<Obstacle>();
        powerups = new LinkedList<Powerup>();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        modelBatch = new ModelBatch();
        batcher = new SpriteBatch();

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0, 4, 7);
        cam.lookAt(0, 0, 0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
        firstObj = false;

        initAssets();

        //camController = new CameraInputController(cam);
        //Gdx.input.setInputProcessor(camController);
    }


    public void render(float runTime) {

        //camController.update();

        if (Score.getScore()==highScore) {
            speed = Random.obstX(50.0f,5.0f);
            flyModeOn = true;
            godMode();
        }

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batcher.begin();
        batcher.draw(new TextureRegion(back), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batcher.end();

        modelBatch.begin(cam);

        checkWallsCollision();

        checkBonusCollision();


        modelBatch.render(floor1, environment);
        modelBatch.render(floor2, environment);
        modelBatch.render(floor3, environment);
        modelBatch.render(floor4, environment);
        modelBatch.render(floor5, environment);
        modelBatch.render(floor6, environment);
        modelBatch.render(floor7, environment);
        modelBatch.render(playerInstance, environment);

        floor1.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor2.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor3.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor4.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor5.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor6.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());
        floor7.transform.translate(0, 0, speed * Gdx.graphics.getDeltaTime());


        if (runTime - counter > 0) {
            int random = (int) (Math.random() * 10);
            counter++;

            if (random == 3) {
                System.out.println("Making One!");
                powerups.add(new Powerup(0, 0, 0, 0, 0, 0, speed));
                gameWorld.getScroll().firstBonus = true;
            } else {
                obstacles.add(new Obstacle(0, 0, 0, 0, 0, 0, speed));
                gameWorld.getScroll().firstObj = true;
            }

            firstObj = true;
        }


        player = gameWorld.getPlayer();

        modelBatch.end();

        batcher.begin();

        batcher.draw((Texture) animation.getKeyFrame(runTime), player.getPosition().x / (Gdx.graphics.getDeltaTime() / 3) + 200, 200, Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f);

        batcher.end();

        batcher.begin();
        // Convert integer into String

        String score;
        String score2 ="";

        if(flyModeOn){
            score = "GOD...";
            score2 = "MODE";

        } else{
            score = Score.getScore() + "";
        }

        AssetLoader.shadow.draw(batcher, "" + score, (Gdx.graphics.getWidth() / 2) - (3 * score.length()) + 200, Gdx.graphics.getHeight() - 50);
        AssetLoader.font.draw(batcher, "" + score, (Gdx.graphics.getWidth() / 2) - (3 * score.length() - 1) + 200, Gdx.graphics.getHeight() - 50);

        AssetLoader.shadow.draw(batcher, "" + score2, (Gdx.graphics.getWidth() / 2) - (3 * score.length()) + 200, Gdx.graphics.getHeight() - 120);
        AssetLoader.font.draw(batcher, "" + score2, (Gdx.graphics.getWidth() / 2) - (3 * score.length() - 1) + 200, Gdx.graphics.getHeight() - 120);

        AssetLoader.shadow.draw(batcher, "Hs: " + highScore, (Gdx.graphics.getWidth() / 2) - (3 * score.length()) -300, Gdx.graphics.getHeight() - 50);
        AssetLoader.font.draw(batcher, "Hs: " + highScore, (Gdx.graphics.getWidth() / 2) - (3 * score.length() - 1) - 300, Gdx.graphics.getHeight() - 50);

        batcher.end();


    }

    private void checkBonusCollision() {
        if (gameWorld.getScroll().isFirstBonus()) {

            for (Powerup powerup : powerups) {
                modelBatch.render(powerup.getInstance(), environment);
                //obstacle.getInstance().transform.translate(0,0,speed*Gdx.graphics.getDeltaTime());
                powerup.move(speed * Gdx.graphics.getDeltaTime());
                if (powerup.getPosZ() < 4 && powerup.getPosZ() > -2) {
                    powerup.checkCollision(player);
                }
            }
        }
    }

    private void checkWallsCollision() {
        if (gameWorld.getScroll().isFirstObj()) {

            for (Obstacle obstacle : obstacles) {
                modelBatch.render(obstacle.getInstance(), environment);
                //obstacle.getInstance().transform.translate(0,0,speed*Gdx.graphics.getDeltaTime());
                obstacle.move(speed * Gdx.graphics.getDeltaTime());
                if (obstacle.getPosZ() < 4 && obstacle.getPosZ() > 3) {
                    obstacle.checkCollision(player);
                }
            }
        }
    }

    public void initAssets() {
        floor1 = gameWorld.getScroll().getFloor1().getModelInstance();
        floor2 = gameWorld.getScroll().getFloor2().getModelInstance();
        floor3 = gameWorld.getScroll().getFloor3().getModelInstance();
        floor4 = gameWorld.getScroll().getFloor4().getModelInstance();
        floor5 = gameWorld.getScroll().getFloor5().getModelInstance();
        floor6 = gameWorld.getScroll().getFloor6().getModelInstance();
        floor7 = gameWorld.getScroll().getFloor7().getModelInstance();

        playerInstance = gameWorld.getPlayer().getPlayerInstance();

        back = AssetLoader.backGround;

        floor1.transform.translate(0, 0, 0);
        floor2.transform.translate(0, 0, -7);
        floor3.transform.translate(0, 0, -14);
        floor4.transform.translate(0, 0, -21);
        floor5.transform.translate(0, 0, -28);
        floor6.transform.translate(0, 0, -35);
        floor7.transform.translate(0, 0, -42);

        mario1 = AssetLoader.mario1;
        mario2 = AssetLoader.mario2;
        mario3 = AssetLoader.mario3;

        animation = AssetLoader.animation;

    }

    public void godMode(){

        batcher.begin();
        back = new Texture(Gdx.files.internal("data/backgrounds/back4.jpg"));
        batcher.draw(back, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batcher.end();


        mario1 = AssetLoader.mario4;
        mario2 = AssetLoader.mario5;
        mario3 = AssetLoader.mario6;
        animation= AssetLoader.animationgm;
    }

    public void makeMenu() {

        batcher.begin();

        batcher.draw(new TextureRegion(back), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batcher.end();

    }

}
