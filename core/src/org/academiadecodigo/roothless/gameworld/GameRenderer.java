package org.academiadecodigo.roothless.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import org.academiadecodigo.roothless.helpers.AssetLoader;

/**
 * Created by codecadet on 30/03/17.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private PerspectiveCamera cam;
    private Environment environment;
    // private CameraInputController camController;
    private ModelBatch modelBatch;
    private ModelInstance floor1, floor2, floor3, floor4;
    private Texture back;
    private SpriteBatch batcher;

    public GameRenderer(GameWorld gameWorld) {

        this.gameWorld = gameWorld;

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

        initAssets();

        //camController = new CameraInputController(cam);
        //Gdx.input.setInputProcessor(camController);
    }


    public void render (float runTime) {

        //camController.update();

        Gdx.gl.glViewport(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batcher.begin();
        batcher.draw(new TextureRegion(back), 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batcher.end();

        modelBatch.begin(cam);
        modelBatch.render(floor1, environment);
        modelBatch.render(floor2, environment);
        modelBatch.render(floor3, environment);
        modelBatch.render(floor4, environment);

        floor1.transform.translate(0,0, 1*Gdx.graphics.getDeltaTime());
        floor2.transform.translate(0,0, 1*Gdx.graphics.getDeltaTime());
        floor3.transform.translate(0,0, 1*Gdx.graphics.getDeltaTime());
        floor4.transform.translate(0,0,1*Gdx.graphics.getDeltaTime());

        modelBatch.end();



    }

    public void initAssets() {

        floor1 = AssetLoader.floor1Instance;
        floor2 = AssetLoader.floor2Instance;
        floor3 = AssetLoader.floor3Instance;
        floor4 = AssetLoader.floor4Instance;
        back = AssetLoader.backGround;



    }
}
