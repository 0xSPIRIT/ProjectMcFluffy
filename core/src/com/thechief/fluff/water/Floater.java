package com.thechief.fluff.water;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Floater {

	private Vector2 pos;
	private Water water;
	private float speed = 0;
	private float tension = 0.25f;
	
	public Floater(float x, Water water) {
		pos = new Vector2(x, water.getHeight(x) - 50);
		pos.x = x;
		this.water = water;
	}
	
	public void update(float dt) {
		float x = water.getHeight(pos.x) - pos.y;
		speed += tension * x - speed;
		pos.y += speed;
	}
	
	public void render(ShapeRenderer sr) {
		sr.begin(ShapeType.Filled);
		
		sr.setColor(new Color(0.5f, 0.75f, 0.25f, 1f));
		sr.circle(pos.x, pos.y, 25);
	
		sr.end();
	}
	
}
