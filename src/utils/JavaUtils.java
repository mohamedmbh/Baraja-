package utils;

import mainapp.Main;

public class JavaUtils {

	public static boolean isNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (Exception e) {
			// ignore
			return false;
		}
	}
	
	public static int getInteger(String stringInteger, int min, int max) {	
		try {
			int result = Integer.parseInt(stringInteger);
			
			while (Integer.parseInt(stringInteger) < min || Integer.parseInt(stringInteger) > max) {
				System.out.print("\nNúmero no válido. (Min: " + min + ", max: " + max + ")");
				stringInteger = Main.scanner.nextLine();
			}
			
			return result;
		} catch (Exception e) {
			boolean isNumber;
			do {
				System.out.print("\nNúmero no válido, introduce un número válido: ");
				stringInteger = Main.scanner.nextLine();
				
				isNumber = true;
			} while (!isNumber);
		}
		return -1;
	}
	
	public static int getInteger(String stringInteger, int min) {
		return getInteger(stringInteger, min, Integer.MAX_VALUE);
	}
	
	public static int getInteger(String stringInteger) {
		return getInteger(stringInteger, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
}
