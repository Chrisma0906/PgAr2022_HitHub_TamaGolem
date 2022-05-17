package it.br.unibs.tamaGolem;

public class Main {

	public static void main(String[] args) {
		
		Grafo g= new Grafo();
		g.initializeElements();
		
		for(int i=0; i<7; i++) {
			System.out.println("");
			for(int j=0; j<7; j++) {
				System.out.print(g.getValMatAdi(i,j)+" ");
			}
		}
	}

}
