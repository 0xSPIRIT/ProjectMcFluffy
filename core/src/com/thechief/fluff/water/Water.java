package com.thechief.fluff.water;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.thechief.fluff.Main;

public class Water {
	
	public WaterColumn[] springs;

	private float spread = 0.25f;
	private float tension = 0.025f;
	private float dampening = 0.005f;
	
	public Water() {
		springs = new WaterColumn[200];
		for (int i = 0; i < springs.length; i++) {
			springs[i] = new WaterColumn();
		}
	}

	public void update(float dt) {
		for (int i = 0; i < springs.length; i++) {
			springs[i].update(dampening, tension);
		}

		float[] leftNeighbours = new float[springs.length];
		float[] rightNeighbours = new float[springs.length];

		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < springs.length; i++) {
				if (i > 0) {
					leftNeighbours[i] = spread * (springs[i].height - springs[i - 1].height);
					springs[i - 1].speed += leftNeighbours[i];
				}
				if (i < springs.length - 1) {
					rightNeighbours[i] = spread * (springs[i].height - springs[i + 1].height);
					springs[i + 1].speed += rightNeighbours[i];
				}
			}

			for (int i = 0; i < springs.length; i++) {
				if (i > 0) {
					springs[i - 1].height += leftNeighbours[i];
				}
				if (i < springs.length - 1) {
					springs[i + 1].height += rightNeighbours[i];
				}
			}
		}
		
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			splash(Gdx.input.getX() / (Main.WIDTH / springs.length), -150);
		}
	}

	public void splash(int index, float speed) {
		if (index >= 0 && index < springs.length) {
			springs[index].speed = speed;
		}
	}

	public void render(ShapeRenderer sr) {
		sr.begin(ShapeType.Filled);
		sr.setColor(new Color(0.2f, 0.2f, 0.5f, 1f));

		for (int i = 1; i < springs.length; i++)
		{
			// TOP
			Vector2 p1 = new Vector2((i - 1) * Main.WIDTH / (springs.length - 2), springs[i - 1].height);
			Vector2 p2 = new Vector2(i * Main.WIDTH / (springs.length - 2), springs[i].height);
			Vector2 p3 = new Vector2(p1.x, p1.y - 20);
			Vector2 p4 = new Vector2(p2.x, p2.y - 20);

			sr.triangle(p2.x, p2.y, p1.x, p1.y, p3.x, p3.y);
			sr.triangle(p3.x, p3.y, p4.x, p4.y, p2.x, p2.y);
		
			// BOTTOM
			
			p3.set(p1.x, 0);
			p4.set(p2.x, 0);
			
			sr.triangle(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
			sr.triangle(p2.x, p2.y, p4.x, p4.y, p3.x, p3.y);
		}
		
		sr.end();
	}
	
	public float getHeight(float x)
	{
		if (x < 0 || x > Main.WIDTH)
			return 240;

		return springs[(int)(x / (Main.WIDTH / (springs.length - 2)))].height;
	}

}
