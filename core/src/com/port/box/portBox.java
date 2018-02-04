package com.port.box;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.port.box.demos.*;

public class portBox extends ApplicationAdapter {

	private World world;
	private Box2DDebugRenderer bdr;
	private OrthographicCamera camera;

	private Demo_03 demo;

	@Override
	public void create () {

		demo =  new Demo_03();

		world = new World(demo.gravity, true);
		bdr = new Box2DDebugRenderer();

		demo.init(world);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, demo.widthScr, demo.heightScr);
		camera.combined.scl(demo.scale);

	}

	@Override
	public void render () {

		demo.inputListener();
		updateWorld(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		bdr.render(world, camera.combined);

	}

	private void updateWorld(float deltaTime) {

		world.step(1 / demo.scale, 6, 2);//
//		world.step(1 / demo.scale, demo.iterations, demo.iterations);

	}



	@Override
	public void dispose () {

		bdr.dispose();
		world.dispose();

	}
}
