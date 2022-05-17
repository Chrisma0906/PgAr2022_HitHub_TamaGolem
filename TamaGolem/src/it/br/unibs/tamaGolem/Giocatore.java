package it.br.unibs.tamaGolem;

import java.util.ArrayList;
import java.util.HashMap;

public class Giocatore {
	
	private String playerName;
	private ArrayList<TamaGolem> tamaGolems;
	private ArrayList<Elemento> stones;
	private HashMap<Integer, String> types= new HashMap<Integer, String>();
	private int[] totStones;
	
	public Giocatore(String playerName, ArrayList<Elemento> stones, ArrayList<TamaGolem> tamaGolems) {
		super();
		this.playerName = playerName;
		this.stones = stones;
		this.tamaGolems= tamaGolems;
		totStones= new int[7];
		types.put(0, "ZanoMind");
		types.put(1, "IlMasseo");
		types.put(2, "Marzone");
		types.put(3, "Blurr");
		types.put(4, "GiampyTek");
		types.put(5, "MeControTe");
		types.put(6, "GaBBoDSQ");
	}

	public ArrayList<TamaGolem> getTamaGolems() {
		return tamaGolems;
	}

	public void setTamaGolems(ArrayList<TamaGolem> tamaGolems) {
		this.tamaGolems = tamaGolems;
	}

	public String getplayerName() {
		return playerName;
	}

	public void setplayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getNumstones() {
		return stones.size();
	}

	public ArrayList<Elemento> getstones() {
		return stones;
	}

	public void setstones(ArrayList<Elemento> stones) {
		this.stones = stones;
	}

	public void resetStones() {
		for(int i=0; i<7; i++) {
			totStones[i]=0;
		}
	}
	
	public String remainingStones() {
		resetStones();
		String text="Ti rimangono le seguenti pietre:\n\n";
		for(int i=0; i<stones.size(); i++) {
			for(int j=0; j<types.size(); j++) {
				if(stones.get(i).getNameElement().equals(types.get(j))){
					totStones[j]++;
				}
			}
		}
		for(int i=0; i<7; i++) {
			text+= "Hai "+totStones+"pietre del tipo "+types.get(i);
		}
		return text;
	}
	
	
}
