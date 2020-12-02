package com.mygdx.game.desktop;
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
	private float health;
	private String[] actions=new String [4];
	private Action hand;
	private int attackStat;
	private int defenceStat;
	private String equipment;
	private Action actionBuild;
	private EffectBuild;
	
	//takes the name of the character as a parameter and parses the relevant character file to get information
	public Player(String name) throws IOException {
		Action actionBuild=new Action();
		EffectBuild=new Effect;
		//parses the specified file
		//String file=new File("bin//main//characterData//"+name+".csv").getAbsolutePath();
		try (Scanner sc = new Scanner(new File("bin\\main\\characterData\\"+name+".csv"))){
			sc.nextLine();
			String data = null;
			//System.out.println(sc.hasNext());		 
			if(sc.hasNext()) {data = sc.nextLine();}
			//assigns the variables according to the information found in the file
			this.name=data.split(",")[0];
			this.health=Integer.parseInt(data.split(",")[1]);
			this.attackStat=Integer.parseInt(data.split(",")[2]);
			this.defenceStat=Integer.parseInt(data.split(",")[3]);
			this.actions=new String[4];
			//Adds the actions found in the file to the actions array and the actions HashMap object
			for(int count = 0;count<=3;count++) {this.actions[count]=data.split(",")[4+count];actionBuild.addAction(this.actions[count])}
			this.equipment=data.split(",")[8];
			this.sprite=new Texture(data.split(",")[9]);
			sc.close();
			//if possible, I would like to close the file, but i dont think you need to do that
		}
	}
	public ArrayList<String[]>getEffectList() {return this.effectBuild.getEffectList();}
	public Action getActionBuild() {return this.actionBuild;}
	public Texture getSprite() {return this.sprite;}
	public String getName() {return this.name;}
	public float getHealth() {return this.health;}
	public void setHealth(float incrament) {this.health+=incrament;}
	public int getAttackStat() {return this.attackStat;}
	public int getDefenceStat(){return this.defenceStat;}
	public String[] getActions() {return this.actions;}
	//returns a random attack
	public String getRandomAction() {
		Random random=new Random();
		return this.actions[random.nextInt(4-1)+1];
	}
	//retrieves the data for the specified attack from the hashmap. 
	//It has been done in this fashon because it is easier for us (the dev's) to code "around" this
	getActionData(String name){return this.actionBuild.getActionData(name);}
}
