package com.thechief.fluff.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateManager {

	private static State currentState = null;
	
	public static void setCurrentState(State s) {
		currentState = s;
		currentState.create();
	}
	
	public static State getCurrentState() {
		return currentState;
	}
	
	public static void update(float dt) {
		getCurrentState().update(dt);
	}
	
	public static void render(SpriteBatch sb) {
		getCurrentState().render(sb);
	}
	
}
