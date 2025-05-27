package tela;

import java.util.Scanner;
import servico.AlunoService;

public class MenuAluno {

    private AlunoService alunoService = new AlunoService();

    public void exibir() {
        Scanner sc = MenuPrincipal.getScanner(); //reutiliza o scanner compartilhado
        int opcao;

        do {
            System.out.println("\n--- MODO ALUNO ---");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Editar aluno");
            System.out.println("3 - Listar alunos");
            System.out.println("4 - Matricular aluno");
            System.out.println("5 - Trancar disciplina");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Digite o respectivo número da opção do menu que deseja acessar: ");

            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> alunoService.cadastrarAluno(sc);
                case 2 -> alunoService.editarAluno(sc);
                case 3 -> alunoService.listarAlunos();
                case 4 -> alunoService.matricularAluno(sc);
                case 5 -> alunoService.trancarDisciplina(sc);
                case 6 -> alunoService.salvarDados();
                case 7 -> alunoService.carregarDados();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
