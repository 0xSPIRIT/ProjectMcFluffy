package com.thechief.fluff.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.thechief.fluff.Main;
import com.thechief.fluff.water.Floater;
import com.thechief.fluff.water.Water;

public class GameState extends State {

	private Water water;
	private Floater floater;
	
	private ShapeRenderer sr;
	
	public static final float GRAVITY = 0.3f;
	
	@Override
	public void create() {
		camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);
		
		sr = new ShapeRenderer();
		
		water = new Water();
		floater = new Floater(Main.WIDTH / 2, water);
	}

	@Override
	public void update(float dt) {
		water.update(dt);
		floater.update(dt);
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			StateManager.setCurrentState(new GameState());
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		
		water.render(sr);
		floater.render(sr);
		
		sb.end();
	}

}
