package mainapp;

import java.util.Scanner;

import game.AbstractGame;
import game.GameMode;
import game.GameType;
import game.impl.SieteYMedia;
import utils.JavaUtils;
import utils.TextUtils;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println(TextUtils.TEXT_LINE);
		System.out.println("     BIENVENIDO AL CASINO");
		System.out.println(TextUtils.TEXT_LINE + "\n");
		
		AbstractGame game = new SieteYMedia();
		game.start();
		
	}
}
