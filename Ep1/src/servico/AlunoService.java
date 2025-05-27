package servico;

import java.util.List;
import java.util.Scanner;

import modelo.Aluno;
import modelo.AlunoEspecial;
import controle.SistemaAcademico;
import modelo.Turma;

public class AlunoService {

    // Remover a lista local para evitar inconsistências
    // private List<Aluno> alunos = new ArrayList<>();

    // Cadastrar novo aluno com verificação de matrícula duplicada
    public void cadastrarAluno(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        if (buscarPorMatricula(matricula) != null) {
            System.out.println("Erro: já existe um aluno com essa matrícula.");
            return;
        }

        System.out.print("Curso: ");
        String curso = sc.nextLine();

        System.out.print("É aluno especial? (s/n): ");
        String especial = sc.nextLine().trim().toLowerCase();

        Aluno novoAluno = especial.equals("s")
                ? new AlunoEspecial(nome, matricula, curso)
                : new Aluno(nome, matricula, curso);

        // Adiciona no sistema acadêmico, que mantém a lista principal
        SistemaAcademico.adicionarAluno(novoAluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Listagem simples de alunos
    public void listarAlunos() {
        List<Aluno> alunos = SistemaAcademico.getAlunos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }
    }

    // Edição de nome e curso
    public void editarAluno(Scanner sc) {
        System.out.print("Digite a matrícula do aluno que deseja editar (ou 'voltar' para sair): ");
        String matricula = sc.nextLine();

        if (matricula.equalsIgnoreCase("voltar")) return;

        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Aluno encontrado: " + aluno.getNome());

        System.out.print("Deseja editar o nome? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Novo nome: ");
            aluno.setNome(sc.nextLine());
        }

        System.out.print("Deseja editar o curso? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Novo curso: ");
            aluno.setCurso(sc.nextLine());
        }

        System.out.println("Dados atualizados com sucesso.");
    }

    public void matricularAluno(Scanner sc) {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = sc.nextLine();

        Aluno aluno = SistemaAcademico.getAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (SistemaAcademico.getTurmas().isEmpty()) {
            System.out.println("Nenhuma turma disponível no sistema.");
            return;
        }

        System.out.println("Turmas disponíveis:");
        for (Turma turma : SistemaAcademico.getTurmas()) {
            System.out.println(turma);
        }

        System.out.print("Digite o código da turma para matrícula: ");
        String codigoTurma = sc.nextLine();

        Turma turma = SistemaAcademico.getTurmaPorCodigo(codigoTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        boolean sucesso = turma.matricularAluno(aluno);
        if (sucesso) {
            System.out.println("Aluno matriculado com sucesso na turma " + turma.getCodigo() + ".");
        } else {
            System.out.println("Não foi possível matricular o aluno na turma.");
        }
    }

    public void trancarDisciplina(Scanner sc) {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = sc.nextLine();

        Aluno aluno = SistemaAcademico.getAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        List<Turma> turmasMatriculadas = aluno.getTurmasMatriculadas();

        if (turmasMatriculadas.isEmpty()) {
            System.out.println("Aluno não está matriculado em nenhuma turma.");
            return;
        }

        System.out.println("Turmas em que o aluno está matriculado:");
        for (int i = 0; i < turmasMatriculadas.size(); i++) {
            Turma t = turmasMatriculadas.get(i);
            System.out.println((i + 1) + " - " + t.getCodigo() + " | " + t.getDisciplina().getNome());
        }

        System.out.print("Digite o número da turma que deseja trancar: ");
        int opcao;
        try {
            opcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }

        if (opcao < 1 || opcao > turmasMatriculadas.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Turma turmaSelecionada = turmasMatriculadas.get(opcao - 1);

        // Remove aluno da turma
        turmaSelecionada.removerAluno(aluno);

        System.out.println("Disciplina/trurma " + turmaSelecionada.getCodigo() + " trancada com sucesso para o aluno " + aluno.getNome() + ".");
    }

    // A ser implementado: serialização ou arquivo texto
    public void salvarDados() {
        System.out.println("Salvar dados ainda será implementado.");
    }

    // A ser implementado: desserialização ou leitura de arquivo
    public void carregarDados() {
        System.out.println("Carregar dados ainda será implementado.");
    }

    // Busca aluno pela matrícula usando o SistemaAcademico (fonte única de dados)
    private Aluno buscarPorMatricula(String matricula) {
        return SistemaAcademico.getAlunoPorMatricula(matricula);
    }
}
