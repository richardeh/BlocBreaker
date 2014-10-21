package com.richardeh.blocbreaker.Game;

import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
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
        Ball ball = new Ball(0,0,32,32,5,5,0,0);
        Ball ball2 = new Ball(0,0,32,32,10,10,0,0);
        balls = new ArrayList<Ball>();
        balls.add(ball);
        balls.add(ball2);
        
        paddle = new Paddle(0,0,104,24,0,0);
        objects = new ArrayList<DynamicGameObject>();
        objects.add(paddle);
        
        currentLevel = 1;
        blocks= new ArrayList<Block>();
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
    
    public void moveBall(Ball b,Vector2 v){

    		b.position.add(v);

    }

    public ArrayList<Vector2> getBallPosition(){
    	ArrayList<Vector2> positions = new ArrayList<Vector2>();
    	for(Ball b:balls){
    		positions.add(b.position);
    	}
        return positions;
    }

    public Vector2 getPaddlePosition(){
        return paddle.position;
    }
    
    public void movePaddle(int x){
    	if(paddle.position.x+paddle.bounds.width+x>=w||paddle.position.x+x<=0) return;
    	
    	paddle.position.x+=x;
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
    	for(Ball ball: balls){
    		for(DynamicGameObject o:objects){
    			if(ball.intersects(o)){
    				if(!ball.isFlaming){
    					ball.velocity.y = -ball.velocity.y;
    				}
    				
    				if(o.getClass()==Block.class){
    						o.destroy();
    				}
    				
    				if(o.getClass()==Paddle.class){
    				}
    			}
    		}
    	}
    }
    
}
