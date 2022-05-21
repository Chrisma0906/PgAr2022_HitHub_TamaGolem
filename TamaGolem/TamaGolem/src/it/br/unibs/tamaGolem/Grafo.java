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
	
	public static final int MAX_DAMAGE= 7;
	public static final double N=7;
	public static final double P=Math.ceil((N+1)/3)+1;
	public static final double G=Math.ceil(((N-1)*(N-2))/(2*P));
	public static final double S=Math.ceil((2*G*P)/N)*N;
	public static final double SS=Math.ceil((2*G*P)/N);
	public static final double V=10;

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
		for(int i=0; i<7; i++) {
			damageDone[i]=0;
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
		int i,j,k,nRan,damageToDo;
		initializeMats();
		for(i=0; i<7; i++) {
			damageToDo=10;
			for(j=0; j<7 && damageToDo>0; j++) {
				nRan=(int)(Math.random()*((10-1)+1))+1;
				if(matAdi[j][i]==0 && damageToDo>0 && j!=i) {
					while(damageDone[i]+nRan>10 || damageTaken[j]+nRan>10 || damageToDo-nRan<0) {
						nRan--;
					}
					matAdi[i][j]=nRan;
					damageToDo-=nRan;
					damageDone[i]+=nRan;
					damageTaken[j]+=nRan;
				}
			}
			if(damageDone[i]<10) {
				for(k=0; k<7; k++) {	
					while(damageTaken[k]<10 && damageDone[i]<10 && damageToDo>0 && matAdi[i][k]!=0) {
						matAdi[i][k]+=1;
						damageTaken[k]++;
						damageDone[k]++;
						damageToDo--;
					}
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
