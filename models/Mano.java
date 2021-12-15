package models;
import java.util.Scanner;
/**
 * 
 * Esta clase representa una mano de una baraja
 * @author ysuar
 *
 */
public class Mano extends Baraja {
	
	/**
	 * CONSTRUCTORES:
	 */
	
	public Mano() {
		super();
	}

	public Mano(int tipoBaraja, boolean barajar) {
		super(tipoBaraja, barajar);
	}

	public Mano(int tipoBaraja) {
		super(tipoBaraja);
	}
	
	/**
	 * MÉTODOS
	 */
	
	//Lista todas las cartas de tu mano
	public void listarCartas() {
		for(Carta cartaListada : this.lista_cartas )
			System.out.println(cartaListada);
	}
	
	//Lista todas las cartas de tu mano, te deja elegir una y te la muestra
		
	Carta elegirCarta() {
		Scanner s = new Scanner(System.in);
		//Lista cartas
		for(Carta cartaListada : this.lista_cartas) {
			System.out.println(cartaListada);
		}
		System.out.println("¿Qué carta desea escoger?");
		System.out.print("Numero: ");
		int NumeroElegido = Integer.parseInt(s.nextLine());
		System.out.print("Palo: ");
		int PaloElegido = Integer.parseInt(s.nextLine());
		
		Carta CartaElegida = new Carta(NumeroElegido, PaloElegido);
		System.out.println(CartaElegida);
		return null;
		
		
	}

}
