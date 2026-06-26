package dao;

import java.sql.Connection;
import dao.ClienteDAO;

public class TestarConexao {

	public static void main(String[] args) {
		Connection conexao = Conexao.conectar();
		ClienteDAO dao = new ClienteDAO();
		
				
		if (conexao != null) {
			System.out.println("\nCOnectado com sucesso");
		}else {
			System.out.println("\nErro ao se conectar com o banco");
		}
		try {
			dao.excluir(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
