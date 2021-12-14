package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.player.AbstractPlayer;

public class Mesa {

	private final Baraja baraja;
	private final List<AbstractPlayer> jugadores;
	
	public Mesa() {
		this.baraja = new Baraja();
		this.jugadores = new ArrayList<>();
	}
	
	public void addJugador(AbstractPlayer player) {
		this.jugadores.add(player);
	}
	
	public void addJugadores(AbstractPlayer[] players) {
		Collections.addAll(jugadores, players);
	}
	
	public void addJugadores(List<AbstractPlayer> players) {
		this.jugadores.addAll(players);
	}
	
	public void removeJugador(AbstractPlayer player) {
		this.jugadores.remove(jugadores.indexOf(player));
	}
	
	public Carta robarCartaDeBaraja() {
		return baraja.robar();
	}
	
	public List<Carta> robarVariasCartas(int n) {
		List<Carta> lista = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			lista.add(robarCartaDeBaraja());
		}
		
		return lista;
	}
	
	public void addCartaABaraja() throws Exception {
		if (baraja.getNumeroCartas() == baraja.getCapacidad()) {
			throw new Exception("No puedes agregar una carta porque la baraja ya está llena");
		}
		
		this.baraja.getCartas().add(new Carta(baraja.getNumeroCartas()));
	}
}
