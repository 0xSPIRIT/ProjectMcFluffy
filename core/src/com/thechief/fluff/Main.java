package com.thechief.fluff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thechief.fluff.states.GameState;
import com.thechief.fluff.states.StateManager;

public class Main extends ApplicationAdapter {
	
	private SpriteBatch sb;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	public static final String TITLE = "McFluffy";
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		StateManager.setCurrentState(new GameState());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		StateManager.update(Gdx.graphics.getDeltaTime());
		StateManager.render(sb);
	}
	
	@Override
	public void dispose () {
		sb.dispose();
	}
}
