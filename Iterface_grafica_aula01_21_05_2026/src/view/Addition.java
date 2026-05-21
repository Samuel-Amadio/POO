package view;

import javax.swing.JOptionPane;

public class Addition {

	public static void main(String[] args) {

		String numero1 = JOptionPane.showInputDialog(null, "Informe o primeiro número", "Adição de números", JOptionPane.PLAIN_MESSAGE);
		String numero2 = JOptionPane.showInputDialog(null, "Informe o segundo número", "Adição de números", JOptionPane.PLAIN_MESSAGE);

		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);
		
		int soma = num1 + num2;
		
		JOptionPane.showMessageDialog(null, "A soma dos numeros é " + soma, "RESULTADO",
				JOptionPane.INFORMATION_MESSAGE); 
	}

}
