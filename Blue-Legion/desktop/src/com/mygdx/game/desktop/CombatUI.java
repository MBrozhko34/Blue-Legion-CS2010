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

public class CombatUI extends ApplicationAdapter implements UI {
	private SpriteBatch batch;
	private BitmapFont font;
	private Player player1;
	// This is going to be a 'dummy' which is going to take the place of
	// player 2 until the network features have been implemented
	private Player player2;
	private String random1;
	private ShapeRenderer shape;
	private Texture logo;
	private String p1;
	private String p2;
	private Background backgroundBuild;
	private Texture background;
	private Effect effect;

	public CombatUI(String player1Char, String player2Char) {
		this.p1 = player1Char;
		this.p2 = player2Char;
		this.backgroundBuild = new Background();
		this.effect = new Effect();
	}

	// takes the two players characters as paramaters and creates the relevant
	// assets
	// @Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		shape = new ShapeRenderer();
		this.background = new Texture(Gdx.files.internal("grave.png")); // .getBackground("grave.png");
		logo = new Texture(Gdx.files.internal("logo.png"));
		player1 = new Player(this.p1);
		// Gets the first random attack text
		this.random1 = player1.getRandomAction();

		player2 = new Player(this.p2);
		// Gets the first random attack text
		this.random1 = player2.getRandomAction();
	}

	// @Override
	public void render() {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// begins drawing things onto the screen
		batch.begin();
		// puts the bakcdrop onto the screen
		batch.draw(this.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// Draws the logo for Blue legion on the screen
		batch.draw(this.logo, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() - 250, 200, 200);
		// putting player 1's details onto the screen:
		// name
		font.draw(batch, player1.getName(), 150, Gdx.graphics.getHeight() - 100);
		// health
		font.draw(batch, "health:" + Integer.parseInt(player1.getHealth()), 150, Gdx.graphics.getHeight() - 150);
		// sprite
		batch.draw(player1.getSprite(), 100, Gdx.graphics.getHeight() / 4 + 100, 200, 200);
		// block card
		// -----------
		// block command
		font.draw(batch, "Block", Gdx.graphics.getWidth() / 16, Gdx.graphics.getHeight() / 4);
		// action 1 card
		// -------
		// action 1 command
		font.draw(batch, player1.getActions()[0], Gdx.graphics.getWidth() / 16 + 110, Gdx.graphics.getHeight() / 4);
		// action 2 card
		// ----------
		// action 2 command
		font.draw(batch, this.random1, Gdx.graphics.getWidth() / 16 + 220, Gdx.graphics.getHeight() / 4);
		// putting player 2's details onto the screen
		// name
		font.draw(batch, "Dummy", Gdx.graphics.getWidth() - 150, Gdx.graphics.getHeight() - 100);
		// health
		font.draw(batch, "Health:" + Integer.parseInt(player1.getHealth()), 150, Gdx.graphics.getHeight() - 150);
		// sprite
		batch.draw(player2.getSprite(), Gdx.graphics.getWidth() - 300, Gdx.graphics.getHeight() / 4 + 100, 200, 200);
		// stops drawing things on the screen
		batch.end();

		/*
		 * //begins drawing shapes onto the screen (high-level OpenGL)
		 * shape.begin(ShapeRenderer.ShapeType.Line); shape.setColor(255,255,255,1);
		 * //box for action 1 shape.rect(Gdx.graphics.getWidth()/16, 150, 100,
		 * Gdx.graphics.getHeight()/4-80); //box for action 2
		 * shape.rect(Gdx.graphics.getWidth()/16+110, 150, 100,
		 * Gdx.graphics.getHeight()/4-80); //box for action 3
		 * shape.rect(Gdx.graphics.getWidth()/16+220, 150, 100,
		 * Gdx.graphics.getHeight()/4-80); shape.end();
		 */

		// checks if the user has clicked the screen
		if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
			// System.out.println("xPos:"+Float.toString(Gdx.input.getX())+"
			// yPos:"+Float.toString(Gdx.input.getY()));
			// checks if the mouse click is inside the first box
			if (Gdx.input.getX() >= 60) {
				if (Gdx.input.getX() <= 160) {
					if (Gdx.input.getY() >= 530) {
						if (Gdx.input.getY() <= 650) {
							System.out.println("block!");
						}
					}
				}
			}
			// checks if the mouse click is in the second box
			// x offset=110
			if (Gdx.input.getX() >= 170) {
				if (Gdx.input.getX() <= 270) {
					if (Gdx.input.getY() >= 530) {
						if (Gdx.input.getY() <= 650) {
							System.out.println(player1.getActions()[0] + "!");
						}
					}
				}
			}
			// checks if the mouse is in the third box
			// x offset=220
			if (Gdx.input.getX() >= 280) {
				if (Gdx.input.getX() <= 380) {
					if (Gdx.input.getY() >= 530) {
						if (Gdx.input.getY() <= 650) {
							System.out.println(this.random1 + "!");
							this.random1 = player1.getRandomAction();
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
