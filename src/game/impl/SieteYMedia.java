package game.impl;

import java.util.ArrayList;
import java.util.List;

import game.AbstractGame;
import game.GameMode;
import game.GameType;
import mainapp.Main;
import models.Baraja;
import models.Carta;
import models.player.AbstractPlayer;
import models.player.CPUPlayer;
import utils.JavaUtils;
import utils.TextUtils;

public class SieteYMedia extends AbstractGame {

	private Baraja baraja;
	private int turno = 0;

	public SieteYMedia() {
		super(GameType.SIETE_Y_MEDIA);
		start();
	}

	@Override
	public void bienvenida() {
		System.out.println(TextUtils.TEXT_LINE);
		System.out.println("         BIENVENIDO AL JUEGO");
		System.out.println("          DE LAS 7 Y MEDIA");
		System.out.println(TextUtils.TEXT_LINE + "\n");

		TextUtils.clearConsole(9);
		System.out.println("Adapta la pantalla y presiona intro para empezar...");
		Main.scanner.nextLine();
	}

	@Override
	public void start() {
		this.baraja = new Baraja(1, true);
		
		List<AbstractPlayer> jugadoresPlantados = new ArrayList<>();
		
		while (running) {
			AbstractPlayer player = jugadores.get(turno);

			if (!jugadoresPlantados.contains(player)) {
				System.out.println(TextUtils.TEXT_LINE);
				System.out.println("Cartas en la baraja: " + baraja.getNumeroCartas());
				System.out.println("Cartas repartidas: " + (40 - baraja.getNumeroCartas()) + "\n");

				System.out.println("Turno de: " + player.getNombre());
				System.out.println("Puntos: " + player.getValorBaraja7yMedia());
				System.out.println("Mano: " + (player.getMano() == null ? "" : player.getMano()));
				System.out.println(TextUtils.TEXT_LINE + "\n");
				
				player.jugarTurno(baraja);
				
				if (jugadoresPlantados.size() == jugadores.size()) {
					AbstractPlayer ganador = jugadores.get(0);
					for (AbstractPlayer jugador : jugadores) {
						if (jugador.getValorBaraja7yMedia() > ganador.getValorBaraja7yMedia()) {
							ganador = jugador;
						}
					}

					System.out.println("\n¡¡¡El ganador es " + ganador.getNombre() + " con un total de " + ganador.getValorBaraja7yMedia() + " puntos!!!");
					this.running = false;
				}

				// Bucle que comprueba el puntaje de todos los jugadores, si es mayor a 7.5
				// se elimina ese jugador de la lista de jugadores y muestra por pantalla que ha perdido.
				for (int i = 0; i < jugadores.size(); i++) {
					AbstractPlayer jugador = jugadores.get(i);
					if (jugador.getValorBaraja7yMedia() > 7.5) {
						System.out.println("\n" + jugador.getNombre() + " ha perdido...");
						jugadores.remove(jugadores.indexOf(jugador));
					}
				}

				// Tras eliminar los jugadores que han perdido en el bucle, se comprueba si
				// la lista de jugadores tiene un solo jugador para terminar el juego y mostrar los ganadores.
				if (jugadores.size() == 1) {
					System.out.println("¡¡¡" + jugadores.get(0).getNombre() + " ha ganado!!!");
					running = false;
				}
				
				if (running) {
					if (!(player instanceof CPUPlayer)) TextUtils.clearConsole(11);
					System.out.println("Presiona intro para pasar al siguiente turno");
					Main.scanner.nextLine();
				} else {
					TextUtils.clearConsole(9);
					System.out.println("Juego terminado, presiona intro para continuar.");
					Main.scanner.nextLine();
				}
			}
			if (running && turno != jugadores.size() - 1) turno++;
			else if (running) turno = 0;
		}
		
		super.finish();
	}
	
	@Override
	public void finish() {
		super.finish();
	}
}
