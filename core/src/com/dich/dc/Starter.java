package com.dich.dc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture startLocation;
	private Personaj me;

	@Override
	public void create () {
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
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
		startLocation.dispose();
	}
}
