package it.br.unibs.tamaGolem;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
	
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
	
	private static final int MAX_DAMAGE= 7;
	private static final double N=7;
	private static final double P=Math.ceil((N+1)/3)+1;
	private static final double G=Math.ceil(((N-1)*(N-2))/(2*P));
	private static final double S=Math.ceil((2*G*P)/N)*N;
	private static final double SS=Math.ceil((2*G*P)/N);
	private static final double V=10;

	private ArrayList<Elemento> elements = new ArrayList<Elemento>();
	private HashMap<Integer, String> types = new HashMap<Integer, String>();
	private int[][] matAdi;
	private int[] damageTaken;
	private int[] damageDone;
	
	public Grafo() {
		super();
		types.put(0, "ZanoMind");
		types.put(1, "IlMasseo");
		types.put(2, "Marzone");
		types.put(3, "Blurr");
		types.put(4, "GiampyTek");
		types.put(5, "MeControTe");
		types.put(6, "GaBBoDSQ");
		for(int i=0; i<7; i++) {
			elements.add(new Elemento(types.get(i)));
		}
		this.matAdi = new int[elements.size()][elements.size()];
		this.damageTaken= new int[7];
		this.damageDone= new int[7];
	}
	
	public void setAdiacenza(Elemento a, Elemento b, int val) {
		int i= elements.indexOf(a);
		int j= elements.indexOf(b);
		matAdi[i][j]=val;
	}
	
	public void initializeMats() {
		for(int i=0; i<7; i++) {
			damageTaken[i]=0;
		}
		for(int j=0; j<7; j++) {
			for(int i=0; i<7; i++) {
				matAdi[j][i]=0;
			}
		}
	}
	
	/*public void initializeElements() {
		int i,j,nRan,damageToSet;
		initializeMats();
		for(i=0; i<7; i++) {
			damageToSet=10;
			for(j=0; j<7 && damageToSet>0; j++) {
				nRan=(int)(Math.random()*((damageToSet-1)+1))+1;
				if(matAdi[j][i]==0 && damageToSet>0 && j!=i) {
					
					while(damageToSet-nRan<0) {
						nRan++;
					}
					while(damageTaken[j]+nRan>10) {
						nRan--;
					}
					matAdi[i][j]=nRan;
					damageToSet-=nRan;
					damageTaken[j]+=nRan;
				}
				if(damageToSet>0 && i==7) {
					matAdi[j][6]=damageToSet;
				}
			}
		}
	}*/

	
	public void initializeElements() {
		int i,j,nRan,damageToDo;
		initializeMats();
		for(i=0; i<7; i++) {
			damageToDo=10;
			for(j=0; j<7 && damageToDo>0; j++) {
				nRan=(int)(Math.random()*((damageToDo-1)+1))+1;
				if(matAdi[j][i]==0 && damageToDo>0 && j!=i) {
					while(damageToDo-nRan<0) {
						nRan--;
					}
					while(damageDone[j]+nRan>10) {
						nRan--;
					}
					matAdi[i][j]=nRan;
					damageToDo-=nRan;
					damageDone[j]+=nRan;
				}
			}
			damageToDo=10;
			for(j=i; j<7; j++) {
				nRan=(int)(Math.random()*((damageToDo-1)+1))+1;
				if(damageToDo==0 && i<6) {
					damageToDo=matAdi[j][i]%2;
					matAdi[j][i]/=2;
				}
				if(damageToDo>0 && i==6 && i!=j) {
					matAdi[j][6]=damageToDo;
				}
				if(matAdi[i][j]==0 && damageToDo>0 && j!=i) {
					while(damageToDo-nRan<0) {
						nRan--;
					}
					while(damageTaken[j]+nRan>10) {
						nRan--;
					}
					matAdi[j][i]=nRan;
					damageToDo-=nRan;
					damageTaken[j]+=nRan;
				}
			}
		}
	}
	
	public ArrayList<Elemento> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Elemento> elements) {
		this.elements = elements;
	}

	public int getValMatAdi(int i, int j) {
		return matAdi[i][j];
	}
	
	public int getDamageFromGrafo(Elemento a, Elemento b) {
		int i,j;
		i=elements.indexOf(a);
		j=elements.indexOf(b);
		return matAdi[i][j];
	}

	public void setMatAdi(int[][] matAdi) {
		this.matAdi = matAdi;
	}

}
