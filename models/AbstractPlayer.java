package models;

public abstract class AbstractPlayer {
	
	protected Mano mano;
	protected Mesa mesa;
	protected String nombre;
	protected int puntos;
	
	

	public AbstractPlayer(Mesa mesa, String nombre, int puntos) {
		super();
		this.mano = new Mano();
		this.mesa = mesa;
		this.nombre = nombre;
		this.puntos = 0;
	}

	abstract void jugarTurno();



	
}
