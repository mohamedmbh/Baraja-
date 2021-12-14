package models.player;

import mainapp.Main;
import models.Baraja;
import models.Carta;
import models.Mesa;
import utils.JavaUtils;
import utils.TextUtils;

public abstract class AbstractPlayer {

	protected String nombre;
	protected int puntos;
	protected Mano mano;
	protected Mesa mesa;
	protected boolean plantado;
	
	public AbstractPlayer(String nombre) {
		this.nombre = nombre;
		this.mano = new Mano();
	}
	
	// Métodos
	
	/**
	 * Ejecuta el turno del juegador
	 * @param baraja La baraja del juego
	 */
	public void jugarTurno(Baraja baraja) {
		if (!(this instanceof CPUPlayer)) TextUtils.clearConsole(4);
		
		System.out.print("1. Robar\n2. Plantarse\n¿Qué quieres hacer?: ");

		int opcion;
		if (this instanceof CPUPlayer) {
			opcion = ((CPUPlayer) this).eleccionAleatoria(this.getValorBaraja7yMedia());
			System.out.print(opcion);
		} else {
			opcion = JavaUtils.getInteger(Main.scanner.nextLine(), 1, 2);
		}

		switch (opcion) {
		case 1:
			Carta carta = baraja.robar();
			mano.insertaCartaAlFinal(carta);

			System.out.println("\nCarta robada: " + carta.getNombreCarta() + " (" + carta.getValor7ymedia() + " puntos)");
			System.out.println("Puntos acumulados " + getValorBaraja7yMedia());
			
			break;
		case 2:
			System.out.println(nombre + " se ha plantado con " + getValorBaraja7yMedia() + " puntos...");
			plantado = false;
			
			break;
		default:
			break;
		}
		
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	
	public Baraja getMano() {
		return mano;
	}
	
	public double getValorBaraja7yMedia() {
		double resultado = 0.0;
		for (Carta carta : mano.getCartas()) {
			resultado += carta.getValor7ymedia();
		}
	
		return resultado;
	}
	
	// Setters
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
}
