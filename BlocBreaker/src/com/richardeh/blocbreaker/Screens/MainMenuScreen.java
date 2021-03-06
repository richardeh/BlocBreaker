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
public class MainMenuScreen extends GenericScreen {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	public Game game;
	
	public MainMenuScreen(){

		float h = Gdx.graphics.getHeight();
		float w = Gdx.graphics.getWidth();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		game = BlocBreaker.getGame();
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		// TODO: fill in what gets drawn on the main menu screen
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public boolean keyUp(int keycode){
		Gdx.app.debug("MainMenuScreen", "keycode "+keycode);
		game.setScreen(new GameScreen());
		return false;
	}
}
