package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public Regex () {
		
	}
	
	public boolean RegexNome(String nome) {
		String nomePadrao = "^[A-Za-z`A-¨y ]+$";
		Pattern namePattern = Pattern.compile(nomePadrao);
		Matcher matcher = namePattern.matcher(nome);
		boolean resultado = matcher.find();
		return resultado;
	}
	
	public boolean RegexTelefone(String telefone) {
		String telefonePadrao = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$";
		Pattern telefonePattern = Pattern.compile(telefonePadrao);
		Matcher matcher = telefonePattern.matcher(telefone);
		boolean resultado = matcher.find();
		return resultado;
	}
	
	public boolean RegexEmail(String email) {
		String emailPadrao = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern emailPattern = Pattern.compile(emailPadrao);
		Matcher matcher = emailPattern.matcher(email);
		boolean resultado = matcher.find();
		return resultado;
	}
}
