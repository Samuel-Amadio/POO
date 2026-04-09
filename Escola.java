package sistema_escolar;

import java.util.HashMap;

public class Escola {
	
	private String nome;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<String, Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(HashMap<String, Aluno> alunos) {
		this.alunos = alunos;
	}

	private HashMap<String, Aluno> alunos;
	
	public Escola() {
		this.alunos = new HashMap<String, Aluno>();
	}
	
	public void matricularAluno(Aluno aluno) {
		if(alunos.containsKey(aluno.getMatricula())) {
			System.out.println("\nMatricula ja existe");
		}
		else {
			alunos.put(aluno.getMatricula(), aluno);
			System.out.println("\nAluno matriculado");
		}
	}
	
	

}
