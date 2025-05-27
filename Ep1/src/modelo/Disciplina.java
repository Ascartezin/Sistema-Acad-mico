package modelo;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private int limiteAlunos;
    private List<String> preRequisitos; // códigos das disciplinas pré-requisito
    private List<String> alunosMatriculados; // matrícula dos alunos
    private List<Turma> turmas = new ArrayList<>(); 

    public Disciplina(String codigo, String nome, int cargaHoraria, int limiteAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
        this.preRequisitos = new ArrayList<>();
        this.alunosMatriculados = new ArrayList<>();
    }
    
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    // ---------- Getters e Setters ----------
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setLimiteAlunos(int limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }

    public List<String> getPreRequisitos() {
        return preRequisitos;
    }

    public void adicionarPreRequisito(String codigoDisciplina) {
        if (!preRequisitos.contains(codigoDisciplina)) {
            preRequisitos.add(codigoDisciplina);
        }
    }

    public List<String> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public boolean matricularAluno(String matricula) {
        if (alunosMatriculados.size() < limiteAlunos && !alunosMatriculados.contains(matricula)) {
            alunosMatriculados.add(matricula);
            return true;
        }
        return false; // matrícula falhou (limite atingido ou já matriculado)
    }

    public void removerAluno(String matricula) {
        alunosMatriculados.remove(matricula);
    }

    public boolean temPreRequisitos() {
        return !preRequisitos.isEmpty();
    }

    public boolean alunoCumprePreRequisitos(List<String> disciplinasConcluidas) {
        return disciplinasConcluidas.containsAll(preRequisitos);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", limiteAlunos=" + limiteAlunos +
                ", alunosMatriculados=" + alunosMatriculados.size() +
                '}';
    }
}
