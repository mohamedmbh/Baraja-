package utils;

public class TextUtils {

	public static String TEXT_LINE = "-------------------------------------";
	
	public static void clearConsole(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("");
		}
	}
	
	public static void clearConsole() {
		clearConsole(5);
	}
}
