package it.br.unibs.tamaGolem;

public class Grafo2 {

	private static final int MAX_DAMAGE= 7;
	private static final double N=7;
	private static final double P=Math.ceil((N+1)/3)+1;
	private static final double G=Math.ceil(((N-1)*(N-2))/(2*P));
	private static final double S=Math.ceil((2*G*P)/N)*N;
	private static final double SS=Math.ceil((2*G*P)/N);
	private static final double V=10;
	
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
	
	private Legame[][] legami;
	
	public Grafo2() {
		legami= new Legame[7][7];
	}
	
	public void setLegami() {
		int i,j,damageToDo=10;
		for(i=0; i<7; i++) {
			for(j=0; j<7; j++) {
				if(i!=j && legami[j][i].getDamage()==0 && legami[j][i].getDamage()==0) {
					
				}
			}
		}
	}
}
