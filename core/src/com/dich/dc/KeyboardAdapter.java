package com.dich.dc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class KeyboardAdapter extends InputAdapter {
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;

    private final Vector2 mousePos = new Vector2();
    private final Vector2 direction = new Vector2();

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) leftPressed = true;
        if (keycode == Input.Keys.D) rightPressed = true;
        if (keycode == Input.Keys.W) upPressed = true;
        if (keycode == Input.Keys.S) downPressed = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) leftPressed = false;
        if (keycode == Input.Keys.D) rightPressed = false;
        if (keycode == Input.Keys.W) upPressed = false;
        if (keycode == Input.Keys.S) downPressed = false;

        return false;
    }
//Принимает на вход управляемый вектор и T/F по клавишам WASD
    public Vector2 dir(Vector2 dirinp, boolean LP, boolean RP, boolean UP, boolean DP){
        Vector2 diropt = new Vector2(0,0);
        if (LP) {
            diropt.add(-1,0);
            dirinp.set(diropt);
        }

        if (RP){
            diropt.add(1,0);
            dirinp.set(diropt);
        }
        if (UP){
            diropt.add(0,1);
            dirinp.set(diropt);
        }
        if (DP){
            diropt.add(0,-1);
            dirinp.set(diropt);
        }
        if (LP&UP) {
            diropt.add(-1,1);
            diropt.nor();
            dirinp.set(diropt);
        }
        if (RP&UP){
            diropt.add(1,1);
            diropt.nor();
            dirinp.set(diropt);
        }
        if (RP&DP){
            diropt.add(1,-1);
            diropt.nor();
            dirinp.set(diropt);
        }
        if (LP&DP){
            diropt.add(-1,-1);
            diropt.nor();
            dirinp.set(diropt);
        }
        return dirinp;
    }
}
