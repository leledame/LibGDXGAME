package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Bird;
import com.mygdx.game.characters.Tube;
import com.mygdx.game.components.MovingBackground;
import com.mygdx.game.components.PointCounter;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;

    Bird bird;

    PointCounter pointCounter;

    int tubeCount = 3;
    Tube[] tubes;

    int gamePoints = 0;
    boolean isGameOver = false;

    final int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;

    MovingBackground background;


    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        pointCounter = new PointCounter(
                MyGdxGame.SCR_WIDTH - pointCounterMarginRight,
                MyGdxGame.SCR_HEIGHT - pointCounterMarginTop
        );

        restartGame();
        background = new MovingBackground("backgrounds/restart_bg.png");
    }

    public void restartGame() {
        initTubes();
        bird = new Bird(0, MyGdxGame.SCR_HEIGHT / 2, 4, 250, 200);
        isGameOver = false;
        gamePoints = 0;
    }


    @Override
    public void show() {
        isGameOver = false;
        gamePoints = 0;
    }

    @Override
    public void render(float delta) {
        if (isGameOver) {


            myGdxGame.setScreen(myGdxGame.screenRestart);
        }

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        background.move();
        bird.fly();

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }

        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("hit");
                isGameOver = true;
            } else if (tube.needAddPoint(bird)) {
                gamePoints += 1;
                tube.setPointReceived();
                System.out.println(gamePoints);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);

        myGdxGame.batch.end();
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
        bird.dispose();
        background.dispose();
        for (int i = 0; i < tubeCount; i++) {
            tubes[i].dispose();

        }
    }

    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }

}