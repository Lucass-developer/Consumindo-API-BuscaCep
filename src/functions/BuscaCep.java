package functions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;
import modelos.EnderecoJson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static functions.ListaDeEndereco.enderecoArrayList;
import static functions.ListaDeEndereco.listaDeEndereco;


public class BuscaCep {
    static Scanner scanner = new Scanner(System.in);

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static String menuBuscaCep  = """
            ======= MENU =======
            1. SALVAR ENDEREÇO
            2. BUSCAR NOVO CEP
            3. MENU PRINCIPAL
            ESCOLHA UMA OPÇÃO:
            """;

    public static boolean buscaCep(String cep) {
        String cepLink = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(cepLink)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println(json);

            EnderecoJson novoEndereco = gson.fromJson(json, EnderecoJson.class);

            if (novoEndereco.erro()) {
                System.out.println("ERRO NA BUSCA!");
                return false;
            }

            System.out.println(novoEndereco);
            System.out.println(menuBuscaCep);
            int num = scanner.nextInt();

            while (num != 3){
                switch (num) {
                    case 1: {
                        boolean cepJaSalvo = false;
                        Endereco enderecos = new Endereco(novoEndereco);

                        for (Endereco e : enderecoArrayList) {
                            if (e.getCep().equals(enderecos.getCep())) {
                                cepJaSalvo = true;
                                break;
                            }
                        }
                        if (!cepJaSalvo) {
                            enderecoArrayList.add(enderecos);
                            System.out.println("ENDEREÇO SALVO!");
                            System.out.println("VISUALIZAR ENDEREÇOS SALVOS?\n1. SIM\n2. NÃO\nESCHOLA UMA OPÇÃO:");
                            int check = scanner.nextInt();

                            if (check == 1) {
                                listaDeEndereco();
                            }
                        } else {
                            System.out.println("ESTE ENDEREÇO JA ESTA SALVO!");
                        }
                        return false;
                    }
                    case 2: {
                        return true;
                    }
                    default: {
                        System.out.println("OPÇÃO INVALIDA!");
                        System.out.println(menuBuscaCep);
                        num = scanner.nextInt();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
            return false;
        }
        return false;
    }
}


