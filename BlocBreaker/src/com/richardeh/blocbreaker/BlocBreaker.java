package com.richardeh.blocbreaker;

import com.badlogic.gdx.Game;
import com.richardeh.blocbreaker.Screens.MainMenuScreen;

public class BlocBreaker  extends Game{
	
	@Override
	public void create() {		
		setScreen(new MainMenuScreen());
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {	
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
}
