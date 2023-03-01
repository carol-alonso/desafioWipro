package client;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    @JsonProperty("cep")
    public String getCep() {
        return cep;
    }

    @JsonProperty("logradouro")
    public String getLogradouro() {
        return logradouro;
    }

    @JsonProperty("complemento")
    public String getComplemento() {
        return complemento;
    }

    @JsonProperty("bairro")
    public String getBairro() {
        return bairro;
    }

    @JsonProperty("localidade")
    public String getLocalidade() {
        return localidade;
    }

    @JsonProperty("uf")
    public String getUf() {
        return uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
