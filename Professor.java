package sistema_escolar;

import java.util.*;
import java.util.Scanner;

public class Professor {
	
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	
	
	public Professor(String nome) {
		this.nome = nome;
		this.disciplinas = new ArrayList<Disciplina>();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void vizualizarNotasAlunos() {
		for (Disciplina d: this.disciplinas) {
			d.verNotas();
		}
	}
	
	public void vizualizarAluno(String nomeDisciplina, Aluno aluno) {
		for (Disciplina disciplina : this.disciplinas) {
			if(disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
				aluno.vizualizarNotaDisciplina(nomeDisciplina);
			}
		}
	}
	
	public void adicionarDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);}
	
	public void addNotas(Disciplina disciplina, Aluno aluno) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nDigite a nota 1: ");
		double nota1 = entrada.nextDouble();
		System.out.println("\nDigite a nota 2: ");
		double nota2 = entrada.nextDouble();
		
		disciplina.adicionarNota(aluno, nota1, nota2);
	}
}

   


  