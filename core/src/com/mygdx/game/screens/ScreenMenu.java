package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.MovingBackground;
import com.mygdx.game.components.PointCounter;
import com.mygdx.game.components.TextButton;

public class ScreenMenu implements Screen {
    private final MovingBackground background;
    private final TextButton buttonStart;
    private final TextButton buttonExit;

    MyGdxGame myGdxGame;


    public ScreenMenu(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        buttonStart = new TextButton(100, 400, "Start");
        buttonExit = new TextButton(300, 400, "Exit");
        background = new MovingBackground("backgrounds/restart_bg.png");
    }

    @Override
    public void show() {
        
    }

    public void render(float delta) {
//        background.draw(myGdxGame.batch)
        if (is)

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
