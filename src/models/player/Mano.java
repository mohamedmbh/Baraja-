package models.player;

import mainapp.Main;
import models.Baraja;
import models.Carta;
import utils.JavaUtils;

public class Mano extends Baraja {
	
	public Mano(int tipoBaraja, boolean barajar) {
		super(tipoBaraja, barajar);
	}

	public Mano(int tipoBaraja) {
		super(tipoBaraja, false);
	}
	
	public Mano() {
		super();
	}
	
	public void listarCartas() {
		for (Carta carta : listaCartas) {
			System.out.println(carta);
		}
	}
	
	public Carta elegirCarta() {
		for (int i = 0; i < listaCartas.size(); i++) {
			Carta carta = listaCartas.get(i);
			System.out.println(i + ". " + carta);
		}
		
		int cartaElegida = JavaUtils.getInteger(Main.scanner.nextLine());
		return listaCartas.get(cartaElegida);
	}
	
}
