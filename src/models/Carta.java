package models;

import utils.CartaUtils;

public class Carta {

	private int id, numero;
	private Palo palo;

	public Carta(int numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}

	public Carta(int id) {
		// if (id > 40) throw new Exception("Id " + id + " no válida."); (nunca se va a
		// dar el caso)
		this(CartaUtils.getNumeroCartaById(id), Palo.getPaloByIndice(CartaUtils.getIndicePaloById(id)));
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}

	public String getNombreNumero() {
		return CartaUtils.NOMBRE_CARTAS[numero - 1];
	}

	public String getNombrePalo() {
		return palo.name().toLowerCase();
	}

	public String getNombreCarta() {
		return getNombreNumero() + " de " + getNombrePalo() + "s";
	}

	public int getValorTute() {
		switch (numero) {
		case 1:
			return 11;
		case 3:
			return 10;
		case 7:
			return 2;
		case 8:
			return 3;
		case 9:
			return 4;
		default:
			return numero;
		}
	}

	public int getValorMus() {
		switch (numero) {
		case 1:
		case 2:
			return 1;
		case 3:
		case 7:
		case 8:
		case 9:
			return 10;
		default:
			return numero;
		}
	}
	
	public double getValor7ymedia() {
		switch (numero) {
		case 8:
		case 9:
		case 10:
			return 0.5;
		default:
			return numero;
		}
	}
}
