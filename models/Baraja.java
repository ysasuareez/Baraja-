package models;

import java.util.ArrayList;

public class Baraja {

	//PROPIEDADES
	protected ArrayList<Carta> lista_cartas; 
	
	
	//CONSTRUCTORES
	public Baraja() {	
		lista_cartas = new ArrayList <Carta>(); 
	}
	
	public Baraja(int tipoBaraja) {	
		this();			
		
		if (tipoBaraja == 1 || tipoBaraja == 2) {
			
			for (int i = 1; i <= tipoBaraja * 40; i++ ) {
				
				//creamos la Carta con el constructor del id, hasta el valor 40
				if (i <= 40) {
					this.lista_cartas.add(new Carta(i)); 
				}else {					
					//no exite mas id a partir del 40, por lo que si el tipo de baraja es doble, comenzaran a introducirse los mismos valores nuevamente.
					this.lista_cartas.add(new Carta(i - 40)); 
				}
			}
			
		}else{
			System.out.println("No existe este tipo de baraja.");
		}
	}

	public Baraja(int tipoBaraja, boolean barajar) {	
		this(tipoBaraja);
		
		if (barajar == true) {
			barajar();
		}
		
	}
		
		
	//MÉTODOS
	
	public void barajar() {
		ArrayList<Carta> listaCartasBarajadas = new ArrayList<Carta>();
		
		do {
			int posicion = (int)(Math.random()*this.lista_cartas.size());
			listaCartasBarajadas.add(this.lista_cartas.get(posicion));
			this.lista_cartas.remove(posicion);
		} while (this.lista_cartas.isEmpty() == false);
		
		this.lista_cartas = (ArrayList<Carta>) listaCartasBarajadas.clone();
	}
		
	
	public void cortar(int posicion) {
		// Creamos un array auxiliar donde guardaremos los numeros que se descartan al cortar *
		ArrayList<Carta> aux = new ArrayList<Carta>();
		for (int i = 0; i < posicion; i++) {
			// siempre 0 ya que al eliminarla al mismo tiempo que se añade, las posiciones retroceden siempre
			// una posición para añadirlos al final, ahora si necesitamos que aunmente el valor con i.
			aux.add(this.lista_cartas.get(0));
			this.lista_cartas.remove(0);
			this.lista_cartas.add(aux.get(i));
		}
		
	}
	

	public Carta robar() {
		Carta cartaRobada = this.lista_cartas.remove(0);
		return cartaRobada;
	}

	public void insertaCartaFinal(int id_carta) {
		int aux = id_carta;
		this.lista_cartas.add(new Carta(aux));
	}

	public void insertaCartaPrincipio(int id_carta) {
		int aux = id_carta;
		this.lista_cartas.add(0, new Carta(aux));
	}

	
	public void insertaCartaFinal(Carta cartaInsertada) {
		this.lista_cartas.add(cartaInsertada);
	}

	public void insertaCartaPrincipio(Carta cartaInsertada) {
		this.lista_cartas.add(0, cartaInsertada);
	}

	public int getNumeroCartas() {
		int numeroCartas = this.lista_cartas.size();
		return numeroCartas;
	}

	public boolean isVacia() {		
		if(this.lista_cartas.isEmpty() == false) {
			return false;
		}else{
			return true;
		}
	}

}

