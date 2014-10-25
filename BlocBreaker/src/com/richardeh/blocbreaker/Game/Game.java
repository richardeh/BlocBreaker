package com.richardeh.blocbreaker.Game;

import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.XmlReader;
import com.richardeh.blocbreaker.framework.DynamicGameObject;

/**
 * Created by Richard Harrington on 10/4/2014.
 */
public class Game extends com.badlogic.gdx.Game{
    private Paddle paddle;
    private int currentLevel;
    private float w,h;
    private ArrayList<Block> blocks;
    private static ArrayList<Ball> balls;
    private ArrayList<DynamicGameObject> objects;

    public Game(){
        Ball ball = new Ball(0,32,32,32,5,5,0,0);
        balls = new ArrayList<Ball>();
        balls.add(ball);
        
        objects = new ArrayList<DynamicGameObject>();
        Block block = new Block(0,256,Block.Color.RED, 1, false);
        
        paddle = new Paddle(0,0,104,24,0,0);
        
        objects.add(paddle);
        objects.add(block);
        
        currentLevel = 1;
        blocks= new ArrayList<Block>();
        blocks.add(block);
        		//loadLevel(currentLevel);
    }

    private ArrayList<Block> loadLevel(int level){
        //Load the current level
        // TODO: fill in
        // TODO: determine a file format
        XmlReader reader = new XmlReader();
        try {
			reader.parse(Gdx.files.internal("levels/"+level+".xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return new ArrayList<Block>();
    }
    
    public ArrayList<Block> getBlocks(){
    	return blocks;
    }
    public void moveBall(Ball b,Vector2 v){
    		b.position.add(v);
    		b.bounds.x = b.position.x;
    		b.bounds.y = b.position.y;
    }
    
    public ArrayList<Vector2> getElementPositions(String list){
    	// Returns a list of the positions of all the specified elements
    	ArrayList<Vector2> positions = new ArrayList<Vector2>();
    	if(list.equalsIgnoreCase("blocks")){
    		for(Block b:blocks){
        		positions.add(b.position);
        	}
    	} else if(list.equalsIgnoreCase("balls")){
    		for(Ball b:balls){
        		positions.add(b.position);
        	}
    	} else if(list.equalsIgnoreCase("paddle")){
    		positions.add(paddle.position);
    	}
    	
    	return positions;
    }
    
    public void movePaddle(int x){
    	// moves the paddle as specified
    	if(paddle.position.x+paddle.bounds.width+x>=w||paddle.position.x+x<=0) return;
    	
    	paddle.position.x+=x;
    	paddle.bounds.x = paddle.position.x;
    }

    @Override
    public void create() {

    }
    
    public void update(){
    	// Update the positions of game objects
        w = Gdx.graphics.getWidth();
    	h = Gdx.graphics.getHeight();
    	for(Ball ball:balls){
    		moveBall(ball,ball.velocity);
    	}
    	boundsTestBalls();
    	bounceTest();
    }
    
    private void boundsTestBalls(){
    	// Keep the ball within the boundaries of the game
    	for(Ball ball:balls){
        	if(ball.position.x+ball.bounds.width>=w){
        		ball.velocity.x = -ball.velocity.x;
        	}
        	if(ball.position.y+ball.bounds.height>=h){
        		ball.velocity.y = -ball.velocity.y;
        	}
        	if(ball.position.x<=0){
        		ball.velocity.x = -ball.velocity.x;
        	}
        	if(ball.position.y<=0){
        		ball.velocity.y = -ball.velocity.y;
        	}
		
    	}
    	
    }
    
    private void bounceTest(){
    	// Check the ball(s) for intersection with any object
    	// TODO: tinker so that this works right, instead of trapping the balls under the paddle

    	Rectangle intersection = new Rectangle();
    	
    	for(Ball ball: balls){
    		for(DynamicGameObject o:objects){
    			
    			if(Intersector.intersectRectangles(ball.bounds, o.bounds, intersection)){
    				if(o.getClass() == Paddle.class){
    					// bounce the ball off the paddle
    					ball.velocity.y = -ball.velocity.y;
    					ball.position.y = o.position.y+o.bounds.height+1;
    				} else if(o.getClass() == Block.class){
        				// destroy the block and remove it from the list
    					ball.velocity.y = -ball.velocity.y;
    					ball.position.y = o.position.y - ball.bounds.height;
        			}
    			}
    		}
    	}
    }
    
}
