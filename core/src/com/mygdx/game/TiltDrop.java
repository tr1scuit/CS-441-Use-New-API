package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TiltDrop extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	Texture phys1;
	PhysObject box;
	MotionHandler motion;
	float amY; // accelerometer y
	float amX; // accelerometer x



	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		phys1 = new Texture("box.png");
		box = new PhysObject(phys1, 200, 200, 0, 0);
		amY = Gdx.input.getAccelerometerY();
		amX = Gdx.input.getAccelerometerX();
	}


	// render loop
	@Override
	public void render () {
		physicsTick();

		Gdx.gl.glClearColor(155, 155, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.draw(box.getTex(), box.getX(), box.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		phys1.dispose();
		//img.dispose();
	}


	// update physics objects and positions
	public void physicsTick(){
		amY = Gdx.input.getAccelerometerY();
		amX = Gdx.input.getAccelerometerX();
		MotionHandler.getInstance().updateMotion((amY), amX*(-1));
		box.setXVel((int)(box.getXVel() + MotionHandler.getInstance().getXAccel()));
		box.setYVel((int)(box.getYVel() + MotionHandler.getInstance().getYAccel()));
		box.setX((int)(box.getX()+box.getXVel()));
		box.setY((int)(box.getY()+box.getYVel()));

		// boundaries
		if(box.getX() > 1835){
			box.setX(1835);
			box.setXVel(0);
		}
		if(box.getY() > 835){
			box.setY(835);
			box.setYVel(0);
		}
		if(box.getX() < 0){
			box.setX(0);
			box.setXVel(0);
		}
		if(box.getY() < 0){
			box.setY(0);
			box.setYVel(0);
		}
	}
}
