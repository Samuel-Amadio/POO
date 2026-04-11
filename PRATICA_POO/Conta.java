package Pratica_POO;
import java.util.ArrayList;
import java.util.List;


public class Conta {
	
	private final String numConta;
	private final String CPF;
	private String nome;
	private double saldo;
	private String senha;
	private List<String> extrato;
	private static int geradorNum = 1000;
	
	//GERAR NUMERO DA CONTA
	private static String gerarNumConta() {
			String num = geradorNum + "-0";
			geradorNum ++;
			return num;
	}
	
	
	//lista de extrato
	
	public Conta(String CPF, String nome, String senha) {
		this.nome = nome;
		this.CPF  =CPF;
		this.senha = senha;
		saldo = 0;
		this.extrato = new ArrayList<>();
		numConta = gerarNumConta();
		extrato.add("Conta criada.");
		
	}
	
	public final void exibirAvisoSeguranca() {
		System.out.println("\nAVISO DO APP: Nunca compartilhe sua senha com terceiros!");
	}
	
	//VALIDAR SENHA
	public boolean validarSenha(String senha) {
		return this.senha.equals(senha);
	}
	
	//SACAR
	public boolean sacar(double valor) {
		if(valor<=0) {
			System.out.println("\nValor inválido.");
			return false;
		}
		
		if(valor>saldo) {
			System.out.println("\nSaldo insuficiente.");
			return false;
		}
		
		saldo -= valor;
		
		extrato.add("Saque: -R$ " + valor);
		return true;
	}
	
	//DEPÓSITO
	public void depositar(double valor) {
		if(valor<=0){
			System.out.println("\nValor inválido.");
			return;
		}
		
		saldo += valor;
		
		extrato.add("Depósito em dinheiro: +R$ " + valor);
		
	}
	
	//DEPÓSITO
	public void depositar(double valor, String origem) {
		if(valor<=0){
			System.out.println("\nValor inválido.");
			return;
		}
		
		saldo += valor;
		
		extrato.add("\nTransferência recebida de " + origem + ": +R$" + valor);
		
	}
	
	//EXIBIR EXTRATO
	public void imprimirExtrato() {
		System.out.println("\n===EXTRATO===");
		System.out.println("\nCliente: " + nome);
		System.out.println("\nConta: " + numConta);
		
		for(String linha : extrato) {
			System.out.println(linha);
		}
		
		System.out.println("\nSaldo final: R$" + saldo);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getNumConta() {
		return numConta;
	}


	
	
	
}
