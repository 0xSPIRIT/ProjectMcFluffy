package com.thechief.fluff.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
	
	protected OrthographicCamera camera;
	
	public State() {
		camera = new OrthographicCamera();
	}
	
	public abstract void create();
	
	public abstract void update(float dt);
	
	public abstract void render(SpriteBatch sb);
	
}
