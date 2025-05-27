package modelo;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String matricula;
    private String curso;
    private boolean especial = false;
    private List<Turma> turmasMatriculadas = new ArrayList<>();
    
    //lista de disciplinas que o aluno já concluiu
    private List<String> disciplinasConcluidas = new ArrayList<>();
    
    public void matricularEmTurma(Turma turma) {
        turmasMatriculadas.add(turma);
        System.out.println("Aluno matriculado na turma.");
    }



    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }
    
    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }
    
    public List<String> getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    // Método para adicionar uma disciplina concluída
    public void adicionarDisciplinaConcluida(String codigoDisciplina) {
        if (!disciplinasConcluidas.contains(codigoDisciplina)) {
            disciplinasConcluidas.add(codigoDisciplina);
        }
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    @Override
    public String toString() {
        return "Aluno {" +
               "Nome='" + nome + '\'' +
               ", Matrícula='" + matricula + '\'' +
               ", Curso='" + curso + '\'' +
               '}';
    }
}