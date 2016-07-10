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

	/*
	 * Metodo que faz o cadastro dos produtos(nome, preco, tipo)
	 */
	public static void cadastraProduto() {
		String nome, tipo;
		double preco;

		String opcao;
		int index = 0;

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
			index = index + 1;

		} while (opcao.equalsIgnoreCase("sim"));

	}

	public void imprimeProdutos() {

		for (int i = 0; i < estoque.length; i++) {
			if (!estoque[i].getNome().equals(null)) {
				System.out.println(estoque[i].toString());
			}
		}
	}
	
	/*
	 * tem um erro aqui, pois imprime que o produto nao ta cadastrado
	 * e que nao tem produto no estoque 
	 */
	
	public void vendeProduto() {
		String opcao;

		do {
			System.out.print("= = = = Venda de Produtos = = = =\n");

			for (int i = 0; i < estoque.length; i++) {
				
				if (estoque[i] != null) {
					//se o estoque nao estiver vazio ele pergunta qual o produto
					System.out.print("Digite o nome do produto: ");
					String nome = entrada.recebeString();

					// usando o método buscaProdutoPeloNome
					// se for true imprime o produto
					if (buscaProdutoPeloNome(nome)) {
						System.out.println("==> " + produto.getNome() + " (" + produto.getTipo() + "). R$" + produto.getPreco());
						break;
					} else {
						System.out.println("==> " + nome + " nao cadastrada no sistema.");
					}
				//se tiver vazio o estoque ele imprime que nao tem produtos
				}else{
					System.out.println("Não tem produtos cadastrados.");
					break;
				}
				
			}

			System.out.print("Deseja vender outro produto? ");
			opcao = entrada.recebeString();

		} while (opcao.equalsIgnoreCase("sim"));
	}

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
		
