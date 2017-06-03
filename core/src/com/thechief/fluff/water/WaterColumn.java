package com.thechief.fluff.water;

public class WaterColumn {
	
	public float targetHeight = 240;
	public float height = 240;
	public float speed = 0;

	public void update(float dampening, float tension)
	{
		float x = targetHeight - height;
		speed += tension * x - speed * dampening;
		height += speed;
	}
	
}
