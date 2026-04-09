package sistema_escolar;

import java.util.*;

public class Aluno {
	
	private String nome;
	private String matricula;
	ArrayList<Disciplina> disciplinas;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void realizarMatricula(Disciplina disciplina) {
		if(disciplinas.size() < 6) {
		disciplinas.add(disciplina);
	}
		else{
			System.out.println("\nLimite de matérias atingido");
			}
		}
	
	public double calcularMedia(double nota1, double nota2) {
		double media = (nota1 + nota2)/2;
		return media;
	}
	
	public String Conceito(double media) {
		String conceito;
		if(media>=6) {
			conceito = "Aprovado";
		}
		else {
			conceito = "Reprovado";
		}
		return conceito;
	}
	
	public void vizualizarNotaDisciplina(String nome) {
		for (Disciplina d: disciplinas) {
			if(d.getNome().equals(nome)) {
				double[] notas = d.getNotas(this);
				System.out.println("\n" + d.getNome());
				System.out.println("\nNota 1: " + notas[0]);
				System.out.println("\nNota 2:" + notas[1]);
			}
		}
	}
	
	public void vizualizarNotaDisciplina(int codigo) {
		for (Disciplina d: disciplinas) {
			if(d.getCodigo() == codigo) {
				double[] notas = d.getNotas(this);
				System.out.println("\n" + d.getNome());
				System.out.println("\nNota 1: " + notas[0]);
				System.out.println("\nNota 2:" + notas[1]);
			}
		}
	}
	

	
	public void vizualizarHistorico() {
		System.out.println("Aluno: " + this.getNome());
		for (Disciplina d: this.disciplinas) {
			System.out.println("\nCodigo: " + d.getCodigo());
			System.out.println("\nDisciplina: " + d.getNome());
			double[] notas = d.getNotas(this);
			double media = this.calcularMedia(notas[0], notas[1]);
			System.out.println("\nMedia: " + media);
			System.out.println("\nConceito: " + Conceito(media));
		}
	}
	
	
	
	
	
	
	
	
}
