package com.dich.dc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Personaj {

    private final Vector2 pos = new Vector2();

    private final Texture texture;

    public Rectangle hitBox = new Rectangle();





    private int HP;

    private int MoveSpd = 6;



    public Personaj(float x, float y) {



        this.texture = new Texture("pers3.png");
        hitBox.set(x, y, 40, 40);
        pos.set(x, y);

    }

    public void render(Batch batch){
        batch.draw(texture, pos.x, pos.y);
    }
    public void dispose(){

        texture.dispose();

    }

    public void move(Vector2 dir){

        pos.add(dir);


    }


}
