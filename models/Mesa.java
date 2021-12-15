package models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	
	private Baraja baraja;

	public Mesa(Baraja baraja) {
		this.baraja = baraja;
	}

	public Baraja getBaraja() {
		return baraja;
	}

	//Llama al metodo de la baraja "robar"
	public Carta robarCartaDeBaraja() {
		return this.baraja.robar();
	}
	
	public List <Carta> robarVariasCartas(int n){
		ArrayList <Carta> aux = new ArrayList <Carta>();
		for (int i = 0; i<n; i++){
			aux.add(this.baraja.robar());
		}
		return aux;
	}
	
	public void addCartaABaraja(Carta cartaInsertada) {
		this.baraja.insertaCartaFinal(cartaInsertada);
		
	}
	
}
