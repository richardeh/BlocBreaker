package com.richardeh.blocbreaker.framework;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class DynamicGameObject extends GameObject {
    public final Vector2 velocity;
    public final Vector2 acceleration;

    public DynamicGameObject(float x, float y, float w, float h, float vX, float vY, float aX, float aY){
        super(x,y,w,h);
        this.velocity = new Vector2(vX, vY);
        this.acceleration = new Vector2(aX, aY);
    }

    public DynamicGameObject(float x, float y, float w, float h, float vX, float vY){
        this(x,y,w,h,vX,vY,0f,0f);
    }
    public DynamicGameObject(float x, float y, float w, float h){
        this(x,y,w,h,0f,0f,0f,0f);
    }
}
