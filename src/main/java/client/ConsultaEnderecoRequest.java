package client;

import javax.validation.constraints.NotBlank;

public class ConsultaEnderecoRequest {

    @NotBlank
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
