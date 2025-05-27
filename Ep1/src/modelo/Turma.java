package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private Disciplina disciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao;
    private boolean presencial;
    private String sala;  // pode ser null se remota
    private String horario;
    private int capacidadeMaxima;
    private int vagasDisponiveis;
    private List<Aluno> alunosMatriculados;

    public Turma(String codigo, Disciplina disciplina, String professor, String semestre,
                 String formaAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = sala;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.vagasDisponiveis = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Getters (e setters se desejar)
    public String getCodigo() { return codigo; }
    public Disciplina getDisciplina() { return disciplina; }
    public String getProfessor() { return professor; }
    public String getSemestre() { return semestre; }
    public String getFormaAvaliacao() { return formaAvaliacao; }
    public boolean isPresencial() { return presencial; }
    public String getSala() { return sala; }
    public String getHorario() { return horario; }
    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public int getVagasDisponiveis() { return vagasDisponiveis; }
    public List<Aluno> getAlunosMatriculados() { return alunosMatriculados; }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.contains(aluno)) {
            System.out.println("Aluno já está matriculado nesta turma.");
            return false;
        }

        if (vagasDisponiveis <= 0) {
            System.out.println("Não há vagas disponíveis na turma.");
            return false;
        }

        if (disciplina.temPreRequisitos() && !disciplina.alunoCumprePreRequisitos(aluno.getDisciplinasConcluidas())) {
            System.out.println("Aluno não cumpre os pré-requisitos para a disciplina.");
            return false;
        }

        if (aluno instanceof AlunoEspecial && aluno.getTurmasMatriculadas().size() >= 2) {
            System.out.println("Aluno especial já está matriculado em 2 turmas.");
            return false;
        }

        alunosMatriculados.add(aluno);
        aluno.getTurmasMatriculadas().add(this);
        vagasDisponiveis--;
        System.out.println("Aluno matriculado com sucesso.");
        return true;
    }

    public void removerAluno(Aluno aluno) {
        if (alunosMatriculados.remove(aluno)) {
            aluno.getTurmasMatriculadas().remove(this);
            vagasDisponiveis++;
        }
    }

    @Override
    public String toString() {
        return "Turma: " + codigo +
               " | Disciplina: " + disciplina.getNome() +
               " | Professor: " + professor +
               " | Semestre: " + semestre +
               " | Avaliação: " + formaAvaliacao +
               " | Presencial: " + (presencial ? "Sim" : "Não") +
               (presencial ? " | Sala: " + sala : "") +
               " | Horário: " + horario +
               " | Vagas disponíveis: " + vagasDisponiveis +
               " | Matriculados: " + alunosMatriculados.size();
    }
}
