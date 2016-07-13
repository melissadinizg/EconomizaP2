package economizaP2;

/*
 * Classe produto
 * define o construtor de Produto
 */

public class Produto {
	private String nome;
	private String tipo;
	private double preco;
	
	public Produto(String nome, double preco, String tipo) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return getNome()+"("+getTipo()+"). R$"+getPreco();
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


	

}
