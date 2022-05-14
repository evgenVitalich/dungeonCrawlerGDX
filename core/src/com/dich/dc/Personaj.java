package com.dich.dc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Personaj {

    private final Vector2 player_pos = new Vector2();
    private final Vector2 hitbox_pos = new Vector2();

    private final Texture texture;

    public Rectangle hitBox = new Rectangle();





    private int HP;

    private int MoveSpd = 6;



    public Personaj(float x, float y) {



        this.texture = new Texture("pers3.png");
        hitBox.set(x, y, 40, 40);

        player_pos.set(x, y);
        hitbox_pos.set(x,y);

    }

    public void render(Batch batch){
        batch.draw(texture, player_pos.x, player_pos.y);




    }
    public void dispose(){

        texture.dispose();

    }

    public void move(Vector2 dir){

        player_pos.add(dir);
        hitbox_pos.add(dir);



    }
    public  Rectangle getHitBox(){

        return hitBox;

    }

    public Vector2 getPlayer_pos() {
        return player_pos;
    }

    public Vector2 getHitbox_pos() {
        return hitbox_pos;
    }
    public float getHitboxYPos(){

        return hitbox_pos.y;

    }
}
