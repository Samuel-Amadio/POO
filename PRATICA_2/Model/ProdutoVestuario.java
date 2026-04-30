package model;

import java.util.ArrayList;
import java.util.List;

public class ProdutoVestuario extends Produto{
	private List<String> tamanhos ;
	private String material;
	
	public ProdutoVestuario(String codigo, String nome, int quantidade, double preco,
	String material, String tamanho){
		super(codigo, nome, quantidade, preco);
		this.material = material;
		this.tamanhos = new ArrayList<>();
		tamanhos.add(tamanho);
		}

	public List<String> getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(List<String> tamanhos) {
		this.tamanhos = tamanhos;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public  String exibirDetalhes() {
		String detalhes = "\nCODIGO : " + this.getCodigo() +
				"\nNome :" + this.getNome() +
				"\n Quantidade :" + this.getQuantidade() + 
				"\n Preço :" + this.getPreco() + 
				"\n Material :" + this.getMaterial();
		
		if(isTamanhoUnico()) {
			detalhes+= "\nTamanho único:" + tamanhos.get(0);
		}else {
			detalhes += "\nTamanhos: " + tamanhos;
		}
		
		return detalhes;
		}
	
	public boolean isTamanhoUnico() {
		if(tamanhos.size()==1) {
			return true;
		}
		return false;
	}
	
	public double calcularPrecoPromocional() {
		if(isTamanhoUnico()) {
			return 0.10;
		}
		return 1;
	}
}

