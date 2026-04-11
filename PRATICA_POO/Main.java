package Pratica_POO;

public class Main {

	public static void main(String[] args) {

	        App_Bancario app = new App_Bancario();

	        Conta pedro = new Conta("Pedro", "11111111111", "123");
	        Conta ana = new Conta("Ana", "22222222222", "456");

	        app.cadastrarConta(pedro);
	        app.cadastrarConta(ana);

	        // login Pedro
	        app.logar(pedro.getNumConta(), "123");

	        app.depositar(500);

	        app.transferir(ana.getNumConta(), 150);

	        pedro.imprimirExtrato();

	        // login Ana
	        app.logar(ana.getNumConta(), "456");

	        ana.imprimirExtrato();

	        App_Bancario.exibirMetricas();
		

	}

}
