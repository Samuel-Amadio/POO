package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;



public class InterfaceProdutos extends JFrame{
	
	private JTextField txtNome, txtCodigo, txtPreco, txtBusca;
	private JComboBox<String> comboCategoria;
	private JTable tabela;
	private DefaultTableModel modeloTabela;
	private List<modelo.Produto> listaProdutos = new ArrayList<>();
	
	public InterfaceProdutos() {
		
		//cabeçalho 
		setTitle("Sistema de Cadastro de Produtos");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		
		JPanel painelTopo = new JPanel();
		JLabel lblTitulo = new JLabel("Cadastro de Produtos");
		lblTitulo.setFont(new Font ("Arial", Font.BOLD, 24));
		painelTopo.add(lblTitulo);
		add(painelTopo, BorderLayout.NORTH);
		
		
		
		//entrada e saída
		JPanel painelcampos = new JPanel(new GridLayout(4, 2, 5, 5));
		painelcampos.setBorder(BorderFactory.createTitledBorder("Dados do Produto"));
		
		painelcampos.add(new JLabel("Nome: "));
		txtNome = new JTextField();
		painelcampos.add(txtNome);
		
		painelcampos.add(new JLabel("Codigo: "));
		txtCodigo = new JTextField();
		painelcampos.add(txtCodigo);
		
		painelcampos.add(new JLabel("Preço: "));
		txtPreco = new JTextField();
		painelcampos.add(txtPreco);
		
		painelcampos.add(new JLabel("Categoria: "));	
		String [] categorias = {"selecione...", "Alimentício", "Limpeza", "Higiene", "Bebidas", "Hortifruti", 
                "Padaria", "Açougue", "Congelados", "Eletrônicos", "Papelaria", "Vestuário", "Outros"};
		comboCategoria = new JComboBox<>(categorias);
		painelcampos.add(comboCategoria);
		
		
		//painel de ações
		JPanel painelacoes = new JPanel(new FlowLayout());
		JButton btnSalvar = new JButton("Salvar");
		JButton btnExcluir = new JButton("Excluir");
		txtBusca = new JTextField(15);
		JButton btnBuscar = new JButton("Buscar");
		
		painelacoes.add(btnSalvar);
		painelacoes.add(btnExcluir);
		painelacoes.add(new JLabel(" Pesquisar:"));	
		painelacoes.add(txtBusca);
		painelacoes.add(btnBuscar);
		
		//
		JPanel painelcentral = new JPanel(new BorderLayout());
		painelcentral.add(painelcampos, BorderLayout.NORTH);
		painelcentral.add(painelacoes, BorderLayout.SOUTH);
		add(painelcentral, BorderLayout.CENTER);
		
		//tabelas
		String [] colunas = {"Nome", "Código", "Preço", "Categoria"};
		modeloTabela = new DefaultTableModel(colunas, 0);
		tabela = new JTable(modeloTabela);
		//add(new JScrollPane(tabela), BorderLayout.SOUTH);
		
		JPanel painelTabela = new JPanel(new BorderLayout());
		painelTabela.setPreferredSize(new Dimension(700, 250));
		painelTabela.add(new JScrollPane(tabela), BorderLayout.CENTER);
		
		add(painelTabela, BorderLayout.SOUTH);
		
		//ações
		btnSalvar.addActionListener(e -> salvarProduto());
		btnExcluir.addActionListener(e -> excluirProduto());
		btnBuscar.addActionListener(e -> buscarProduto());
		
	}
	
	private void salvarProduto() {
		
		String nome = txtNome.getText().trim(); 
		String precoStr = txtPreco.getText().trim();
		String codigo  =txtCodigo.getText().trim();
		int indexCat = comboCategoria.getSelectedIndex();
		
		if(nome.isEmpty() || precoStr.isEmpty() || codigo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Todos os campos precisam ser preenchidos");
			return;
		}
		if(indexCat == 0) {
			JOptionPane.showMessageDialog(this, "Selecione uma categoria válida");
			return;
		}
		
		try {
			double preco = Double.parseDouble(precoStr.replace(",", ".")); 
			modelo.Produto p = new modelo.Produto(nome, codigo, preco, comboCategoria.getSelectedItem().toString());
			listaProdutos.add(p);
			atualizarTabela(listaProdutos);
			limparCampos();
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "O preco deve ser um valor numérico");
		}
	}
	
	private void excluirProduto() {
		int linhaSelecionada = tabela.getSelectedRow();
		
		if(linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(this, "Selecione um produto da tabela para excluir");
			return;
		}
		
		String nomeRemover = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
		listaProdutos.removeIf(p-> p.getNome().equals(nomeRemover));
		
		atualizarTabela(listaProdutos);
	}
	
	private void buscarProduto() {
		String busca = txtBusca.getText().toLowerCase().trim();
		if(busca.isEmpty()) {
			atualizarTabela(listaProdutos);
			return;
		}
		
		List<modelo.Produto> filtrados = new ArrayList<>();
		for(modelo.Produto p : listaProdutos) {
			if(p.getNome().toLowerCase().contains(busca)) {
				filtrados.add(p);
			}
		}
		
		atualizarTabela(filtrados);
	}
	
	private void atualizarTabela(List<modelo.Produto> lista) {
		modeloTabela.setNumRows(0);
		for(modelo.Produto p : lista) {
			modeloTabela.addRow(new Object [] {p.getNome(), p.getCodigo(), String.format("%.2f", p.getPreco()), p.getCategoria()});
		}
		
	}
	
	private void limparCampos() {
		txtNome.setText("");
		txtPreco.setText("");
		txtCodigo.setText("");
		comboCategoria.setSelectedIndex(0);

	}
}
