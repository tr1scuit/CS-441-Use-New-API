package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


// Physics influenced object

public class PhysObject {

    Texture img;
    int posX, velX;
    int posY, velY;


    public PhysObject(Texture a, int posX, int posY){
        img = a;
        this.posX = posX;
        this.posY = posY;
        this.velX = 0;
        this.velY = 0;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getXVel() {
        return velX;
    }

    public int getYVel() {
        return velY;
    }

    public Texture getTex() {
        return img;
    }

    public void setX(int x){
        posX = x;
    }

    public void setY(int y){
        posY = y;
    }
    public void setXVel(int xv){
        velX = xv;
    }

    public void setYVel(int yv){
        velY = yv;
    }
}
