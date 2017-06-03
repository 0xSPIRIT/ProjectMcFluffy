package com.thechief.fluff.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thechief.fluff.Main;
import com.thechief.fluff.water.Water;

public class GameState extends State {

	private Water water;
	
	@Override
	public void create() {
		camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);
		
		water = new Water();
	}

	@Override
	public void update(float dt) {
		water.update(dt);
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		
		water.render(sb);
		
		sb.end();
	}

}
