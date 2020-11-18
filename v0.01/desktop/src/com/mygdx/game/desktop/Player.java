package com.mygdx.game.desktop;
//gives us the ability to create sprites
import com.badlogic.gdx.graphics.Texture;
//gives us the ability to parse files
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

public class Player {
	private Texture sprite;
	private String Id;
	private String name;
	private int health;
	private String[] actions=new String [4];
	private Action hand;
	private int attackStat;
	private int defenceStat;
	private String equipment;
	
	//takes the name of the character as a parameter and parses the relevant character file to get information
	public Player(String name,String id) throws IOException {
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
			for(int count = 0;count<=3;count++) {this.actions[count]=data.split(",")[4+count];}
			this.equipment=data.split(",")[8];
			this.sprite=new Texture(data.split(",")[9]);
			sc.close();
			//if possible, I would like to close the file, but i dont think you need to do that
		}
	}
	
	public String getId() {return this.Id;}
	public Texture getSprite() {return this.sprite;}
	public String getName() {return this.name;}
	public int getHealth() {return this.health;}
	public void updateHealth(int incrament) {this.health+=incrament;}
	public String[] getActions() {return this.actions;}
	//returns a random attack
	public String getRandomAction() {
		Random random=new Random();
		return this.actions[random.nextInt(4-1)+1];
	}
	//| The two methods below check if the character has the specified attack and returns the data of that attack
	//v We do not need this feature right now, but i have a feeling that we are going to need it in the future
	//
	//private boolean hasAttack(String name) {
	//	boolean flag=false;
	//	for (String attack: this.attacks) {if (attack==name) {flag= true;}}
	//	return flag;
	//	}
	//This is supposed to check if the character has the specified attack, and return the attack data (which is gained from the attack class)
	//public int getAttack(String name) {
		//if (hasAttack(name)) {return name.getAttackValue()}
	//}
}
