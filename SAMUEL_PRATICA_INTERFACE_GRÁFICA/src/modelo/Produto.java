package modelo;

public class Produto {
	
	
	private String nome; 
	private String codigo;
	private double preco;
	private String categoria;
	
	public Produto(String nome, String codigo, double preco, String categoria) {
		this.categoria = categoria;
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
