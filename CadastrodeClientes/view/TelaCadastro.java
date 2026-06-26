package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import util.Regex;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ClienteTableModel;
import util.DadosMockados;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import dao.ClienteDAO;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TelaCadastro extends JFrame implements Validacao{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textBuscar;
	private JTable table;
	private ClienteTableModel modelo;
	private ArrayList<Cliente> clientes;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private ClienteDAO dao;
	private final DateTimeFormatter BR_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // [cite: 70]
	
	// Bloco 5 - Q2
    private JTextField textDataInicial;
    private JTextField textDataFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		
		dao = new ClienteDAO();
		clientes = new ArrayList<Cliente>();
		
		
		clientes = DadosMockados.getDados();
		try {
		modelo = new ClienteTableModel(dao.listar());
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(TelaCadastro.this, e.getMessage(),
						"Alerta", JOptionPane.WARNING_MESSAGE);
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = new ImageIcon(TelaCadastro.class.getResource("/img/cadastro.png"));
		Image imageScaled = image.getImage();
		Image novaImg = imageScaled.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(novaImg));
		lblNewLabel.setBounds(23, 35, 112, 92);
		contentPane.add(lblNewLabel);*/
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO DE CLIENTES");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(280, 63, 209, 24);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 127, 690, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(12, 29, 339, 35);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(12, 99, 339, 35);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(393, 29, 285, 35);
		panel.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(12, 12, 60, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(12, 80, 60, 17);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(394, 12, 60, 17);
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(393, 99, 285, 35);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(new Color(255, 255, 255));
		rdbtnMasculino.setBounds(0, 8, 130, 25);
		panel_2.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBackground(new Color(255, 255, 255));
		rdbtnFeminino.setBounds(155, 8, 130, 25);
		panel_2.add(rdbtnFeminino);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFeminino);
		buttonGroup.add(rdbtnMasculino);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 299, 690, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		//ButtonAction action = new ButtonAction();
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText().toString();
				String email = textEmail.getText().toString();
				String telefone = textTelefone.getText().toString();
				String sexo = rdbtnMasculino.isSelected() ? "Masculino" : "Feminino";
				if (nome.isBlank() || email.isBlank() || telefone.isBlank() 
						|| sexo.isBlank()) {
					JOptionPane.showMessageDialog(TelaCadastro.this, 
							"Preencha todos os campos", "Alerta", 
							JOptionPane.WARNING_MESSAGE);
				}else if (!Regex.RegexNome(nome)) {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Preencha o nome apenas com letras, espaços e acentos!",
							"Alerta", JOptionPane.WARNING_MESSAGE);
				}else if(!Regex.RegexEmail(email)) {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Preencha o e-mail com um formato aceitavel!",
							"Alerta", JOptionPane.WARNING_MESSAGE);
				}else if (!Regex.RegexTelefone(telefone)) {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Preencha o telefone com este formato: (00) 00000-0000",
							"Alerta", JOptionPane.WARNING_MESSAGE);
				}else {
					Cliente cliente = new Cliente(nome, telefone, email, sexo);
					modelo.addCliente(cliente);	
					try {
						dao.inserir(cliente);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(TelaCadastro.this, ex.getMessage(),
								"Alerta", JOptionPane.WARNING_MESSAGE);
					}
					
					JOptionPane.showMessageDialog(TelaCadastro.this, 
							"Cliente adicionado com sucesso!", "Sucesso!", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				textNome.setText("");
				textTelefone.setText("");
				textEmail.setText("");
				buttonGroup.clearSelection();
				
			}
			
		});
		btnSalvar.setBounds(23, 25, 105, 27);
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = table.getSelectedRow();
				if (indice >= 0) {
					Cliente cliente = modelo.getCliente(indice);
					try {
						dao.excluir(cliente.getId());
					}catch(Exception e) {
						JOptionPane.showMessageDialog(TelaCadastro.this, e.getMessage(),
								"Alerta", JOptionPane.WARNING_MESSAGE);
					}
					
					modelo.removerCliente(indice);
				}else {
					JOptionPane.showMessageDialog(TelaCadastro.this, "Selecione um cliente antes de continuar.",
							"Alerta", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnExcluir.setBounds(153, 25, 105, 27);
		panel_1.add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscarNome = textBuscar.getText().toString();
				if (!buscarNome.isBlank()) {
					int indice = modelo.buscarCliente(buscarNome);
					table.setRowSelectionInterval(indice, indice);
				}
			}
		});
		btnBuscar.setBounds(278, 25, 105, 27);
		panel_1.add(btnBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(409, 25, 269, 27);
		panel_1.add(textBuscar);
		textBuscar.setColumns(10);
		
		//-------------------------BLOCO 5 - QUESTÃO 2  FILTRO DE DATAS----------------------------------------------------
       /* JPanel panelFiltroData = new JPanel();
        panelFiltroData.setBounds(23, 315, 690, 50);
        contentPane.add(panelFiltroData);
        panelFiltroData.setLayout(null);

        panelFiltroData.add(new JLabel("Data Inicial:")).setBounds(12, 15, 90, 17);
        textDataInicial = new JTextField();
        textDataInicial.setBounds(100, 10, 110, 28);
        panelFiltroData.add(textDataInicial);

        panelFiltroData.add(new JLabel("Data Final:")).setBounds(230, 15, 80, 17);
        textDataFinal = new JTextField();
        textDataFinal.setBounds(310, 10, 110, 28);
        panelFiltroData.add(textDataFinal);

        JButton btnFiltrarData = new JButton("Filtrar por Data");
        btnFiltrarData.setBounds(440, 9, 238, 30);
        panelFiltroData.add(btnFiltrarData);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 395, 690, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 737, 23);
		contentPane.add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArquivo.add(mntmAbrir);
		mntmAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				if (jFileChooser.showOpenDialog(TelaCadastro.this) 
						== JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					carregarDados(file, modelo);
						
				}
				
			}
		});
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);
		mntmSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				if (jFileChooser.showSaveDialog(TelaCadastro.this) 
						== JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					salvarDados(file, modelo);
				}
				
			}
		});
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
		
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
	    mnEditar.add(mntmAtualizar);
	    mntmAtualizar.addActionListener(arg0 -> {
			try {
				executarAtualizacao();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);
		JMenuItem mtnmImpotar = new JMenuItem("Importar CSV validado");
				//ADICIONAR AÇÃO AQUI
		
		JMenuItem mntmValidarDados = new JMenuItem("Validar dados");
		mnFerramentas.add(mntmValidarDados);
		//ADICIONAR AÇÃO AQUI
		
		JMenuItem mtnmExportar = new JMenuItem("Exportar relatório");
			//ADICIONAR AÇÃO AQUI

		mnFerramentas.add(mtnmExportar);
		mnFerramentas.add(mtnmImpotar);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
	}
	
	      //-------------------------BLOCO 4 - QUESTÃO 4 ----------------------------------------------------

	public boolean validarCliente(Cliente cliente) {
		return validarCliente(
		        cliente.getNome(), 
		        cliente.getTelefone(), 
		        cliente.getEmail(), 
		        cliente.getSexo()
		    );
	}

		      //-------------------------BLOCO 5 - QUESTÃO 4 ----------------------------------------------------
	 private void executarFiltroPorData() {
	        String iniStr = textDataInicial.getText().trim();
	        String fimStr = textDataFinal.getText().trim();

	        
	        if (iniStr.isEmpty() || fimStr.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Informe as duas datas para realizar a consulta.", "Filtro", JOptionPane.WARNING_MESSAGE); 
	            return;
	        }

	        try {
	            LocalDate dataInicial = LocalDate.parse(iniStr, BR_FORMATTER);
	            LocalDate dataFinal = LocalDate.parse(fimStr, BR_FORMATTER);

	            if (dataInicial.isAfter(dataFinal)) {
	                JOptionPane.showMessageDialog(this, "Data inicial não pode ser maior que a data final.", "Erro", JOptionPane.ERROR_MESSAGE); 
	                return;
	            }

	          
	            ArrayList<Cliente> listagemPeriodo = dao.buscaporPeriodo(dataInicial, dataFinal);
	            modelo.atualizarTabela(listagemPeriodo); 

	        } catch (DateTimeParseException ex) {
	            JOptionPane.showMessageDialog(this, "Formato de data inválido. Utilize dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE); 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 
	 private void executarAtualizacao() throws Exception {
	        int linha = table.getSelectedRow();
	      //-------------------------BLOCO 2 - QUESTÃO 4 ----------------------------------------------------
	        if (linha < 0) {
	            JOptionPane.showMessageDialog(TelaCadastro.this, "Selecione um cliente antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE); // [cite: 53]
	            return;
	        }
	        Cliente cliente = modelo.getCliente(linha);
	        TelaAtualizar dialogo = new TelaAtualizar(TelaCadastro.this, cliente);
	        dialogo.setVisible(true);
	        
	        if (dialogo.getClienteEditado() != null) {
	            try {
	                dao.atualizar(dialogo.getClienteEditado());
	                modelo.atualizarTabela(dao.listar());
	                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
	            } catch (SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
	    }
	
	
	//-------------------------BLOCO 4 - QUESTÃO 4 ----------------------------------------------------
	private void exportarReltorio(File arquivo) {
		try {
			ArrayList<Cliente> todos = dao.listar();
			int masc =0; int fem = 0;
			for(Cliente c : todos) {
				if(c.getSexo().equalsIgnoreCase("Masculino"))masc++;
				else if(c.getSexo().equalsIgnoreCase("Feminino"))fem++;
			}
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo)) ){
				 writer.write("RELATÓRIO DE CLIENTES"); writer.newLine();
				 writer.write("Data da geração:" + LocalDate.now().format(BR_FORMATTER)); writer.newLine();
				 writer.write("Total de clientes: " + todos.size()); writer.newLine(); 
	             writer.write("Masculino: " + masc); writer.newLine(); 
	             writer.write("Feminino: " + fem); writer.newLine(); 
	             writer.write("----------------------------------------"); writer.newLine();
	             
	             for(Cliente c : todos) {
	            	 writer.write("Nome: " + c.getNome());writer.newLine();
	            	 writer.write("Telefone: " + c.getTelefone());writer.newLine();
	            	 writer.write("Email: " + c.getEmail());writer.newLine();
	            	 writer.write("Sexo: " + c.getSexo());writer.newLine();
	            	 writer.write("Data de cadastro: " + c.getDataCadastro());writer.newLine();
	            	 writer.write("-----------------");writer.newLine();
	             }
	             JOptionPane.showMessageDialog(this, "Relatório exportado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				 
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(TelaCadastro.this, "Erro ao exportar relatório", "Erro", JOptionPane.ERROR_MESSAGE);
		}
			
		}
	
	//BLOCO 4 - QUESTÃO 4
	private void importarCSVValidado(File arquivo) {
		int aceitos =0; int rejeitados = 0;
		
		 try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			 String cabecalho = reader.readLine();
			 if(cabecalho == null) {
				 JOptionPane.showMessageDialog(this, "O arquivo selecionado está vazio", "Erro", JOptionPane.WARNING_MESSAGE);
			 return;
			 }
			 
			 String linha;
			 boolean linhasValidadas = false;
			 while ((linha = reader.readLine()) != null) {
	                if (linha.isBlank()) continue;
	                String[] campos = linha.split(",");
	                
	                if (campos.length != 4) { 
	                    rejeitados++;
	                    continue;
	                }
	                
	          String nome = campos[0].trim();
	          String telefone = campos[1].trim();
	          String email = campos[2].trim();
	          String sexo = campos[3].trim();
	          
	          if(validarCliente(nome, telefone, email, sexo)) {
	        	  Cliente c = new Cliente(nome, telefone, email, sexo);
	        	 
	        	  try{
	        		  dao.inserir(c);
	        	  
	        	  aceitos++;
	        	  linhasValidadas = true;
	        	  }catch(Exception e) {
	        		  JOptionPane.showMessageDialog(TelaCadastro.this, e.getMessage(),
								"Alerta", JOptionPane.WARNING_MESSAGE);
	        	  }
	          }else {
	        	  rejeitados++;
	          }
	          
			 }
	          
	          if(!linhasValidadas && rejeitados > 0) {
	        	  JOptionPane.showMessageDialog(this, "O arquivo contém linhas em formato inválido", "Erro", JOptionPane.WARNING_MESSAGE);
	          }else {
	        	  try { modelo.atualizarTabela(dao.listar());
	                String msg = "Importação concluída.\nRegistros importados: " + aceitos + "\nRegistros rejeitados: " + rejeitados; 
	                JOptionPane.showMessageDialog(this, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	        	  }catch(Exception e) {
	        		  JOptionPane.showMessageDialog(TelaCadastro.this, e.getMessage(),
								"Alerta", JOptionPane.WARNING_MESSAGE);
	        	  }
	          }
	          
	          
			 
			 
		 }catch(IOException e) {
			 JOptionPane.showMessageDialog(this, "Erro de leitura do arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			
		 }
	}
	
	
	
	private void salvarDados(File file, ClienteTableModel modelo) {
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Nome,Telefone,Email,Sexo");
			bufferedWriter.newLine();
			for (int i=0; i < modelo.getRowCount(); i++) {
				String nome = (String) modelo.getValueAt(i, 0);
				String telefone = (String) modelo.getValueAt(i, 1);
				String email = (String) modelo.getValueAt(i, 2);
				String sexo = (String) modelo.getValueAt(i, 3);
				bufferedWriter.write(nome+","+telefone +
				","+email+","+sexo);
				bufferedWriter.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(TelaCadastro.this, "Falha na criação do arquivo.",
					"Alerta", JOptionPane.WARNING_MESSAGE);
		}finally {
			try {				
				bufferedWriter.close();
				fileWriter.close();
			}catch(IOException e) {
				e.printStackTrace();
				
				JOptionPane.showMessageDialog(TelaCadastro.this, "Falha em encerrar a criação do arquivo.",
						"Alerta", JOptionPane.WARNING_MESSAGE);
			}
		}}
	
	private void carregarDados(File file, ClienteTableModel modelo) {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			modelo.limparDados();
			bufferedReader.readLine();
			String linha = "";
			while((linha = bufferedReader.readLine()) != null) {
				String campos [] = linha.split(",");
				if (campos.length == 4) {
					String nome = campos[0];
					String telefone = campos[1];
					String email = campos[2];
					String sexo = campos[3];
					Cliente cliente = new Cliente(nome, telefone, email, sexo);
					modelo.addCliente(cliente);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(TelaCadastro.this, "Falha na leitura do arquivo.",
					"Alerta", JOptionPane.WARNING_MESSAGE);
		}finally {
			try {
				bufferedReader.close();
				fileReader.close();				
			}catch(IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(TelaCadastro.this, "Falha ao fechar o arquivo.",
						"Alerta", JOptionPane.WARNING_MESSAGE);
			}
		}		
		
	}
	

}

	
	
	
	
	
