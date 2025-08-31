package main;

import java.util.Scanner;

import static functions.BuscaCepMenu.menuBuscaCep;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                 ====== MENU ======
                1. BUCAR ENDEREÇO
                2. SAIR
                ESCOLHA UMA OPÇÃO:
                """;

        System.out.println("**** BUSCACEP ****");
        System.out.println(menu);
        int num = scanner.nextInt();
        boolean loopCheck = true;

        while (loopCheck) {
            switch (num) {
                case 1: {
                    menuBuscaCep(num);
                    System.out.println("OBRIGADO POR USAR O BUSCA CEP!");
                    loopCheck = false;
                    break;
                }
                case 2: {
                    System.out.println("OBRIGADO POR USAR O BUSCA CEP!");
                    loopCheck = false;
                    break;
                }
                default: {
                    System.out.println("OPÇÃO INVALIDA!!!");
                    System.out.println(menu);
                    num = scanner.nextInt();
                    break;
                }
            }
        }
    }
}
