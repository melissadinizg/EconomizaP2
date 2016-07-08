package economizaP2;

import java.util.Scanner;

public class EconomizaP2 {
	public static Scanner sc = new Scanner(System.in);
	Produto produto;
	public static String nome, tipo;
	public static double preco;
	public static Produto[] estoque = new Produto[5];
	public static int quantidadeDeProdutos, quantDeProduto;
	
	public void cadastroDeProdutos() {
		String opcao;
		int index = 0;
		
		do {
			
			System.out.println("= = = = Cadastro de Produtos = = = =");
			
			System.out.print("Digite o nome do produto: ");
			nome = recebeString();
			sc.nextLine();
			System.out.print("Digite o preço unitário do produto: ");
			preco = recebeDouble();
			System.out.print("Digite o tipo do produto: ");
			tipo = recebeString();
			sc.nextLine();
			produto = new Produto(nome, preco, tipo);
			
			System.out.println(produto.getNome() + " cadastrado com sucesso.");
			
			System.out.println("Deseja cadastrar outro produto? ");
			opcao = sc.nextLine().toLowerCase();
			
			estoque[index] = produto;
			index = index + 1;
			
			
		} while (opcao != "nao" && opcao != "não");

		imprime();
			
	}
		


	public void imprime() {

		for (int i = 0; i < estoque.length; i++) {
			System.out.println(estoque[i].getNome());
		}

	}



	public void alteraPreco() {
		System.out.print("Digite o novo preco dos produtos: ");
		double novoPreco = recebeDouble();
		preco = novoPreco;
		System.out.println("Seu novo preco é: " + preco);
		System.out.println(" ");

	}

	public int recebeInteiro() {
		int inteiro = sc.nextInt();
		return inteiro;
	}

	public double recebeDouble() {
		double valorDouble = sc.nextDouble();
		return valorDouble;
	}

	public String recebeString() {
		String nomeString = sc.nextLine();
		return nomeString;
	}
}