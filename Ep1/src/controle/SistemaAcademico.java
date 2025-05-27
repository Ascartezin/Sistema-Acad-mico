package controle;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Turma;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();

    // Alunos
    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public static Aluno getAlunoPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) 
            	return a;
        }
        return null;
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    // Disciplinas
    public static void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public static Disciplina getDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) return d;
        }
        return null;
    }

    public static List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    // Turmas
    public static void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public static Turma getTurmaPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) return t;
        }
        return null;
    }

    public static List<Turma> getTurmas() {
        return turmas;
    }

    // TODO: salvarDados() e carregarDados() com serialização
}
