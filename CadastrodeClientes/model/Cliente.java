package model;

import java.time.LocalDate;

public class Cliente {
	
	private String nome;
	private String telefone;
	private String email;
	private String sexo;	
	private int id;
	
	//-------------------------BLOCO 3 - QUESTÃO 1 ----------------------------------------------------
	private LocalDate dataCadastro;
	
	public Cliente(String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		//-------------------------BLOCO 3 - QUESTÃO 1 ----------------------------------------------------
		this.dataCadastro  = LocalDate.now();
				
	}
	
	public Cliente(int id, String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.id = id;
		//-------------------------BLOCO 3 - QUESTÃO 1 ----------------------------------------------------
		this.dataCadastro  = LocalDate.now();
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
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
