package economizaP2;

import java.util.Scanner;

public class EconomizaP2 {
	public static Scanner sc = new Scanner(System.in);
	public static double preco = 1.99;
	public static double porcentagem;
	public static double valorGasto = 0.0;
	public static int quantidadeDeProdutos, quantDeProduto;
	public static int contaProdutos = 0;
	public static String nomeDoProduto;
	private static String[] arrayNomeProdutos;
	private static int[] arrayQuantProdutos;
	private static double[] arrayPorcentagem;
		
	public void cadastroDeProdutos() {	
		System.out.print("Digite a quantidade de produtos diferentes que será comprada:");
		quantidadeDeProdutos = recebeInteiro();
		arrayNomeProdutos = new String[quantidadeDeProdutos];
		arrayQuantProdutos = new int[quantidadeDeProdutos];
		arrayPorcentagem = new double[quantidadeDeProdutos];
		
		System.out.println("-- Cadastro de Produtos --");
		
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			System.out.print("Nome do Produto " + (i+1) + ": ");
			recebeString();
			nomeDoProduto = recebeString();
			arrayNomeProdutos[i] = nomeDoProduto;
		
			System.out.print("Quantidade de " + nomeDoProduto + ": ");
			quantDeProduto = recebeInteiro();
			contaProdutos = contaProdutos + quantDeProduto;
			valorGasto = valorGasto + quantDeProduto;
			arrayQuantProdutos[i] = quantDeProduto;
			
			imprime();
			
	}
		
}
	
	public void imprime(){
		
		System.out.println("-- cadastro Concluído --");
		System.out.println();
		System.out.println("A sua compra foi:");
		calculaPorcentagem();
		System.out.println("Total de produtos: " + contaProdutos);
		System.out.println("Total gasto: R$ " + (valorGasto * preco));
		System.out.println(" ");
		
	}
	
	public void calculaPorcentagem(){
		for (int i = 0; i < arrayNomeProdutos.length; i++) {
			porcentagem = (arrayQuantProdutos[i]*100.0)/contaProdutos;
			arrayPorcentagem[i] = Math.round(porcentagem);

			System.out.println(arrayQuantProdutos[i] + " " + arrayNomeProdutos[i] + " (" + (int)arrayPorcentagem[i] + "%)" );
		}
	}
	
	public void alteraPreco(){
		System.out.print("Digite o novo preco dos produtos: ");
		double novoPreco = recebeDouble();
		preco = novoPreco;
		System.out.println("Seu novo preco é: " + preco);
		System.out.println(" ");

	}


	public int recebeInteiro(){
		int inteiro = sc.nextInt();
		return inteiro;
	}
	
	public double recebeDouble(){
		double valorDouble = sc.nextDouble();
		return valorDouble;
	}
	
	public String recebeString(){
		String nomeString = sc.nextLine();
		return nomeString;
	}
}