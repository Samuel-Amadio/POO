package control;

import view.InterfaceProdutos;

public class Main {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(() -> {
			new InterfaceProdutos().setVisible(true);
		});
		
	}

}
