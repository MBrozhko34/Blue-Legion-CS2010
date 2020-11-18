package com.mygdx.game.desktop;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Action {
private HashMap<String,String[]> actions;

public Action() {this.actions=new HashMap<String, String[]>();}

//Takes the actions presented, looks for the details of each attack in the csv file, 
//and if the attack is found, it is added to the hashmap, using the attack name as a key
//if it is already in the hashmap, then nothing is done
public void addCharacterActions(String[] actions) throws FileNotFoundException {
	try(Scanner sc=new Scanner(new File("bin\\main\\actionData.csv"))){
		String data=sc.nextLine();
		for (String action: actions) {
			if(!this.actions.containsKey(action)) {
				while(sc.hasNext()) {
					if (data.split(",")[0]!=action) {data=sc.nextLine();}
				if (data.split(",")[0]==action) {this.actions.put(action,data.split(","));}
			
					}
				}
		}
	}
}
public String[] getActionData(String name) {return this.actions.get(name);}
//takes the action name and 'triggers' it
public void triggerAction(String name) {
	
}
}
