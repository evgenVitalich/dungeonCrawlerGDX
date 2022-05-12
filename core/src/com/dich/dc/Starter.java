package com.dich.dc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Personaj me;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");

		me = new Personaj(100, 100);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		me.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
	}
}
