package model;

public class ProdutoEletronico extends Produto{
	
	private int garantiaMeses;
	private String voltagem;
	
	public ProdutoEletronico(String codigo, String nome, int quantidade, double preco,
	String voltagem, int garantiaMeses){
		super(codigo, nome, quantidade, preco);
		this.voltagem = voltagem;
		this.garantiaMeses = garantiaMeses;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	public String getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(String voltagem) {
		this.voltagem = voltagem;
	}
	
	@Override
	public  String exibirDetalhes() {
		return "\nCODIGO : " + this.getCodigo() +
				"\nNome :" + this.getNome() +
				"\n Quantidade :" + this.getQuantidade() + 
				"\n Preço :" + this.getPreco() + 
				"\n Voltagem :" + this.getVoltagem() + 
				"\n Meses de garantia :" + this.getGarantiaMeses();
		}
	
	public boolean possuiGarantiaEstendida() {
		if(garantiaMeses<3) {
			return true;
		}
		return false;
	}
	
	public double taxaArmazenamento() {
		if(this.getQuantidade()>3) {
			return this.getQuantidade()*10;
		}
		return 0;
	}
	
}
