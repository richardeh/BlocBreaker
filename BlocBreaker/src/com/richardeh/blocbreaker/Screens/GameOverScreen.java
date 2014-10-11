package com.richardeh.blocbreaker.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardeh.blocbreaker.BlocBreaker;
import com.richardeh.blocbreaker.framework.GenericScreen;

public class GameOverScreen extends GenericScreen{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Game game;
	
	public GameOverScreen(){
		float h = Gdx.graphics.getHeight();
		float w = Gdx.graphics.getWidth();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		game = BlocBreaker.getGame();

		Gdx.input.setInputProcessor(this);
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		
	}
	
	public boolean keyUp(int keycode){
		game.setScreen(new MainMenuScreen());
		return false;
	}

}
