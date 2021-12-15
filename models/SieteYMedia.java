package models;

import java.util.ArrayList;
import java.util.Scanner;

public class SieteYMedia extends AbstractGame {
	public Scanner s = new Scanner(System.in);
	
/**
 * CONSTRUCTOR heredado de la clase padre AbstractGame
 * @param finished
 * @param modo
 * @param mesa
 * @param jugadoresM
 * @param ronda
 * @param s
 */
	public SieteYMedia(boolean finished, int modo, Mesa mesa, ArrayList<AbstractPlayer> jugadoresM, int ronda,
			Scanner s) {
		super(finished, modo, mesa, jugadoresM, ronda);
		this.s = s;
	}

	//metodo bienvenida, muestra al user unas breces instrucciones sobre el juego y la tabla de valores de cada carta
	@Override
	public void bienvenida() {
		System.out.println();
		System.out.println("|------------------- BIENVENIDO AL JUEGO DE CARTAS: ------------------|");
		System.out.println("|                              7 y MEDIO                              |");
		
		Baraja Baraja7yMedio = new Baraja ();
		
		//Dibujamos el juego
		System.out.println("|                                                                     | ");
		System.out.println("|-------------------------- INSTRUCCIONES ----------------------------|");
		System.out.println("|               Su objetivo es obtener el valor de '7.5'              |");
		System.out.println("|            mediante la suma de los valores de sus cartas.           |");
		System.out.println("|                                                                     | ");
		System.out.println("|------------------------------ VALORES ------------------------------|");
		System.out.print("|  Carta  ");
		   
	    for (int i = 1; i <= 10; i++) {
	      System.out.printf("|%4d ", i);
	    }
		//Tabla de valores
		System.out.println("|\n|---------|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
		System.out.print("|  Valor  ");
	    
	    for (int i = 1; i <= 10; i++) {
			Carta CartaValorar = new Carta(i);
		    double suValor;
		    suValor = CartaValorar.getValor7ymedia();
		    System.out.print("| " + suValor + " ");
	    }
	    System.out.println("|\n|---------------------------------------------------------------------|");
	    
	}

	//en el menu principal le damos la opcion de comenzar o no el juego a usuario
	@Override
	public void menuPrincipal() {
		
		System.out.println("                                                                        ");
		System.out.println("                        ¿Desea comenzar a jugar?                        ");
		System.out.println("                             1. SI | 2. NO                               ");
		System.out.println("                                                                        ");
		System.out.print("                              Respuesta: ");
		
		int respuesta1 = Integer.parseInt(s.nextLine());
		
		//una vez su respuesta sea SI, le pedira el nombre para añadirlo al arraylist
		if(respuesta1 == 1) {
			System.out.print("                      Nombre del jugador: ");
			String nombreJugador1 = s.nextLine();

			HumanPlayer humanPlayer1 = new HumanPlayer(this.mesa, nombreJugador1, 0);
			this.jugadoresM.add(humanPlayer1);
			
			//metodo de empezar (siguiente)
			start();
		}else{
			//una vez la respuesta sea NO, se despide
			System.out.println("\n                          LA PRÓXIMA VEZ SERÁ...");
			//utilizamos el metodo finish
			this.finish();
		}
	}

	@Override
	AbstractPlayer nextTurno() {

		HumanPlayer jugador1 = (HumanPlayer) this.jugadoresM.get(0);
		
		return jugador1;
	}
	//comienza el juego
	@Override
	public void start() {
		System.out.println("\n|---------------------------------------------------------------------|");
		System.out.println("|                      READY? LETS GO! GOOD LUCK                      | ");
		System.out.println("|                        ******BARAJANDO******                        | "); 
		System.out.println("|---------------------------------------------------------------------|");
		
		//SieteYMedia sieteYMedia = new SieteYMedia(false, 0, mesa, jugadores, 0, s);
		int respuesta2 = 0;
		double puntuacion = 0;	
		
		Baraja baraja7yMedio = this.mesa.getBaraja();
		Mesa mesa7yMedio = this.mesa;
		
		Carta cartaRobada = baraja7yMedio.robar();
		
		double valorCartaRobada = cartaRobada.getValor7ymedia();
		
		HumanPlayer jugadorActual = (HumanPlayer) this.nextTurno();
		
		do {
			cartaRobada = baraja7yMedio.robar();			
			valorCartaRobada = cartaRobada.getValor7ymedia();
			puntuacion += valorCartaRobada;
				 
			if (puntuacion >= 7.51) {
				System.out.println();
				System.out.println("                          CARTA: " + cartaRobada.getNombreCarta());
				System.out.println("                          VALOR: " + cartaRobada.getValor7ymedia());
				System.out.println("                          PUNTUACION: " + puntuacion);
				System.out.println();
				System.out.println("                             WA WA WAAAA....");
				System.out.println("                            Ha perdido ya que");
				System.out.println("                     su puntuación ha superado en " + (puntuacion-7.5));
				System.out.println("                                los 7.5");
				
				
				finish();
			}else{						
			
				System.out.println();
				System.out.println("                          CARTA: " + cartaRobada.getNombreCarta());
				System.out.println("                          VALOR: " + cartaRobada.getValor7ymedia());
				System.out.println("                          PUNTUACION: " + puntuacion);
				
				System.out.println();
				System.out.println("               ¿Desea seguir juagando o prefiere plantarse?               ");
				System.out.println("                         1. Seguir 2. Plantarse                         ");
				System.out.println("                                                                        ");
				System.out.print("                              Respuesta:");
				respuesta2 = Integer.parseInt(s.nextLine());
				
				if(respuesta2 == 2 && puntuacion == 7.5) {
					System.out.println("                      ¡ENHORABUENA! ");			
					System.out.println("            Ha conseguido la máxima puntuación. ");
					System.out.println("                      Premio: 100/100.");
					
					// el jugador humano gana un punto más
					jugadorActual.puntos = jugadorActual.puntos + 1;
					
					this.finish();
				}else if(respuesta2 == 2 && puntuacion < 7.5){
					System.out.println("\n                    Se ha quedado a " + (7.5-puntuacion) + " puntos de 7.5.");				
					
					System.out.println("                           Premio: 99/100.");
	
					this.finish();
				}
				
				
			}
									
			jugadorActual = (HumanPlayer) this.nextTurno();
			
		} while(this.finished == false);	
	}
}
