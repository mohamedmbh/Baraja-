package models.player;

public class CPUPlayer extends AbstractPlayer {

	public CPUPlayer() {
		super("PC");
	}

	/**
	 * Retorna 1 o 2 con un 70% de probabilidad de elegir 1
	 * en caso de que su puntuaje sea mayor o igual a 5
	 * @return
	 */
	public int eleccionAleatoria(double puntuaje) {
		if (puntuaje < 5.0) return 1;
		return ((int) Math.random() * 100 - 1) > 70 ? 1 : 2;
	}
	
}
