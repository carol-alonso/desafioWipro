package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EnderecoRequest {

    @NotNull
    @Pattern(regexp = "^\\d{5}-\\d{3}$")
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
