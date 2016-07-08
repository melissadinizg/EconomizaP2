package economizaP2;

public class Produto {
	String nome, tipo;
	double preco;
	
	public Produto(String nome, double preco, String tipo) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
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
