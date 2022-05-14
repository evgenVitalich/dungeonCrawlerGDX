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
	private Ground gnd;
	private KeyboardAdapter inputProcessor = new KeyboardAdapter();



	@Override
	public void create () {

		Gdx.input.setInputProcessor(inputProcessor);
		batch = new SpriteBatch();

		startLocation = new Texture("first location.jpg");

		me = new Personaj(80, 50);
		gnd = new Ground(0,0,700,20);



	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();
		//batch.draw(startLocation, 0, 0);
		boolean is_col = gnd.hitbox.overlaps(me.hitBox);
		if(is_col){
			System.out.println("ПИЗДА!!!!!!!!!!!!!!");
		}
		me.move(inputProcessor.dir());




		batch.draw(startLocation,0,0,700,500);
		gnd.render(batch);
		me.render(batch);

		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
		startLocation.dispose();

	}
}
