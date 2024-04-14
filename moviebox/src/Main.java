import view.Entrar;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("        Bem-vindo ao Sistema     ");
        System.out.println("-----------------------------------");
        System.out.println(" Opções:                         ");
        System.out.println(" 1. Entrar                       ");
        System.out.println(" 2. Criar conta                  ");
        System.out.println(" 3. Sair                         ");
        System.out.println("-----------------------------------");
        System.out.println(" Por favor, digite o número      ");
        System.out.print(" correspondente à sua escolha: ");

        int escolha = scanner.nextInt();

    }
}