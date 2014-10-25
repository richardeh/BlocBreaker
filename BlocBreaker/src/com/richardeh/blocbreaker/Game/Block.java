package com.richardeh.blocbreaker.Game;

import com.richardeh.blocbreaker.framework.DynamicGameObject;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class Block extends DynamicGameObject {
	public enum Color{
		RED,
		GREEN,
		BLUE,
		GREY,
		PURPLE,
		YELLOW
	}
	
	private Color color;
	private int durability;
	private boolean breakable;
	
    public Block(float x, float y, Color color, int durability, boolean breakable) {
        super(x, y, 64, 32);
        this.color = color;
        this.durability = durability;
    }
    
    @Override
    public void destroy(){
    	
    }
    
    public Color getColor(){
    	return color;
    }
    
    public boolean isBreakable(){
    	return breakable;
    }
    
    public int durability(){
    	return durability;
    }
}
