package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.ScreenGame;
import com.mygdx.game.screens.ScreenMenu;
import com.mygdx.game.screens.ScreenRestart;

public class MyGdxGame extends Game {
    public ScreenMenu screenMenu;

    public SpriteBatch batch;
    public OrthographicCamera camera;

    public static final int SCR_WIDTH = 1280, SCR_HEIGHT = 720;
    public ScreenRestart screenRestart;
    public ScreenGame screenGame;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

        screenMenu = new ScreenMenu(this);
        screenGame = new ScreenGame(this);
        screenRestart = new ScreenRestart(this);
        setScreen(screenMenu);
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}