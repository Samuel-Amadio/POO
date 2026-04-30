package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoAlimenticio extends Produto{
	
	private String dataValidade;
	
	public ProdutoAlimenticio(String codigo, String nome, int quantidade, double preco, String dataValidade){
		super(codigo, nome, quantidade, preco);
		this.dataValidade = dataValidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	@Override
	public  String exibirDetalhes() {
		return "\nCODIGO : " + this.getCodigo() +
				"\nNome :" + this.getNome() +
				"\n Quantidade :" + this.getQuantidade() + 
				"\n Preço :" + this.getPreco() + 
				"\n Data de validade :" + this.getDataValidade();
		}
	
	public static boolean estaVencido(String dataValidade) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		
		LocalDate dataVal = LocalDate.parse(dataValidade, formato);
		LocalDate hoje = LocalDate.now();
		
		return dataVal.isBefore(hoje);
	}
	
	

}
