package util;

public class GeradorCodigo {
	
	private static int sequencial = 1;
	
	public static String gerarCodigo(String prefixo) {
		String codigo = String.format("%s-%03d", prefixo.toUpperCase(), sequencial);
		sequencial++;
		return codigo;
	}
}


