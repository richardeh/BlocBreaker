package com.richardeh.blocbreaker.Screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.richardeh.blocbreaker.BlocBreaker;
import com.richardeh.blocbreaker.Game.Assets;
import com.richardeh.blocbreaker.Game.Block;
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

		ArrayList<Vector2> balls = game.getElementPositions("balls");
		ArrayList<Vector2> paddle = game.getElementPositions("paddle");
		
		game.update();
		
		batch.begin();

		for(Vector2 v:balls){
	        ballSprite.setPosition(v.x,v.y);
	        ballSprite.draw(batch);	
		}
		
		for(Block b:game.getBlocks()){
			Sprite blockSprite = new Sprite();
			switch(b.getColor()){
			case RED:
				blockSprite = Assets.redBlock;
				break;
			case BLUE:
				blockSprite = Assets.blueBlock;
				break;
			case GREEN:
				blockSprite = Assets.greenBlock;
				break;
			case GREY:
				blockSprite = Assets.greyBlock;
				break;
			case PURPLE:
				blockSprite = Assets.purpleBlock;
				break;
			case YELLOW:
				blockSprite = Assets.yellowBlock;
				break;
			};
			blockSprite.setPosition(b.position.x, b.position.y);
			blockSprite.draw(batch);
		}
		
		for(Vector2 v:paddle){
			paddleSprite.setPosition(v.x, v.y);
			paddleSprite.draw(batch);
		}
		
		batch.end();
		
	}
	
	public boolean keyUp(int keycode){
		
		return false;
	}
	
	public boolean keyDown(int keycode){
		// need to figure out how to make this continue while the key is down
		if(keycode == Keys.RIGHT) game.movePaddle(30);
		if(keycode == Keys.LEFT) game.movePaddle(-30);
		return false;
	}
}
