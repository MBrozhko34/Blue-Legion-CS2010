package com.mygdx.game.desktop;

import java.util.ArrayList;

public class Effect {
//	// contains=[0]damage,[1]effect,[2]effect val,[3]Duration,[4]player it applies
//	// to
//	private ArrayList<String[]> effectList;
//
//	public Effect() {
//		effectList = new ArrayList<String[]>();
//	}
//
//	/**
//	 * This method iterates through the entire array deducting 1 from the 'duration'
//	 * value. In the event that the value is 0, it is removed from the list.
//	 */
//	private void update() {
//		for (int c = 0; c <= this.effectList.size() - 1; c++) {
//			// if the duration of the effect is 0, it is removed from the effects list, and
//			// the counter moves back one to account for the remove
//			if (this.effectList.get(c)[3] == "0") {
//				this.effectList.remove(c);
//				c = c - 1;
//			}
//			// if the above condition is not fulfilled then the duration of the effect's
//			// duration
//			// is reduced by 1 turn
//			else {
//				this.effectList.get(c)[3] = Float.toString(Float.parseFloat(effectList.get(c)[3]) - 1);
//			}
//		}
//	}
//
//	/**
//	 * retrieves the effects list
//	 * 
//	 * @return ArrayList a 2d array populated by the active effects
//	 */
//	public ArrayList<String[]> getEffectList() {
//		return this.effectList;
//	}
//
//	/**
//	 * this method preforms a union operation between the local arrayList and the
//	 * foreign arraylist
//	 * 
//	 * @param Player Takes the player2 as a parameter as a means of retrieving thier
//	 *               ActionList
//	 */
//	public void merge(Player player2) {
//		for (String[] item : player2.getEffectList().toArray()) {
//			for (String[] compareItem : this.effectList.toArray()) {
//				if (item[1] != compareItem[1]) {
//					this.effectList.add(item);
//				}
//			}
//		}
//	}
//
//	/**
//	 * returns the amount of damage that is to be inflicted onto the opponent
//	 * <p>
//	 * 
//	*/
//	//Takes the name of the action and the players as  
//	//paramaters and applies each effect (effects in the arrayList and the 
//	//effect of the action given (by name) as a paramater)
//	//                   |            |         | 
//	//					\|/ name of  \|/active \|/recieving
//	//					 v the action v player  v player
//	public void Trigger(String action,Player player1,Player player2) {
//		this.update();
//		//total damage inflicted onto the opponent/recieving player
//		actionBuild=player1.getActionBuild();
//		float totalRecieving=this.actionBuild.getAction(action);
//		if (effectsList.size()!=0) {
//			for (String[] action: this.effectList) {
//				//totalRecieving+=Integer.parseInt(action[0]);
//				}
//				//if the effect is a attack buff
//				if(effect=="attack") {
//					//checks if the buff applies to player 1(always the active player) and if so, applies it to player 1
//					if (action[4]=player1.getID) {
//						int attackStatTemp=player1.getAttackStat()+Integer.parseInt(action[2])
//						totalRecieving+=attackStatTemp;
//					}
//					//i think that i got confused, not sure if this should be here yet
//					//else {int attackStatTemp=player2.getAttackStat()+Integer.parseInt(action[2])}
//				}
//				if(effect=="defence") {if (action[4]=player2.getID) {
//					int tempDefenceStat=player2.getDefenceStat()+Integer.parseInt(action[2]);
//					totatRecieving-=tempDefenceStat;
//					}
//				}	
//				}
//			//If the effect is a health leach
//			if (action=="health leach") {
//				player1.setHealth(player2.getHealth()-Integer.parseInt(actionBuild.getAction(action)[2]));
//				totalRecieving+=Integer.parseInt(actionBuild.getAction(action)[2]);
//			player2.setHealth(player2.getHealth()-totalRecieving);
//			}
//		}
}
