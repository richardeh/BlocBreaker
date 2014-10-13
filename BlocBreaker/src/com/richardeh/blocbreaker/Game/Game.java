package com.richardeh.blocbreaker.Game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class Game {
    private Ball ball;
    private Paddle paddle;
    private int currentLevel;

    public Game(){
        ball = new Ball(0,0,32,32,0,0,0,0);
        paddle = new Paddle(0,0,64,32,0,0);
        currentLevel = 1;
        loadLevel(currentLevel);
    }

    private void loadLevel(int level){
        //Load the current level
        // TODO: fill in
        // TODO: determine a file format
        Gdx.files.internal("levels/"+level+".xml");
    }
}
