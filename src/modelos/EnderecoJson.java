package modelos;

public record EnderecoJson(String cep, String logradouro, String bairro, String localidade, String estado, boolean erro) {
    @Override
    public String toString() {
        return "============= INFORMAÇOES ============="
                + "\nCEP: " + cep()
                + "\nNOME DA RUA: " + logradouro()
                + "\nBAIRRO: " + bairro()
                + "\nCIDADE: " + localidade()
                + "\nESTADO: " + estado();
    }
}
