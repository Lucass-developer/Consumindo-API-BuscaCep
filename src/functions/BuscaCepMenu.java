package functions;



import java.util.Scanner;

import static functions.BuscaCep.buscaCep;
import static functions.ListaDeEndereco.listaDeEndereco;


public class BuscaCepMenu {
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static String mainMenu = """
            ==== MENU PRINCIPAL ====
            1. BUSCAR CEP
            2. ENDEREÇOS SALVOS
            3. SAIR
            ESCOLHA UMA OPÇÃO:
            """;

    public static void menuBuscaCep(int num){
        while (num != 3) {
            switch (num) {
                case 1: {
                    System.out.println("Digite um CEP para buscar o endereço:");
                    String entrada = scanner.nextLine();
                    String cep = entrada.replaceAll("[^0-9]", "");

                    boolean check = buscaCep(cep);

                    if (!check) {
                        System.out.println(mainMenu);
                        num = scannerNum.nextInt();
                    }
                    break;
                }
                case 2: {
                    listaDeEndereco();
                    System.out.println(mainMenu);
                    num = scannerNum.nextInt();
                    break;
                }
                default: {
                    System.out.println("OPÇÃO INVALIDA!");
                    System.out.println(mainMenu);
                    num = scannerNum.nextInt();
                    break;
                }
            }
        }
    }
}
