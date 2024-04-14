package view;

import java.util.Scanner;

public class Entrar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Imprimir o layout de entrar
        System.out.println("-----------------------------------");
        System.out.println("|             Entrar              |");
        System.out.println("-----------------------------------");
        System.out.println("| Nome de usuário:                |");
        System.out.println("| Senha:                          |");
        System.out.println("-----------------------------------");
        System.out.println("| Opções:                         |");
        System.out.println("| 1. Entrar                       |");
        System.out.println("| 2. Voltar                       |");
        System.out.println("-----------------------------------");
        System.out.println("| Digite o número correspondente  |");
        System.out.println("| à sua escolha:                  |");
        System.out.println("-----------------------------------");

        // Ler a escolha do usuário
        int escolha = scanner.nextInt();

        // Processar a escolha do usuário
        switch (escolha) {
            case 1:
                // Lógica para entrar
                break;
            case 2:
                // Lógica para voltar
                break;
            default:
                System.out.println("Escolha inválida. Por favor, tente novamente.");
        }

        scanner.close();
    }

}
