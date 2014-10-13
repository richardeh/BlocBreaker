package com.richardeh.blocbreaker.Game;

import com.badlogic.gdx.math.Vector2;
import com.richardeh.blocbreaker.framework.DynamicGameObject;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class Ball extends DynamicGameObject {
    public boolean isFlaming;
    public Ball(float x, float y, float w, float h, float vX, float vY, float aX, float aY) {
        super(x, y, w, h, vX, vY, aX, aY);
        isFlaming = false;
    }

    public Ball(Vector2 position, Vector2 dimensions, Vector2 velocity, Vector2 accel){
        this(position.x, position.y, dimensions.x, dimensions.y, velocity.x, velocity.y, accel.x, accel.y);
    }

    public Ball copy(){
        return new Ball(this.position, this.dimensions, this.velocity, this.acceleration );
    }
}
