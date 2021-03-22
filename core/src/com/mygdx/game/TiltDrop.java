package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TiltDrop extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture phys1;
	PhysObject box;
	MotionHandler motion;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		phys1 = new Texture("box.png");
		box = new PhysObject(phys1, 200, 200);
	}


	// render loop
	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(box.getTex(), box.getX(), box.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}


	// update physics objects and positions
	public void physicsTick(){
		MotionHandler.getInstance().updateMotion();
		//box.setXVel(box.getXVel() + (int)MotionHandler.getInstance().getXAccel());
		//box.setYVel(box.getYVel() + (int)MotionHandler.getInstance().getYAccel());
		box.setX(box.getX()+box.getXVel());
		box.setY(box.getY()+box.getYVel());
	}
}
