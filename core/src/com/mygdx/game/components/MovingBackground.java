package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.MyGdxGame;

public class MovingBackground {

    static Texture texture;

    static int texture1X;
    static int texture2X;
    int speed = 2;

    public MovingBackground(String s) {
        texture1X = 0;
        texture2X = MyGdxGame.SCR_WIDTH;
        texture = new Texture("backgrounds/game_bg.png");
    }

    public void move() {
        texture1X -= speed;
        texture2X -= speed;

        if (texture1X <= -MyGdxGame.SCR_WIDTH) {
            texture1X = MyGdxGame.SCR_WIDTH;
        }
        if (texture2X <= -MyGdxGame.SCR_WIDTH) {
            texture2X = MyGdxGame.SCR_WIDTH;
        }
    }

    public static void draw(Batch batch) {
        batch.draw(texture, texture1X, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, texture2X, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

}