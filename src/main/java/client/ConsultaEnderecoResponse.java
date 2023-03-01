package client;

import java.math.BigDecimal;

import model.Endereco;

public class ConsultaEnderecoResponse {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;
    
    

    public void setFrete(double frete) {
        this.frete = Double.valueOf(frete);
    }

    public ConsultaEnderecoResponse(String cep, String rua, String complemento, String bairro, String cidade,
			String estado, Double frete) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.frete = frete;
	}

	public ConsultaEnderecoResponse() {
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public void setFrete(BigDecimal frete) {
        this.frete = frete.doubleValue();
    }

    public BigDecimal calcularFrete(String uf) {
        switch (uf) {
            case "SP":
            case "RJ":
            case "MG":
            case "ES":
                return BigDecimal.valueOf(7.85);
            case "DF":
            case "GO":
            case "MT":
            case "MS":
                return BigDecimal.valueOf(12.50);
            case "AL":
            case "BA":
            case "CE":
            case "MA":
            case "PB":
            case "PE":
            case "PI":
            case "RN":
            case "SE":
                return BigDecimal.valueOf(15.98);
            case "PR":
            case "RS":
            case "SC":
                return BigDecimal.valueOf(17.30);
            case "AC":
            case "AM":
            case "AP":
            case "PA":
            case "RO":
            case "RR":
            case "TO":
                return BigDecimal.valueOf(20.83);
            default:
                return BigDecimal.ZERO;
        }
    }
}
