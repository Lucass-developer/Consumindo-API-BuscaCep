package functions;

import modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static functions.BuscaCep.gson;

public class JsonEnderecos {
    public static void listasJson(ArrayList<Endereco> arrayList){
        try (FileWriter newExportJson = new FileWriter("Lista de Endereços.json")) {
            newExportJson.write(gson.toJson(arrayList));
            newExportJson.close();
            System.out.println("EEXPORTADO PARA JSON COM SUCESSO!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
