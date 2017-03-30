package org.academiadecodigo.roothless;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class WingRunner extends ApplicationAdapter {
	private Environment environment;
	private PerspectiveCamera cam;
	private CameraInputController camController;
	public ModelBatch modelBatch;
	public Model model;
	public ModelInstance instance;
	public Model model2;
	public ModelInstance instance2;
	public Model model3;
	public ModelInstance instance3;



	@Override
	public void create () {

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0,3,5);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();

		ModelBuilder modelBuilder = new ModelBuilder();

		model2 = modelBuilder.createBox(6,1,6, new Material(ColorAttribute.createDiffuse(Color.YELLOW)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		model = modelBuilder.createBox(6,1,6, new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

		model3 = modelBuilder.createBox(6,1,6, new Material(ColorAttribute.createDiffuse(Color.BLUE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);




		instance = new ModelInstance(model);
		instance.transform.translate(0,0,0);

		instance2 = new ModelInstance(model2);
		instance2.transform.translate(0,0,-6);

		instance3 = new ModelInstance(model3);
		instance3.transform.translate(0,0,-12);

		camController = new CameraInputController(cam);
		//Gdx.input.setInputProcessor(camController);

	}

	@Override
	public void render () {

		camController.update();

		Gdx.gl.glViewport(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		modelBatch.render(instance, environment);
		modelBatch.render(instance2, environment);
		modelBatch.render(instance3, environment);

		instance.transform.translate(0,0, 3*Gdx.graphics.getDeltaTime());
		instance2.transform.translate(0,0, 3*Gdx.graphics.getDeltaTime());
		instance3.transform.translate(0,0, 3*Gdx.graphics.getDeltaTime());






		modelBatch.end();


	}

	@Override
	public void dispose () {

		modelBatch.dispose();
		model.dispose();

	}
}
