package com.dich.dc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture startLocation;
	private Personaj me;
	private KeyboardAdapter inputProcessor = new KeyboardAdapter();

	World world = new World(new Vector2(0, -10), true);

	BodyDef groundBodyDef = new BodyDef();
	private World groundBox;


	@Override
	public void create () {
		groundBodyDef.position.set(new Vector2(0, 10)); // sozdaniye "pola"
		Body groundBody = world.createBody(groundBodyDef);
		PolygonShape groundBox = new PolygonShape();
		groundBody.createFixture(groundBox, 0.0f); // fizicheskaya tesktura pola

		Gdx.input.setInputProcessor(inputProcessor);
		batch = new SpriteBatch();
		startLocation = new Texture("first location.jpg");

		me = new Personaj(80, 50);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();
		//batch.draw(startLocation, 0, 0);
		batch.draw(startLocation,0,0,700,500);
		me.render(batch);

		batch.end();
		world.step(1/60f, 6, 2);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
		startLocation.dispose();
		groundBox.dispose();
	}
}
