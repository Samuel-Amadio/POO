package Pratica_POO;
import java.util.HashMap;
import java.util.Map;

public class App_Bancario {
	private final Map<String, Conta> contas = new HashMap<>();
	private Conta contaLogada;
	
	private static int transacoesRealizadas = 0;
	
	//CADASTRO
	public void cadastrarConta(Conta conta) {
		contas.put(conta.getNumConta(), conta);
	}
	
	//LOGIN
	public void logar(String numConta, String senha) {
		
		Conta conta = contas.get(numConta);
		
		if(conta == null) {
			System.out.println("\nConta não encontrada");
			return;
		}
		
		if(!conta.validarSenha(senha)) {
			System.out.println("\nSenha incorreta.");
			return;
		}
		
		 contaLogada = conta;

	        System.out.println("\nUsuário logado: " + conta.getNome());
	        
	        conta.exibirAvisoSeguranca();
	    }

	    //DEPOSITAR 
	    public void depositar(double valor) {

	        if (contaLogada == null) {
	            System.out.println("\nNenhum usuário logado.");
	            return;
	        }

	        contaLogada.depositar(valor);

	        transacoesRealizadas++;
	    }

	    //TRANSFERIR 
	    public void transferir(String contaDestino, double valor) {

	        if (contaLogada == null) {
	            System.out.println("\nNenhum usuário logado.");
	            return;
	        }

	        Conta destino = contas.get(contaDestino);

	        if (destino == null) {
	            System.out.println("C\nonta destino não existe.");
	            return;
	        }

	        if (destino == contaLogada) {
	            System.out.println("\nNão pode transferir para si mesmo.");
	            return;
	        }

	        if (contaLogada.sacar(valor)) {

	            destino.depositar(valor, contaLogada.getNome());

	            transacoesRealizadas++;
	        }
	    }

	    //MÉTRICAS
	    public static void exibirMetricas() {

	        System.out.println("\n=== MÉTRICAS DO SISTEMA ===");

	        System.out.println("Total de operações realizadas: " + transacoesRealizadas);
	    }
	}

