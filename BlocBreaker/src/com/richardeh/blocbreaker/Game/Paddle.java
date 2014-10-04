package com.richardeh.blocbreaker.Game;

import com.badlogic.gdx.math.Vector2;
import com.richardeh.blocbreaker.framework.DynamicGameObject;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class Paddle extends DynamicGameObject{
    public Paddle(float x, float y, float w, float h, float vX, float vY) {
        super(x, y, w, h, vX, vY);
    }

    public void movePaddle(Vector2 velocity){
        this.position = this.position.add(velocity);
    }


}
