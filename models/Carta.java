package models;

/**
 * Esta clase represanta una carta de una baraja
 * @author msuar
 *
 */
public class Carta {

	
	//PROPIEDADES
	/**
	 * Numero entero que representa el número de la carta
	 */
	private int numero;
	/**
	 * Número entero que representa el palo de la carta
	 */
	private int palo;
	
	
	//CONSTRUCTOR , tal y como indican las propiedades	
	/**
	 * Constructor para crear una carta doados su número y su palo
	 * @param numero
	 * @param palo
	 */
	public Carta(int numero, int palo) {	
		super();			
		this.numero = numero;
		this.palo = palo;
	}
	
	//segundo CONSTRUCTOR, como "id" no forma parte de las propiedades, ponemos a las mismas en funcion de él
	//						nos damos cuenta de que las primeras cifras de los id son 0,1,2,3... igual que los palos:
	public Carta(int id) {
		super();
		if (id % 10 == 0) { 		// id = 30;
			this.numero = 10;		// siempre será el nº 10, lo único que cambia es el palo
			this.palo = (id/10) -1; // carta nº 30 -> (30/10)-1 = 2 , en efecto, es 10 de espadas
			
		}else{						// id = 26
			this.numero = id%10;	// 26%10 = 6, el resto seria 6 por lo tanto carta 6
			this.palo = id/10;		// 26/10 = 2, palo espadas
		}
	}
	
	
	//GETTERS
	public int getNumero() {
		return numero;
	}

	public int getPalo() {
		return palo;
	}
	
	
	//MÉTODOS
	public int getId() {
		//declaramos las variables necesarias
		int numeroId;
		int primeraCifraId;
		int segundaCifraId;
		
		if(this.numero == 10) { 				//si nos encontramos con un 10, habra que sumar 10 ya que el primer palo tiene valor 0
			numeroId = (10 * this.palo) + 10;
		}else {
			primeraCifraId = this.palo * 10;	// el palo pasa con un cero en su derecha, si es palo 1 sera 10
			segundaCifraId = this.numero;		// solo tiene que ocupar su posicion en el id
		
			numeroId = primeraCifraId + segundaCifraId;
		}
		
		return numeroId;
	}
		
	
	public String getNombreNumero() {
		
		int numero = this.numero;
		String nombreNumero = "";
		
			//Mediante un switch debemos proponer todos los nombres de cartas posibles *
			switch (numero) {
			case 1: 
				nombreNumero = "As";
				break;
			case 2:
				nombreNumero = "Aos";
				break;
			case 3:
				nombreNumero = "Tres";
				break;
			case 4:
				nombreNumero = "Cuatro";
				break;
			case 5:
				nombreNumero = "Cinco";
				break;
			case 6:
				nombreNumero = "Seis";
				break;
			case 7: 
				nombreNumero = "Siete";
				break;
			case 8:
				nombreNumero = "Sota";
				break;
			case 9:
				nombreNumero = "Caballo";
				break;
			case 10:
				nombreNumero = "Rey";
				break;
			default:
				System.out.println("El número introducido no es válido");
				
			}
			// * y según correspoda a qué opción devolver su nombre correspondiente
			return nombreNumero;			
	}
	
	
	public String getNombrePalo() {
		
		int numero = this.palo;
		String nombrePalo = "";
		
		//Mediante un switch debemos proponer todos los palos posibles *		
		switch (numero) {
			case 0: 
				nombrePalo = "Oros";
				break;
			case 1: 
				nombrePalo = "Copas";
				break;
			case 2:
				nombrePalo = "Espadas";
				break;
			case 3:
				nombrePalo = "Bastos";
				break;
			default:
				System.out.println("El número introducido no es válido");			
		}
		// * y según correspoda a qué opción devolver su nombre correspondiente
		return nombrePalo;	
	}
	
	
	public String getNombreCarta() {
		
		// Si nos damos cuenta, al mezclar los dos metodos anteriores este último se reduce a:
		String NombreCarta = "";
					// conocer su nombre    +      // conocer su palo
		NombreCarta = getNombreNumero() + " de " + getNombrePalo();
		
		// devolver el resultado final. Ej "as de Oros"
		return NombreCarta;
		
	}
	
	public int getValorTute() {
			
			int valorTute = 0; 
			int numero = this.numero;
			
			//Mediante un switch damos a cada carta su valor.
			switch (numero) {
				case 1: 
					valorTute = 11;
					break;
				case 2:
					valorTute = 0;
					break;
				case 3:
					valorTute = 10;
					break;
				case 4:
					valorTute = 0;
					break;
				case 5:
					valorTute = 0;
					break;
				case 6:
					valorTute = 0;
					break;
				case 7: 
					valorTute = 0;
					break;
				case 8:
					valorTute = 2;
					break;
				case 9:
					valorTute = 3;
					break;
				case 10:
					valorTute = 4;
					break;
				default:
					System.out.println("El número introducido no es válido");
					
				}
			// se devuelve su valor correspondiente
			return valorTute;			
	}
	
	public int getValorMus() {
		
		int valorMus = 0; 
		int numero = this.numero;
		
		//Mediante un switch damos a cada carta su valor.
		switch (numero) {
			case 1: 
				valorMus = 1;
				break;
			case 2:
				valorMus = 1;
				break;
			case 3:
				valorMus = 10;
				break;
			case 4:
				valorMus = 4;
				break;
			case 5:
				valorMus = 5;
				break;
			case 6:
				valorMus = 6;
				break;
			case 7: 
				valorMus = 7;
				break;
			case 8:
				valorMus = 10;
				break;
			case 9:
				valorMus = 10;
				break;
			case 10:
				valorMus = 10;
				break;
			default:
				System.out.println("El número introducido no es válido");
				
			}
		// se devuelve su valor correspondiente
		return valorMus;			
	}
	
	
	public double getValor7ymedia() {
		
		double valor7ymedia = 0; 
		int numero = this.numero;
		
		//Mediante un switch damos a cada carta su valor.
		switch (numero) {
			case 1: 
				valor7ymedia = 1;
				break;
			case 2:
				valor7ymedia = 2;
				break;
			case 3:
				valor7ymedia = 3;
				break;
			case 4:
				valor7ymedia = 4;
				break;
			case 5:
				valor7ymedia = 5;
				break;
			case 6:
				valor7ymedia = 6;
				break;
			case 7: 
				valor7ymedia = 7;
				break;
			case 8:
				valor7ymedia = 0.5;
				break;
			case 9:
				valor7ymedia = 0.5;
				break;
			case 10:
				valor7ymedia = 0.5;
				break;
			default:
				System.out.println("El número introducido no es válido");
				
			}
		// se devuelve su valor correspondiente
		return valor7ymedia;			
	}

}
	
	
	
	
	
	
	
	
	
