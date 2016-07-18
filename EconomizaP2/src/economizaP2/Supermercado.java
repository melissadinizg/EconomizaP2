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
	public static Estoque estoque = new Estoque();
	private static Produto produto;

	private static Scanner sc = new Scanner(System.in);
	static LeEntradas entrada = new LeEntradas();
	private static double totalGasto;
	private static double valorTotal;

	/*
	 * Metodo que faz o cadastro dos produtos(nome, preco, tipo) OK
	 */
	public void cadastraProduto() {
		String nome, tipo = null, opcao;
		double preco = 0;
		int quantidadeEstoque = 0;

		System.out.println("= = = = Cadastro de Produtos = = = =");

		do {

			// recebe o nome, preco e tipo do objeito Produto
			System.out.print("Digite o nome do produto: ");
			nome = LeEntradas.recebeString();

			System.out.print("Digite o preço unitário do produto: ");
			preco = LeEntradas.recebeDouble();

			System.out.print("Digite o tipo do produto: ");
			tipo = LeEntradas.recebeString();

			System.out.print("Digite a quantidade no estoque: ");
			quantidadeEstoque = LeEntradas.recebeInteiro();

			produto = new Produto(nome, preco, tipo, quantidadeEstoque);

			estoque.adicionaProdutoEstoque(produto);

			// cria o objeto Produto com os dados recebidos de entrada
			System.out.println();
			System.out.println(produto.getNome() + " cadastrado com sucesso.");
			System.out.println();
			System.out.println("Deseja cadastrar outro produto? ");

			// deseja cadastrar outro produto?
			opcao = sc.nextLine();

		} while (opcao.equalsIgnoreCase("sim"));

	}

	/*
	 * Faz a venda do produto
	 */
	public void vendeProduto() {
		String opcao;
		int quantidadeVenda = 0;
		int quantProdutoNoEstoque;

		System.out.print("= = = = Venda de Produtos = = = =\n");

		do {

			// verifica se o estoque nao ta vazio
			if (!estoque.verificaEstoqueVazio()) {

				System.out.print("Digite o nome do produto: ");
				String nome = LeEntradas.recebeString();

				// usando o método buscaProdutoPeloNome se for true imprime o
				// produto
				for (int i = 0; i < Estoque.estoque.length; i++) {
					if (Estoque.estoque[i] != null) {
						// usando o método buscaProdutoPeloNome se for true
						// imprime o produto
						if (estoque.procuraProdutoPeloNome(nome)) {

							System.out.println("==> " + Estoque.estoque[i].getNome() + " ("
									+ Estoque.estoque[i].getTipo() + "). R$" + Estoque.estoque[i].getPreco());
							System.out.println();

							// VERIFICAR AQUI SE A QUANTIDADE EH SUFICIENTE
							System.out.println("Digite a quantidade que quer vender: ");

							quantidadeVenda = LeEntradas.recebeInteiro();
							estoque.verificaQuantDisponivel(quantidadeVenda);

							this.totalGasto = calculaTotalGasto(quantidadeVenda);

						} else {
							System.out.println();
							System.out.println("==> " + nome + " nao cadastrada no sistema.");
						}
					}
				}
				// se o estoque estiver vazio
			} else {
				System.out.println("Estoque vazio.");
			}

			System.out.println("==> Total arrecadado: R$ " + totalGasto);
			System.out.println();
			System.out.print("Deseja vender outro produto? ");
			opcao = LeEntradas.recebeString();

		} while (opcao.equalsIgnoreCase("sim"));
	}

	/*
	 * Varre o estoque e calcula o valor dos produtos restantes
	 */
	public double calculaValorRestante() {
		int quant = 0;
		double preco = 0.0;
		for (int i = 0; i < Estoque.estoque.length; i++) {
			if (Estoque.estoque[i] != null) {
				quant = quant + Estoque.estoque[i].getQuantidadeProduto();
				preco = preco + Estoque.estoque[i].getPreco();
			}
		}
		this.valorTotal = quant * preco;
		return valorTotal;
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
	 * Faz a impressao do balanço OK
	 */
	public void imprimeBalanco() {

		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados:");

		// verifica se o estoque esta vazio
		if (estoque.verificaEstoqueVazio()) {
			System.out.println("    Estoque vazio.");

		} else {
			// se nao estiver vazio ele usa o laço para imprimir os produtos
			for (int i = 0; i < Estoque.estoque.length; i++) {
				if (Estoque.estoque[i] != null) {
					System.out.println("   " + (i + 1) + ") " + Estoque.estoque[i].toString());
				}
			}
		}
		// faz a impressao do total arreacadado nas vendas
		System.out.println();
		System.out.println("Total arrecadado em vendas: R$ " + totalGasto);
		System.out.println("Total que pode ser arrecadado: R$ " + calculaValorRestante());
		System.out.println();

	}

}
