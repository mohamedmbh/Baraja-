package game;

import java.util.ArrayList;
import java.util.List;

import mainapp.Main;
import models.Baraja;
import models.Mesa;
import models.player.AbstractPlayer;
import models.player.CPUPlayer;
import models.player.HumanPlayer;
import utils.JavaUtils;
import utils.TextUtils;

public abstract class AbstractGame {

	private GameType tipoJuego;
	private GameMode modoJuego;
	private int maxJugadores;
	private final Mesa mesa;

	protected Baraja baraja;
	protected List<AbstractPlayer> jugadores = new ArrayList<>();
	protected boolean running = true;

	public AbstractGame(GameType tipoJuego) {
		this.tipoJuego = tipoJuego;
		this.mesa = new Mesa();

		definirModo();
		definirJugadores();
		bienvenida();
	}

	public abstract void bienvenida();

	public abstract void start();
	
	private void definirModo() {
		for (int i = 0; i < GameMode.values().length; i++) {
			System.out.println((i + 1) + ". " + GameMode.values()[i]);
		}

		System.out.print("¿Contra quién quieres jugar al juego de las siete y media?: ");
		int numeroModoJuegoo = JavaUtils.getInteger(Main.scanner.nextLine(), 1, GameMode.values().length);

		this.modoJuego = GameMode.values()[numeroModoJuegoo - 1];
	}

	private void definirJugadores() {		
		switch (modoJuego) {
		case MULTIPLAYER:
			System.out.print("¿Cuantos jugadores van a haber? (minimo 2): ");
			this.maxJugadores = JavaUtils.getInteger(Main.scanner.nextLine(), 2);
			break;
		case SOLITARIO:
			this.maxJugadores = 1;
			break;
		case CPUVS1:
		case PVP:
			this.maxJugadores = 2;
			break;
		default:
			break;
		}

		if (modoJuego == GameMode.CPUVS1) {
			jugadores.add(new CPUPlayer());
		}

		int cantidadJugadores = jugadores.size();
		for (int i = 0; i < maxJugadores - cantidadJugadores; i++) {
			System.out.print("Escribe el nombre del jugador " + (i + 1) + ": ");
			String nombre = Main.scanner.nextLine();
			while (nombre.length() == 0) {
				System.out.print("Nombre no válido, vuelve a escribirlo: ");
				nombre = Main.scanner.nextLine();
			}

			jugadores.add(new HumanPlayer(nombre));
		}
	}

	public void finish() {
		TextUtils.clearConsole(12);
		System.out.println("1. Si\n2. No");
		System.out.print("¿Quieres volver a jugar?: ");
		int volverJugar = JavaUtils.getInteger(Main.scanner.nextLine(), 1, 2);

		if (volverJugar == 1) {
			TextUtils.clearConsole(12);
			this.running = true;
			this.jugadores = new ArrayList<>();
			definirModo();
			definirJugadores();
			bienvenida();
			start();
		}
	}
}
