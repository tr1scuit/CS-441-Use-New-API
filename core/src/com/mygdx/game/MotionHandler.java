package com.mygdx.game;


// Singleton Instance to get Gyroscope/Accelerometer data from device


public class MotionHandler{

    private static MotionHandler INSTANCE = null;
    private float y_accl;
    private float x_accl;

    public static MotionHandler getInstance() {
        if(INSTANCE == null){
            INSTANCE = new MotionHandler();
            INSTANCE.y_accl = 0;
            INSTANCE.x_accl = 0;
        }
        return(INSTANCE);
    }

    // helper method to update current motion of phone based on angle
    public void updateMotion(float amX, float amY){
        // 2.0 is our in-app "gravity" value
        // updateMotion updates the acceleration values based on rotation orientation
        x_accl =  (float)(amX/(3.0));
        y_accl =  (float)(amY/(3.0));

    }

    public float getXAccel(){
        return x_accl;
    }
    public float getYAccel(){ return y_accl; }
    public void setXAccel(){
    }
    public void setYAccel(){
    }


}
