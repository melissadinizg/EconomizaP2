package economizaP2;

import java.util.Scanner;

/* Melissa Diniz - 115211394
 * Classe que faz a leitura do teclado
 */
public class LeEntradas {

	private static Scanner sc = new Scanner(System.in);

	
	public static int recebeInteiro() {
		int inteiro = sc.nextInt();
		sc.nextLine();
		return inteiro;
	}

	public static String recebeString() {
		String nomeString = sc.nextLine();
		return nomeString;
	}

	public static double recebeDouble() {
		double valorDouble = sc.nextDouble();
		sc.nextLine();
		return valorDouble;
	}
}
