package sistema_escolar;

import java.util.HashMap;

public class Disciplina {
	
	private String nome;
	Professor professor;
	private int codigo;
	private HashMap<Aluno, double[]> alunos;
	
	
	public Disciplina(String nome, int codigo, Professor professor) {
		this.nome = nome;
		this.professor = professor;
		this.codigo = codigo;
		this.alunos = new HashMap<Aluno, double[]>();
		professor.adicionarDisciplina(this);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public HashMap<Aluno, double[]> getAlunos() {
		return alunos;
	}
	public void setAlunos(HashMap<Aluno, double[]> alunos) {
		this.alunos = alunos;
	}
	
	public void listarAlunos() {
		for(Aluno a: alunos.keySet()){
			System.out.println("\nNome:" + a.getNome());
		}
	}
	
	public void adicionarNota(Aluno aluno, double nota1, double nota2) {
		double notas[] = {nota1, nota2};
		this.alunos.put(aluno, notas);
	}
	
	public void verNotas() {
		for(Aluno a: alunos.keySet()) {
			double[] notas = alunos.get(a);
			System.out.println("\n" + a.getNome() + "| Matricula: " + a.getMatricula() + 
					" | Nota1: " + notas[0] + " | Nota 2: " + notas[1]);
		}
	}
	
	public double[] getNotas(Aluno aluno) {
		return alunos.get(aluno);
	}
	
	
	
	
}
