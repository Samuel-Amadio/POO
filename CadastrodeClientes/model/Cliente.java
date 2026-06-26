package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
	
	private String nome;
	private String telefone;
	private String email;
	private String sexo;	
	private int id;
	
	//BLOCO 3 - QUESTÃO 1
	private String dataCadastro;
	
	public Cliente(String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		//BLOCO 3 - QUESTÃO 1
		LocalDate localdate = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataCadastro = localdate.format(formato);
				
	}
	
	public Cliente(int id, String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.id = id;
		//BLOCO 3 - QUESTÃO 1
		LocalDate localdate = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataCadastro = localdate.format(formato);
		
	}
	
	public static String formataData(LocalDate localdata) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return localdata.format(formato);
	}
	
	
	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
