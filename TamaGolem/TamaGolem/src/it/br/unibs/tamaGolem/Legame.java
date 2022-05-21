package it.br.unibs.tamaGolem;

public class Legame {

	private Elemento strong,weak;
	private int damage;

	public Legame() {
		super();
		this.strong = null;
		this.weak = null;
		this.damage=0;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Elemento getStrong() {
		return strong;
	}

	public Elemento getWeak() {
		return weak;
	}

	public void setStrong(Elemento strong) {
		this.strong = strong;
	}

	public void setWeak(Elemento weak) {
		this.weak = weak;
	}
	
}
