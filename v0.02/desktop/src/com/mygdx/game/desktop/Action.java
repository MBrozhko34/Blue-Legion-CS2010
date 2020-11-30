package com.mygdx.game.desktop;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
 
public class Action {
	private HashMap<String,String[]> actionMap;
	public Action() {actionMap=new HashMap<String,String[]>();}
	
	//Takes the name of the action as a paramater and  searches for the 
	//file which contains the actions data and adds it to the hashmap 
	//as a string array, with the key being the name of the attack
	public void addAction(String name) throws IOException {
		//creates a scanner to read the specified file
		try (Scanner reader=new Scanner(new File("bin\\main\\actionData\\"+name+".txt"))){
		reader.nectLine();
		String[] data=new String[](3);
		//adds the data found in that file to the data array                   debugging
		for (int count=0;count<=3;count++) {data[count]=reader.nextLine(); System.out.Println(data[count]);}
		//places the data found in the array into the actionsMap
		actionMap.add(name,data);
		//debugging
		System.out.println("Added attack to the hashmap! \n");}
		}
	public String[] getAction(name) {return actionMap.get(name);}
	}
