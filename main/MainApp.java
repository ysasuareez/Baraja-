package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.AbstractPlayer;
import models.Baraja;
import models.Mesa;
import models.SieteYMedia;

public class MainApp {
	public static void main (String[]args) {
		
		Scanner s = new Scanner(System.in);
		
		Baraja baraja7yMedio = new Baraja (1,true);
		Mesa mesa = new Mesa(baraja7yMedio);		
		ArrayList<AbstractPlayer> jugadores = new ArrayList<AbstractPlayer>();
		
		SieteYMedia sieteYMedia = new SieteYMedia(false, 0, mesa, jugadores, 0, s);		
		sieteYMedia.bienvenida();		
		sieteYMedia.menuPrincipal();
		
	}
}