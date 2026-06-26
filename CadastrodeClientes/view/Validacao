package view;

import javax.swing.JOptionPane;
import util.Regex;

public interface Validacao {

	public default boolean validarCliente(String nome, String telefone, String email, String sexo) {
		if (nome.isBlank() || email.isBlank() || telefone.isBlank() || sexo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Alerta", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        if (!Regex.RegexNome(nome) ){ 
            JOptionPane.showMessageDialog(null, "Nome inválido! O nome deve aceitar apenas letras, espaços e acentos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        if (!Regex.RegexEmail(email) ){ 
            JOptionPane.showMessageDialog(null, "E-mail inválido! Rejeitado e-mails sem arroba ou sem domínio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Regex.RegexTelefone(telefone) ){ 
            JOptionPane.showMessageDialog(null, "Telefone inválido! Formato esperado: (69) 99999-9999", "Erro de Validação", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        return true;
	}
	
	
}
