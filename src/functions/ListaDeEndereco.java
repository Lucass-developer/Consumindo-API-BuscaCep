package functions;

import modelos.Endereco;

import java.util.ArrayList;
import java.util.Scanner;

import static functions.BuscaCepMenu.menuBuscaCep;
import static functions.JsonEnderecos.listasJson;


public class ListaDeEndereco {
    static ArrayList<Endereco> enderecoArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void listaDeEndereco(){
        int numEndereco = 1;
        int num = 1;

        String menuLista  = """
                ========== MENU ==========
                1. EXPORTAR LISTA (JSON)
                2. BUSCAR CEP
                3. EXCLUIR ENDEREÇO
                4. MENU PRINCIPAL
                ESCOLHA UMA OPÇÃO:
                """;

        if (enderecoArrayList.isEmpty()) {
            System.out.println("LISTA VAZIA!");
            return;
        }

        while (num != 4){
            System.out.println("======== ENDEREÇOS SALVOS ========");
            for (Endereco item : enderecoArrayList) {
                System.out.println(numEndereco + ":");
                System.out.println(item);
                numEndereco++;
            }
            System.out.println(menuLista);
            num = scanner.nextInt();
            switch (num) {
                case 1: {
                    listasJson(enderecoArrayList);
                    break;
                }
                case 2: {
                    num = 1;
                    menuBuscaCep(num);
                    System.out.println("OBRIGADO POR USAR O BUSCA CEP!");
                    System.exit(0);
                }
                case 3: {
                    int posicaoEndereco = -1;
                    System.out.println("DIGITE A POSIÇAO DO ENDEREÇO PARA EXCLUIR:");
                    int numCheck = scanner.nextInt();

                    if (numCheck < 0 | numCheck > enderecoArrayList.size()) {
                        System.out.println("POSIÇÃO INVALIDA!");
                    } else {
                        posicaoEndereco += numCheck;
                        enderecoArrayList.remove(posicaoEndereco);
                        System.out.println("ENDEREÇO EXCLUIDO!");
                        numEndereco = 1;
                    }
                    break;
                }
                default: {
                    if (num != 4){
                        System.out.println("OPÇÃO INVALIDA!");
                    }
                    break;
                }
            }
        }
    }
}
