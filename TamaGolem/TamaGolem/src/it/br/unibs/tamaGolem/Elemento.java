package it.br.unibs.tamaGolem;


/*
 * gli elementi possibili sono
 * 0 -> ZanoMind
 * 1 -> IlMasseo
 * 2 -> Marzone
 * 3 -> Blurr
 * 4 -> GiampyTek
 * 5 -> MeControTe
 * 6 -> GaBBoDSQ
 */
public class Elemento {
	
	private String nameElement;
	
	public Elemento(String nameElement) {
		this.nameElement=nameElement;
	}

	public String getNameElement() {
		return nameElement;
	}

	public void setNameElement(String nameElement) {
		this.nameElement = nameElement;
	} 
}
