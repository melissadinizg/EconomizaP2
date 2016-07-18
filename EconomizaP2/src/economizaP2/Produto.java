package economizaP2;

/* 
 * Melissa Diniz - 115211394
 * Classe produto
 * define o construtor de Produto
 */

public class Produto {
	private String nome;
	private String tipo;
	private double preco;
	private int quantidadeProduto;

	public Produto(String nome, double preco, String tipo, int quantidadeProduto) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidadeProduto = quantidadeProduto;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// se o tipo real do obj que recebemos eh igual a Produto
		if (!(obj instanceof Produto))
			return false;
		// transformando o object para Produto novamente
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNome() + "(" + getTipo() + "). R$" + getPreco() + " Restante: " + getQuantidadeProduto();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
