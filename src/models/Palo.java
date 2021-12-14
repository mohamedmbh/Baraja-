package models;

public enum Palo {

	ORO,
	COPA,
	ESPADA,
	BASTO;
	
	/**
	 * Devuelve el palo a partir de un número (0...3)
	 * @return
	 */
	public static Palo getPaloByIndice(int n) {
		return Palo.values()[n];
	}
	
	@Override
	public String toString() {
		// return name().charAt(0) + name().substring(1).toLowerCase();
		return name().toLowerCase();
	}
	
}
