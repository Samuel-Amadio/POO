package view;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Mensagem", "Titulo da janela", JOptionPane.INFORMATION_MESSAGE);
		
		int result = JOptionPane.showConfirmDialog(null, "Deseja cotinuar?", "Titulo de option", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_NO_OPTION)
			System.out.println("\nUsuario digitou 'SIM'");
		
		String [] options = {"Opção 01", "Opção 02" , "Opção 03"};
		
		int resultOption = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Opções", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(resultOption != JOptionPane.CLOSED_OPTION) {
			System.out.println("\nVoce escolheu a opção: " + options[resultOption]);
		}
	}

}