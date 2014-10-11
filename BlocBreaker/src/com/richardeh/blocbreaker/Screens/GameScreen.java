package com.richardeh.blocbreaker.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardeh.blocbreaker.BlocBreaker;
import com.richardeh.blocbreaker.framework.GenericScreen;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class GameScreen extends GenericScreen {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Game game;
	
	public GameScreen(){
		float h = Gdx.graphics.getHeight();
		float w = Gdx.graphics.getWidth();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		game = BlocBreaker.getGame();

		Gdx.input.setInputProcessor(this);
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		
	}
	
	public boolean keyUp(int keycode){
		game.setScreen(new GameOverScreen());
		return false;
	}
}
