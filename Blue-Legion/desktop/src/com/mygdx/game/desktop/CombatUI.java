package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CombatUI implements Screen {
 
	private SpriteBatch batch;
	private SpriteBatch healthbar1;
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
	private GameObj game;
	private Stage stage;
	private Card attack;
	private Card healthCard;

	private int health = 100;
	private Texture blank;

	// takes the two players characters as paramaters and creates the relevant
	// assets
	public CombatUI(GameObj game, String player1Char, String player2Char) {
		this.game = game; // needed to display screen
		this.p1 = player1Char;
		this.p2 = player2Char;
		this.backgroundBuild = new Background();
		// this.effect = new Effect();
	 
	}

	// @Override
	public void show() {

		blank = new Texture("blank.png"); // score using color to change health, png allows to change size and white

		batch = new SpriteBatch();
		healthbar1 = new SpriteBatch();

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

		// showing the two card on screen
		attack = new Card("attack_card");
		attack.setPosition(250, 20);
		healthCard = new Card("health_card");
		healthCard.setPosition(550, 20);

		// adding the card to stage
		stage = new Stage(new ScreenViewport()); // Set up a stage for card to be displayed
		stage.addActor(attack.getCard());
		stage.addActor(healthCard.getCard());
		Gdx.input.setInputProcessor(stage); // Start taking input from the ui

		// attack is dealt when attack card it clicked on
		attack.getCard().addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				health -= 5;
				// ((Game) Gdx.app.getApplicationListener()).setScreen(new CombatUI(game));

				System.out.println("attack" + getHealth());

			}
		});

		// gains health
		healthCard.getCard().addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				health += 5;
				// ((Game) Gdx.app.getApplicationListener()).setScreen(new CombatUI(game));

				System.out.println("health" + getHealth());

			}
		});

	}

//	public void healthBar(int x, int y, int width, int height) {
//		healthbar1.draw(blank, x, y, width * health, height); // want to flip it play and see
//		// healthb.draw(blank, x, y, 0, 0, width*health, height, 0, 0, 0, 0, 0, 0, 0,
//		// false, false);
//	}

	public int getHealth() {
		return health;
	}

	// @Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// begins drawing things onto the screen
		batch.begin();
		// puts the bakcdrop onto the screen
		batch.draw(this.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Draws the logo for Blue legion on the screen
		batch.draw(this.logo, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() - 250, 200, 200);
		// putting player 1's details onto the screen:

//player 1
		font.draw(batch, "player 1", 150, Gdx.graphics.getHeight() - 70);

		batch.draw(player1.getSprite(), 100, Gdx.graphics.getHeight() - 600, 200, 200);

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
		font.draw(batch, "Dummy", Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 70);
		// health
		// font.draw(batch, "Health:" + Integer.parseInt(player1.getHealth()), 150,
		// Gdx.graphics.getHeight() - 150);

// player 2
		// sprite
		batch.draw(player2.getSprite(), Gdx.graphics.getWidth() - 300, Gdx.graphics.getHeight() - 600, 200, 200);
		// stops drawing things on the screen

		// created a new batch i.e healthb to stop colours effect the background
		healthbar1.begin();
		// color of the health bar
		if (health > 60) {
			healthbar1.setColor(Color.GREEN);
		} else if (health > 20) {
			healthbar1.setColor(Color.ORANGE);
		} else {
			healthbar1.setColor(Color.RED);
		}

		if (health == 0 || health < 0) {
			
			((Game) Gdx.app.getApplicationListener()).setScreen(new CombatUI(game, p1, p2)); // can be move to another
		 
		}
		// drawing the health bar
		healthbar1.draw(blank, 650, 700, 3 * health, 10);
		healthbar1.end();

		batch.end();

		stage.act(); // must be placed after batch to display cards
		stage.draw();
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
							System.out.println(player1.getActions()[0] + "!"); // gets the stab in action
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
							this.random1 = player1.getRandomAction(); // gets the other three random attacks
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

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
}
