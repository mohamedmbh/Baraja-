package utils;

public class CartaUtils {

	public static String[] NOMBRE_CARTAS = new String[] {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete",  "sota", "caballo", "rey"};
	
	/**
	 * Retorna el número de la carta a partir de la
	 * posición en una baraja ordenada.
	 * @param id
	 * @return
	 */
	public static int getNumeroCartaById(int id) {
		return (id % 10 == 0) ? 10 : id % 10;
	}
	
	/**
	 * Retorna el índice del palo a partir de la
	 * posición en una baraja ordenada.
	 * @param id
	 * @return
	 */
	public static int getIndicePaloById(int id) {
		return (id % 10 == 0) ? id / 10 - 1 : id / 10;
	}
	
}
