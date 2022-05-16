package com.dich.dc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;


public class Ground {

    //16.05.22 сгорел и переписал коллизию без использования библиотек движка,
    //вруную создав объект "прямоугольник" (Из родного java-класса Rectangle)
    //В краткосрочной перспективе стало лучше, но по факту - говнокод (вероятнее всего)


    private float x;
    private float y;
    private float widht;
    private float height;

    public Rectangle hitbox = new Rectangle();

    private Texture test_texture;




    public Ground(float x, float y, float widht, float height) {
        this.x = x;
        this.y = y;
        this.widht = widht;
        this.height = height;

        test_texture = new Texture("zemlya.jpg");

        int newX = (int) x;
        int newY = (int) y;

        hitbox.setBounds(newX,newY,700,15);

    }




    public void render(Batch batch){

        batch.draw(test_texture,0,0,700,15);

    }


    public void dispose(){

        test_texture.dispose();


    }

}
