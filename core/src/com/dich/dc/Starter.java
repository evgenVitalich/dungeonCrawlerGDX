package com.dich.dc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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
		gnd = new Ground(0,0,700,15);



	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();
		//batch.draw(startLocation, 0, 0);

		me.move(inputProcessor.dir());


		Collision();



		batch.draw(startLocation,0,0,700,500);
		gnd.render(batch);
		me.render(batch);
		/*System.out.print(me.getPlayer_pos());
		System.out.println(me.getHitbox_pos());
		*/

		batch.end();


	}


	public void Collision(){
		//------------------------------------------------------------------
		//Метод призван проверять столкновение между полом и челом (пока что)
		//------------------------------------------------------------------

		me.getHitBoxCenter(); //Для дебага вывод в консоль координат центра хитбокса

		if(gnd.hitbox.intersects(me.getHitBox())){

			System.out.println("IT WORKS!!!!!!!!!!");
		}

	}

	public void IsBorder(Rectangle player_hitbox_pos){

		/*
		-----------------------------------------------------
		По хорошему хочется проверять выезд за границы экрана
		хитбокса игрока, и не допускать этого.
		Принимает на вход хитбокс чела
		-----------------------------------------------------
		 */




	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
		gnd.dispose();
		startLocation.dispose();

	}
}
