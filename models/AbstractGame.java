package models;

import java.util.ArrayList;

public abstract class AbstractGame {
	
/**
 * ATRIBUTOS
 */
	protected boolean finished;
	protected int  modo;
	protected Mesa mesa;
	protected ArrayList <AbstractPlayer> jugadoresM;		
	protected int ronda;
		
	
	
/**
 * CONSTRUCTOR
 */
	
	public AbstractGame(boolean finished, int modo, Mesa mesa, ArrayList<AbstractPlayer> jugadoresM, int ronda) {
		super();
		this.finished = false;
		this.modo = modo;
		this.mesa = mesa;
		this.jugadoresM = jugadoresM;
		this.ronda = ronda;
	}
	
	
/**
 * MÉTODOS
 */
	abstract void bienvenida();
	abstract void menuPrincipal();
	abstract AbstractPlayer nextTurno();
	abstract void start();
	
	void barajar() {
		Baraja baraja = this.mesa.getBaraja();
		baraja.barajar();
	}
	
	void finish() {
		this.finished = true;
	}


}


