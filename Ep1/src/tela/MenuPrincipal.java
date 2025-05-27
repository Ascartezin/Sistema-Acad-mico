package tela;

import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner sc = new Scanner(System.in);

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA ACADÊMICO ===");
            System.out.println("1 - Modo Aluno");
            System.out.println("2 - Modo Disciplina/turma");
            System.out.println("3 - Modo Avaliação/frequência");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    MenuAluno menuAluno = new MenuAluno();
                    menuAluno.exibir(); // Use scanner interno na própria classe
                    break;
                case 2:
                    MenuDisciplinaTurma menuDisciplinaTurma = new MenuDisciplinaTurma(sc);
                    menuDisciplinaTurma.exibir();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static Scanner getScanner() {
        return sc;
    }
}

