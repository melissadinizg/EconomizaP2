package economizaP2;

import java.util.Scanner;

/* Melissa Diniz - 115211394
 * Classe que faz a impress�o do menu 
 */

public class EconomizaP2 {
	static Produto produto;
	public static Scanner sc = new Scanner(System.in);
	private static LeEntradas entrada = new LeEntradas();
	private static Supermercado supermercado = new Supermercado();

	public static void main(String[] args) {
		int opcao;

		do {

			imprimeMenu();
			opcao = entrada.recebeInteiro();

			switch (opcao) {
			case 1:
				supermercado.cadastraProduto();
				break;
			case 2:
				supermercado.vendeProduto();
				break;
			case 3:
				supermercado.imprimeBalanco();
				break;
			default:
				// QUALQUER OUTRO SAI
				break;
			}

		} while (opcao != 4);

		System.out.println("-- Fim da execu��o --");

	}

	/*
	 * Imprime o menu
	 */
	public static void imprimeMenu() {
		System.out.println(
				"= = = = Bem-vindo(a) ao EconomizaP2 = = = =\nDigite a op��o desejada:\n1 - Cadastrar um Produto");
		System.out.print("2 - Vender um Produto\n3 - Imprimir Balan�o\n4 - Sair\n\nOp��o: ");

	}
}