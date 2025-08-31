package modelos;

public class Endereco {
    private final String cep;
    private final String rua;
    private final String bairro;
    private final String cidade;
    private final String estado;

    public Endereco (EnderecoJson enderecoJson) {
        this.cep = enderecoJson.cep();
        this.rua = enderecoJson.logradouro();
        this.bairro = enderecoJson.bairro();
        this.cidade = enderecoJson.localidade();
        this.estado = enderecoJson.estado();
    }

    @Override
    public String toString() {
        return "CEP: " + cep + "\nNOME DA RUA: " + rua + "\nBAIRRO: " + bairro + "\nCIDADE: " + cidade + "\nESTADO: " + estado;
    }

    public String getCep() {
        return cep;
    }
}
