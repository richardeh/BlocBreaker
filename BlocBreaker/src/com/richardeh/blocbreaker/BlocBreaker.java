package com.richardeh.blocbreaker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.richardeh.blocbreaker.Game.Assets;
import com.richardeh.blocbreaker.Screens.MainMenuScreen;

public class BlocBreaker  extends Game implements ApplicationListener {
	
	public static Game game;
	@Override
	public void create() {
		game = this;
		game.setScreen(new MainMenuScreen());
	}

	@Override
	public void dispose() {
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
	
	public static Game getGame(){
		return game;
	}
}
