package com.richardeh.blocbreaker.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Richard Harrington on 10/4/2014.
 * Assets created by @KennyNL
 */
public class Assets {

    public Sprite ball;
    public Sprite paddle;
    public Sprite redBlock, greenBlock, blueBlock, greyBlock, purpleBlock, yellowBlock;
    public Sound blockBreak;
    public Sound bounce;
    
    public void load(){
    	redBlock = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_red_rectangle.png"))));
    	greenBlock = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_green_rectangle.png"))));
    	blueBlock =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_blue_rectangle.png"))));
    	greyBlock =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_grey_rectangle.png"))));
    	purpleBlock =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_purple_rectangle.png"))));
    	yellowBlock =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("element_yellow_rectangle.png"))));
    	ball =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("ballGrey.png"))));
    	paddle =  new Sprite(new TextureRegion(new Texture(Gdx.files.internal("paddleBlu.png"))));
    }
}
