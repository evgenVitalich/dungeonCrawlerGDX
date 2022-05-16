package com.dich.dc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Player {

    //16.05.22 сгорел и переписал коллизию без использования библиотек движка,
    //вруную создав объект "прямоугольник" (Из родного java-класса Rectangle)
    //в качестве хитбокса.
    //В краткосрочной перспективе стало работать, но по факту - говнокод (вероятнее всего).


    private final Vector2 player_pos = new Vector2();

    private final Vector2 hitbox_pos = new Vector2(); //В данный момент бесполезный вектор


    private final Texture texture;

    public Rectangle hitBox = new Rectangle(); //рожаем хитбокс







    private int HP;

    private int MoveSpd = 1;



    public Player(float x, float y) {



        this.texture = new Texture("pers3.png");

        //----------------------
        int newX = (int) x;
        //Супер осуждаю приведение типов, но столкнулся с траблом, что
        //методы класса Rectangle хавают только int. Пришлось юзать приведение типов.
        int newY = (int) y;
        //----------------------


        player_pos.set(x, y);
        hitbox_pos.set(x, y); //В данный момент бесполезный вектор

        hitBox.setBounds(newX,newY,40,40); //размеры взяты исходя из размера текстуры


    }

    public void render(Batch batch){

        batch.draw(texture, player_pos.x, player_pos.y);



    }
    public void dispose(){

        texture.dispose();


    }

    public void move(Vector2 dir){

        player_pos.add(dir.scl(MoveSpd));
        hitBox.x += (dir.x * MoveSpd);
        hitBox.y += (dir.y * MoveSpd);


    }
    public  Rectangle getHitBox(){

        return hitBox;

    }

    public Vector2 getPlayer_pos() {
        return player_pos;
    }


    public void getHitBoxCenter(){

        //Метод для отладки, выводит в консоль положение центра хитбокса

        System.out.print(hitBox.getCenterX() + "   ");
        System.out.println(hitBox.getCenterY());

    }

    public void setMoveSpd(int moveSpd) {

        MoveSpd = moveSpd;

    }
}
