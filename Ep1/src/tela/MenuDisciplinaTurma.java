package tela;

import java.util.Scanner;
import servico.DisciplinaTurmaService;

public class MenuDisciplinaTurma {
    private DisciplinaTurmaService disciplinaTurmaService = new DisciplinaTurmaService();
    private Scanner sc;

    public MenuDisciplinaTurma(Scanner sc) {
        this.sc = sc;
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n=== MENU DISCIPLINA / TURMA ===");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Criar turma");
            System.out.println("3 - Listar turmas e alunos");
            System.out.println("4 - Salvar dados");
            System.out.println("5 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    disciplinaTurmaService.cadastrarDisciplina(sc);
                    break;
                case 2:
                    disciplinaTurmaService.criarTurma(sc);
                    break;
                case 3:
                    disciplinaTurmaService.listarTurmasEAlunos();
                    break;
                case 4:
                    disciplinaTurmaService.salvarDados();
                    break;
                case 5:
                    disciplinaTurmaService.carregarDados();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
