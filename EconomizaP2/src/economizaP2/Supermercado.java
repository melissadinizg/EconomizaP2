/**
 * 
 */
package economizaP2;

import java.util.Scanner;

/**
 * @author Melissa Classe supermercado: Faz o cadastro dos produtos Vende os
 *         produtos Busca os produtos no estoque
 *
 */
public class Supermercado {

	// cria um array do tipo Produto
	private static Produto[] estoque = new Produto[3];
	private static Scanner sc = new Scanner(System.in);
	static LeEntradas entrada = new LeEntradas();
	static Produto produto;
	private static double totalGasto;
	public int index = 0;

	/*
	 * Metodo que faz o cadastro dos produtos(nome, preco, tipo)
	 * PRECISO ARRUMAR O INDEX
	 */
	public void cadastraProduto() {
		String nome, tipo;
		double preco;
		String opcao;


		do {

			System.out.println("= = = = Cadastro de Produtos = = = =");

			// recebe o nome, preco e tipo do objeito Produto
			System.out.print("Digite o nome do produto: ");
			nome = entrada.recebeString();

			System.out.print("Digite o preço unitário do produto: ");
			preco = entrada.recebeDouble();

			System.out.print("Digite o tipo do produto: ");
			tipo = entrada.recebeString();

			// cria o objeto Produto com os dados recebidos de entrada
			produto = new Produto(nome, preco, tipo);

			System.out.println();
			System.out.println(produto.getNome() + " cadastrado com sucesso.");
			System.out.println();
			System.out.println("Deseja cadastrar outro produto? ");

			// deseja cadastrar outro produto?
			opcao = sc.nextLine();

			// adiciona o produto no estoque
			estoque[index] = produto;
			this.index = index + 1;
			System.out.println(index);
			System.out.println(produto.toString());
		} while (opcao.equalsIgnoreCase("sim"));

	}

	
	public boolean verificaEstoqueVazio() {
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * tem um erro aqui, pois imprime que o produto nao ta cadastrado
	 * e que nao tem produto no estoque 
	 */
	
	public void vendeProduto() {
		String opcao;
		int quantidadeVenda = 0;

		do {
			System.out.print("= = = = Venda de Produtos = = = =\n");

			// verifica se o estoque ta vazio
			if (verificaEstoqueVazio()) {
				System.out.println("Nao tem produtos cadastrados.");

			} else {

				for (int i = 0; i < estoque.length; i++) {

					System.out.print("Digite o nome do produto: ");
					String nome = entrada.recebeString();

					// usando o método buscaProdutoPeloNome
					// se for true imprime o produto
					if (buscaProdutoPeloNome(nome)) {

						System.out.println("==> " + produto.getNome() + " (" + produto.getTipo() + "). R$" + produto.getPreco());
						System.out.println();
						System.out.println("Digite a quantidade que quer vender: ");
						quantidadeVenda = entrada.recebeInteiro();

						totalGasto = calculaTotalGasto(quantidadeVenda);
						System.out.println("==> Total arrecadado: R$ " + totalGasto);
						

					} else {
						System.out.println("==> " + nome + " nao cadastrada no sistema.");
					}

				}
			}

			System.out.print("Deseja vender outro produto? ");
			opcao = entrada.recebeString();

		} while (opcao.equalsIgnoreCase("sim"));
	}

	
	
	/*
	 * Metodo que calcula e retorna o total gasto Recebe como parametro a
	 * quantidade de produto que vai ser vendido
	 */
	public double calculaTotalGasto(int quantidade) {
		this.totalGasto = totalGasto + (produto.getPreco() * quantidade);
		return totalGasto;

	}
	
	/*
	 * Faz a impressao do balanço
	 */
	public void imprimeBalanco() {

		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados:");

		for (int i = 0; i < estoque.length; i++) {
			if (verificaEstoqueVazio()) {
				System.out.println("Nenhum produto cadastrado.");

			} else {
				System.out.println("   " + (i + 1) + ") " + estoque[i].toString());
			}
		}
		System.out.println("==> Total arrecadado: R$ " + totalGasto);
	}

	
	/*
	 * Metodo que faz a busca no array pra verificar
	 * se o produto ja foi cadastrado 
	 */
	public boolean buscaProdutoPeloNome(String nome) {

		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {

				// usando o equals compara se o nome do produto dado é igual ao
				// nome
				// do produto[i]
				if (estoque[i].getNome().equals(nome)) {
					return true;
				}
			}
		}
		return false;
	}
}	
		
