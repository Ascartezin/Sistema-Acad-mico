package servico;

import modelo.Disciplina;
import modelo.Turma;
import modelo.Aluno;
import controle.SistemaAcademico;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DisciplinaTurmaService {

    // Cadastrar nova disciplina com pré-requisitos
    public void cadastrarDisciplina(Scanner sc) {
        System.out.println("\n--- Cadastro de Disciplina ---");

        System.out.print("Código da disciplina: ");
        String codigo = sc.nextLine();

        if (SistemaAcademico.getDisciplinaPorCodigo(codigo) != null) {
            System.out.println("Já existe uma disciplina com esse código.");
            return;
        }

        System.out.print("Nome da disciplina: ");
        String nome = sc.nextLine();

        System.out.print("Carga horária: ");
        int cargaHoraria = Integer.parseInt(sc.nextLine());

        System.out.print("Limite de alunos: ");
        int limiteAlunos = Integer.parseInt(sc.nextLine());

        System.out.print("Quantidade de pré-requisitos: ");
        int qtdPre = Integer.parseInt(sc.nextLine());

        List<String> preRequisitos = new ArrayList<>();
        for (int i = 0; i < qtdPre; i++) {
            System.out.print("Código do pré-requisito " + (i + 1) + ": ");
            String pre = sc.nextLine();
            preRequisitos.add(pre);
        }

        Disciplina nova = new Disciplina(codigo, nome, cargaHoraria, limiteAlunos);
        for (String pre : preRequisitos) {
            nova.adicionarPreRequisito(pre);
        }

        SistemaAcademico.adicionarDisciplina(nova);
        System.out.println("Disciplina cadastrada com sucesso.");
    }

    // Criar turma vinculada a disciplina existente
    public void criarTurma(Scanner sc) {
        System.out.println("\n--- Criação de Turma ---");

        System.out.print("Código da turma: ");
        String codigoTurma = sc.nextLine();

        if (SistemaAcademico.getTurmaPorCodigo(codigoTurma) != null) {
            System.out.println("Já existe uma turma com esse código.");
            return;
        }

        System.out.print("Código da disciplina (deve estar cadastrada): ");
        String codigoDisciplina = sc.nextLine();

        Disciplina disciplina = SistemaAcademico.getDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada. Cadastre a disciplina antes de criar a turma.");
            return;
        }

        System.out.print("Nome do professor responsável: ");
        String professor = sc.nextLine();

        System.out.print("Semestre (ex: 2025.1): ");
        String semestre = sc.nextLine();

        System.out.print("Forma de avaliação (ex: prova, trabalho): ");
        String formaAvaliacao = sc.nextLine();

        System.out.print("Turma presencial? (s/n): ");
        boolean presencial = sc.nextLine().trim().equalsIgnoreCase("s");

        String sala = presencial ? pedir(sc, "Sala da turma: ") : "Remota";

        System.out.print("Horário da turma (ex: seg 19h-21h): ");
        String horario = sc.nextLine();

        System.out.print("Capacidade máxima de alunos: ");
        int capacidadeMaxima = Integer.parseInt(sc.nextLine());

        // Verificar conflito de horário na mesma disciplina
        for (Turma t : SistemaAcademico.getTurmas()) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigoDisciplina)
                    && t.getHorario().equalsIgnoreCase(horario)) {
                System.out.println("Já existe uma turma da mesma disciplina neste horário. Escolha outro horário.");
                return;
            }
        }

        // Criar turma e associar à disciplina
        Turma novaTurma = new Turma(
                codigoTurma,
                disciplina,
                professor,
                semestre,
                formaAvaliacao,
                presencial,
                sala,
                horario,
                capacidadeMaxima
        );

        SistemaAcademico.adicionarTurma(novaTurma);
        disciplina.adicionarTurma(novaTurma);
        System.out.println("Turma criada com sucesso!");
    }

    // Lista todas as turmas com alunos matriculados
    public void listarTurmasEAlunos() {
        List<Turma> turmas = SistemaAcademico.getTurmas();

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        for (Turma turma : turmas) {
            System.out.println(turma);
            List<Aluno> alunos = turma.getAlunosMatriculados();

            if (alunos.isEmpty()) {
                System.out.println("  Nenhum aluno matriculado nesta turma.");
            } else {
                System.out.println("  Alunos matriculados:");
                for (Aluno aluno : alunos) {
                    System.out.println("    - " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ")");
                }
            }
            System.out.println("-----------------------------------");
        }
    }

    // 🔜 Futuro: salvar disciplinas/turmas em arquivos
    public void salvarDados() {
        System.out.println("🔜 Funcionalidade de salvar dados (disciplinas e turmas) será implementada.");
    }

    // 🔜 Futuro: carregar disciplinas/turmas de arquivos
    public void carregarDados() {
        System.out.println("🔜 Funcionalidade de carregar dados (disciplinas e turmas) será implementada.");
    }

    private String pedir(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }
}
