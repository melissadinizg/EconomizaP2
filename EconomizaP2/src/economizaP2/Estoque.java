
package economizaP2;

/**
 * @author Melissa
 *
 */
public class Estoque {
	public static Produto[] estoque;
	private static int quantProdutosCadastrados = 0;
	private static int index = 0;
	private Produto[] novoEstoque;

	// construtor da classe estoque, cria o array estoque
	public Estoque() {
		this.estoque = new Produto[2];
	}

	public boolean aumentaEstoque() {
		boolean aumentou = false;

		if (getQuantProdutosCadastrados() == estoque.length) {
			novoEstoque = new Produto[estoque.length * 2];
			aumentou = true;

			for (int i = 0; i < estoque.length; i++) {
				novoEstoque[i] = estoque[i];
			}
		}

		this.estoque = novoEstoque;
		return aumentou;
	}

	/*
	 * Verifica se tem a quant suficiente no estoque
	 */
	public int verificaQuantDisponivel(int quantidadeVenda) {
		int quantProdutoNoEstoque = 0;
		// se o estoque nao estiver vazio
		if (!verificaEstoqueVazio()) {

			for (int i = 0; i < estoque.length; i++) {
				// se for diferente de null
				if (estoque[i] != null) {
					quantProdutoNoEstoque = estoque[i].getQuantidadeProduto();

					if (quantidadeVenda <= quantProdutoNoEstoque) {
						quantProdutoNoEstoque = quantProdutoNoEstoque - quantidadeVenda;
						estoque[i].setQuantidadeProduto(quantProdutoNoEstoque);
					} else {
						System.out
								.println("Não é possível vender pois não há " + estoque[i].getNome() + " suficiente.");
					}
				}
			}
		}
		return quantProdutoNoEstoque;
	}

	/*
	 * Verifica se o estoque esta vazio e retorna um boolean
	 */
	public static boolean verificaEstoqueVazio() {
		if (quantProdutosCadastrados == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void adicionaProdutoEstoque(Produto produto) {
		estoque[index] = produto;
		index = index + 1;
		quantProdutosCadastrados = quantProdutosCadastrados + 1;
	}

	/*
	 * Metodo que faz a busca pelo nome no array pra verificar se o produto ja
	 * foi cadastrado
	 */
	public boolean procuraProdutoPeloNome(String nome) {
		boolean achou = false;
		int indiceEncontrado;

		if (!verificaEstoqueVazio()) {
			for (int i = 0; i < estoque.length; i++) {
				if (estoque[i] != null) {
					if (estoque[i].getNome().equalsIgnoreCase(nome)) {
						achou = true;
						indiceEncontrado = i;
						break;
					}
				}
			}
		} else {
			System.out.println("Estoque vazio.");
		}
		return achou;
	}

	/*
	 * Metodo que faz a busca pelo produto no array pra verificar se o produto
	 * ja foi cadastrado
	 */
	public boolean buscaProduto(Produto produto) {
		boolean achou = false;
		// se o estoque nao estiver vazio ele executa o for
		if (!verificaEstoqueVazio()) {

			for (int i = 0; i < estoque.length; i++) {
				if (estoque[i] != null) {
					if (estoque[i].equals(produto)) {
						achou = true;
						break;
					}
				}
			}
		}
		return achou;
	}

	public static int getQuantProdutosCadastrados() {
		return quantProdutosCadastrados;
	}

	public static void setQuantProdutosCadastrados(int quantProdutosCadastrados) {
		Estoque.quantProdutosCadastrados = quantProdutosCadastrados;
	}
}