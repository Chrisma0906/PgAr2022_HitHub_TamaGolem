package it.br.unibs.tamaGolem;

import java.util.ArrayList;
import java.util.Map;

public class TamaGolem {

	private ArrayList<Elemento> energyStones;
	private int stoneUsed;
	private int healt;
	
	public TamaGolem(ArrayList<Elemento> energyStones, int healt) {
		super();
		this.energyStones = energyStones;
		this.stoneUsed = 0;
		this.healt=healt;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}

	public ArrayList<Elemento> getEnergyStones() {
		return energyStones;
	}

	public void setEnergyStones(ArrayList<Elemento> energyStones) {
		this.energyStones = energyStones;
	}

	public int getStoneUsed() {
		return stoneUsed;
	}

	public void setStoneUsed(int stoneUsed) {
		this.stoneUsed = stoneUsed;
	}
	
	public void changeStone() {
		if(stoneUsed==2) stoneUsed=0;
		else stoneUsed++;
	}
	
	public void getDamage(int damage) {
		this.healt-=damage;
	}
	
	public boolean isDead() {
		if(this.healt<=0) return true;
		return false;
	}
	
}
