package com.mygdx.game.desktop;

import java.io.IOException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class CombatUI extends ApplicationAdapter implements UI
{
	private SpriteBatch batch;
	private BitmapFont font;
	private Player player1;
	//This is going to be a 'dummy' which is going to take the place of 
	//player 2 until the network features have been implemented
	private Player player2;
	private String random1;
	private ShapeRenderer shape;
	
	//@Override
	public void create() {
		batch=new SpriteBatch();
		font=new BitmapFont();
		shape=new ShapeRenderer();
		//creates the first player
		try {
			//					|
			//fun fact:        \|/ = Kung Lou (MK) - can't use cause copyright
			//				    v
			player1=new Player("lungKou");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Gets the first random attack text
		this.random1=player1.getRandomAction();
		
		//Creates the second player
		try {
			player2=new Player("lungKou");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Gets the first random attack text
		this.random1=player2.getRandomAction();
	}
	
	//@Override
	public void render() {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//begins drawing shapes onto the screen (high-level OpenGL)
		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(255,255,255,1);
		//box for action 1
		shape.rect(Gdx.graphics.getWidth()/16, 150, 100, Gdx.graphics.getHeight()/4-80);
		//box for action 2
		shape.rect(Gdx.graphics.getWidth()/16+110, 150, 100, Gdx.graphics.getHeight()/4-80);
		//box for action 3
		shape.rect(Gdx.graphics.getWidth()/16+220, 150, 100, Gdx.graphics.getHeight()/4-80);
		shape.end();
		//begins drawing things onto the screen
		batch.begin();
		//Draws the words Blue legion onto the screen
		font.draw(batch, "Blue Legion", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()-100);
		//putting player 1's details onto the screen:
		//name
		font.draw(batch, player1.getName(), 150, Gdx.graphics.getHeight()-100);
		//health
		font.draw(batch,"health:"+Integer.toString(player1.getHealth()),150,Gdx.graphics.getHeight()-150);
		//sprite
		batch.draw(player1.getSprite(),100, Gdx.graphics.getHeight()/4+100);
		//block command
		font.draw(batch,"Block",Gdx.graphics.getWidth()/16,Gdx.graphics.getHeight()/4 );
		//action 1 command
		font.draw(batch, player1.getActions()[0],Gdx.graphics.getWidth()/16+110,Gdx.graphics.getHeight()/4);
		//action 2 command
		font.draw(batch, this.random1,Gdx.graphics.getWidth()/16+220,Gdx.graphics.getHeight()/4);
		//putting player 2's details onto the screen
		//name
		font.draw(batch, "Dummy", Gdx.graphics.getWidth()-150, Gdx.graphics.getHeight()-100);
		//health
		font.draw(batch, "Health:"+Integer.toString(player2.getHealth()), Gdx.graphics.getWidth()-150, Gdx.graphics.getHeight()-150);
		//sprite
		batch.draw(player2.getSprite(),Gdx.graphics.getWidth()-300,Gdx.graphics.getHeight()/4+100);
		//stops drawing things on the screen
		batch.end();
		
		//checks if the user has clicked the screen
		if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
			//System.out.println("xPos:"+Float.toString(Gdx.input.getX())+" yPos:"+Float.toString(Gdx.input.getY()));
			//checks if the mouse click is inside the first box
			if (Gdx.input.getX()>=60) {
				if (Gdx.input.getX()<=160) {
					if(Gdx.input.getY()>=530) {
						if(Gdx.input.getY()<=650) {System.out.println("block!");}}}}
			//checks if the mouse click is in the second box
			//x offset=110
			if (Gdx.input.getX()>=170) {
				if(Gdx.input.getX()<=270) {
					if(Gdx.input.getY()>=530) {
						if(Gdx.input.getY()<=650) {System.out.println(player1.getActions()[0]+"!");}
					}
				}
			}
			//checks if the mouse is in the third box
			//x offset=220
			if(Gdx.input.getX()>=280) {
				if(Gdx.input.getX()<=380) {
					if(Gdx.input.getY()>=530) {
						if(Gdx.input.getY()<=650) {
							System.out.println(this.random1+"!");
							this.random1=player1.getRandomAction();
						}
					}
				}
			}
			}
		}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		shape.dispose();
	}
}
