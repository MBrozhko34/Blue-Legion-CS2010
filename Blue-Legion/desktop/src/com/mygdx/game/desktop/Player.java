package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
//gives us the ability to create sprites
import com.badlogic.gdx.graphics.Texture;
//gives us the ability to parse files
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Player {
	private Texture sprite;
	private String name;
	private String health;
	private String[] actions = new String[4];
	private String action1, action2, action3, action4;

	private Action hand;
	private String attackStat;
	private String defenceStat;
	private String equipment;
	private Action actionBuild;
	private Effect effectBuild;

	// takes the name of the character as a parameter and parses the relevant
	// character file to get information
	public Player(String name) {
		Action actionBuild = new Action();
		File file = new File("data/goblin.csv");

//		if(!file.exists()) {
//			System.out.println("file does not exist");
//		}else {
//			System.out.println("found");
//		}

		// effectBuild = new Effect();
		try (Scanner sc = new Scanner(file)) {

			sc.nextLine(); // skips first row
			while (sc.hasNext()) {

				String line = sc.nextLine(); // main one that reads each line
				String[] data = line.split(",");

				// System.out.println(sc.hasNext());
				this.name = data[0];
				// converting int to string then placed in data array which is a string
				this.health = String.valueOf(data[1]);
				this.attackStat = String.valueOf(data[2]);
				this.defenceStat = String.valueOf(data[3]);

				// continues on
				this.actions[0] = data[4];
				this.actions[1] = data[5];
				this.actions[2] = data[6];
				this.actions[3] = data[7];
				this.equipment = data[8];
				this.sprite = new Texture(Gdx.files.internal(data[9]));

//				for (int count = 0; count <= 3; count++) {
//					this.actions[count] = data.split(",")[4 + count];
//					actionBuild.addAction(this.actions[count]);
//				}

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

//	public ArrayList<String[]> getEffectList() {
//		return this.effectBuild.getEffectList();
//	}

	public Action getActionBuild() {
		return this.actionBuild;
	}

	public Texture getSprite() {
		return this.sprite;
	}

	public String getName() {
		return this.name;
	}

	public String getHealth() {
		return this.health;
	}

	public void setHealth(float incrament) {
		this.health += incrament;
	}

	public String getAttackStat() {
		return this.attackStat;
	}

	public String getDefenceStat() {
		return this.defenceStat;
	}

	public String[] getActions() {
		return this.actions;
	}

	// returns a random attack
	public String getRandomAction() {
		Random random = new Random();
		return this.actions[random.nextInt(4 - 1) + 1];
	}

	// retrieves the data for the specified attack from the hashmap.
	// It has been done in this fashon because it is easier for us (the dev's) to
	// code "around" this
//	public Action getActionData(String name) {
//		return this.actionBuild.getActionData(name);
//	}
}
