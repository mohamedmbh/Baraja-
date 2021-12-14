package game;

public enum GameType {

	SIETE_Y_MEDIA("Siete y Media"),
	TUTE("Tute"),
	MUS("Mus");

	private String nombre;
	
	GameType(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
