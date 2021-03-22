package com.mygdx.game;


// Singleton Instance to get Gyroscope/Accelerometer data from device


public class MotionHandler{

    private static MotionHandler INSTANCE = null;
    private float rotation;
    private float y_accl;
    private float x_accl;

    public static MotionHandler getInstance() {
        if(INSTANCE == null){
            INSTANCE = new MotionHandler();
            INSTANCE.rotation = 0;
            INSTANCE.y_accl = 0;
            INSTANCE.x_accl = 0;
        }
        return(INSTANCE);
    }

    // helper method to update current motion of phone
    public void updateMotion(){


    }

    public float getRotation(){
        return 0;
    }
    public float getXAccel(){
        return 0;
    }
    public float getYAccel(){
        return 0;
    }

    public void setRotation(){
    }
    public void setXAccel(){
    }
    public void setYAccel(){
    }


}
