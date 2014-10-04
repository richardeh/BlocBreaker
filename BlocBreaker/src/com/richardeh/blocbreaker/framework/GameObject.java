package com.richardeh.blocbreaker.framework;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class GameObject {
    public Vector2 position;
    public Vector2 dimensions;
    public final Rectangle bounds;

    public GameObject(float x, float y, float width, float height){
        this.position = new Vector2(x,y);
        this.dimensions = new Vector2(width, height);
        this.bounds = new Rectangle(x-width/2,y-height/2,width,height);
    }
}
