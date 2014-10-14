package com.richardeh.blocbreaker.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardeh.blocbreaker.BlocBreaker;
import com.richardeh.blocbreaker.Game.Assets;
import com.richardeh.blocbreaker.Game.Game;
import com.richardeh.blocbreaker.framework.GenericScreen;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class GameScreen extends GenericScreen {

	private SpriteBatch batch;
	private Game game;
    private Sprite ballSprite, paddleSprite;
	
	public GameScreen(){
		float h = Gdx.graphics.getHeight();
		float w = Gdx.graphics.getWidth();
		
		batch = new SpriteBatch();
		game = BlocBreaker.getGame();
		Assets.load();
        ballSprite = Assets.ball;
        paddleSprite = Assets.paddle;
		Gdx.input.setInputProcessor(this);
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ballSprite.setPosition(game.getBallPosition().x,game.getBallPosition().y);
        paddleSprite.setPosition(game.getPaddlePosition().x,game.getPaddlePosition().y);
		batch.begin();
        ballSprite.draw(batch);
        paddleSprite.draw(batch);
		batch.end();
	}
	
	public boolean keyUp(int keycode){
		
		return false;
	}
}
