package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
	
	/*public ClienteDAO() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nome TEXT NOT NULL, "
                   + "telefone TEXT NOT NULL, "
                   + "email TEXT NOT NULL, "
                   + "sexo TEXT NOT NULL"
                   + ");";
                   
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.execute();
            
        } catch (Exception e) {
            System.err.println("Erro ao inicializar a tabela de clientes: " + e.getMessage());
        }
    }*/
	
	
	//-------------------------BLOCO 2 - QUESTÃO 1 ----------------------------------------------------
	public void inserir(Cliente cliente) throws Exception {
		String sql = "INSERT INTO clientes "
				+ "(nome, telefone, email, sexo) VALUES (?,?,?,?)";	
		
		try {
			Connection conexao = Conexao.conectar();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSexo());
			stmt.execute();
			
			stmt.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new Exception("Falha na conexão!");
		}
	}
	
	public void excluir(int id) throws Exception {
		String sql = "DELETE FROM clientes WHERE id=?";
		try {
			Connection conexao = Conexao.conectar();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			stmt.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new Exception("Falha na conexão!");
		}
	}
	
	public ArrayList<Cliente> listar() throws Exception {
		String sql = "SELECT * FROM clientes";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Connection conexao = Conexao.conectar();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String sexo = resultSet.getString("sexo");
				int id = resultSet.getInt("id");
				Cliente cliente = new Cliente(id, nome, telefone, email, sexo);
				clientes.add(cliente);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new Exception("Falha na conexão!");
		}
		return clientes;
	}
	
	public void atualizar(Cliente cliente) throws Exception {
		String sql = "UPDATE clientes SET nome=?, "
				+ "telefone=?, email=?, sexo=? WHERE id=?";
		try {
			Connection conexao = Conexao.conectar();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSexo());
			stmt.setInt(5, cliente.getId());
			stmt.executeUpdate();
			stmt.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new Exception("Falha na conexão!");
		}
	}
	
	//-------------------------BLOCO 5 - QUESTÃO 1 ----------------------------------------------------
	public ArrayList<Cliente> buscaPorNome(String nome) throws SQLException{
		String sql = "SELECT * FROM clientes WHERE nome LIKE ?" ;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try(Connection conexao = Conexao.conectar(); 
			PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, "%" + nome + "%");
			try(ResultSet resultset = stmt.executeQuery()){
				while(resultset.next()) {
					int id = resultset.getInt("id");
					String n = resultset.getString("Nome");
					String t = resultset.getString("Telefone");
					String e = resultset.getString("Email");
					String s = resultset.getString("Sexo");
					lista.add(new Cliente(id, n, t, e, s));
				}
			}
			
		}
		return lista;
	}
	
	//-------------------------BLOCO 5 - QUESTÃO 3 ----------------------------------------------------
	public ArrayList<Cliente> buscaporPeriodo(LocalDate dataInicial, LocalDate dataFinal) throws SQLException{
		String sql = "SELECT * FROM clientes WHERE data_cadastro BETWEEN ? AND ?";
		ArrayList<Cliente> lista = new ArrayList<>();
		try (Connection conexao = Conexao.conectar();
			PreparedStatement stmt = conexao.prepareStatement(sql)){
			if(conexao == null) throw new SQLException("Não foi possível estabelecer conexão com o banco de dados");
			
			stmt.setString(1, dataInicial.toString());
			stmt.setString(2, dataFinal.toString());
			try(ResultSet resultSet = stmt.executeQuery()){
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String n = resultSet.getString("Nome");
					String t = resultSet.getString("Telefone");
					String e = resultSet.getString("Email");
					String s = resultSet.getString("Sexo");
					lista.add(new Cliente(id, n, t, e, s));
				}
			}
			
		}
		
		
		
		return lista;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
