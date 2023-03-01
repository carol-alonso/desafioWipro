package model;

public class EnderecoResponse {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;
	public EnderecoResponse(String cep, String rua, String complemento, String bairro, String cidade, String estado,
			Double frete) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.frete = frete = calcularFrete(cep);
		}
		
		private Double calcularFrete(String cep) {
	        String regiao = cep.substring(0, 2);
	        switch (regiao) {
	            case "11":
	            case "12":
	            case "13":
	            case "14":
	            case "15":
	            case "16":
	            case "17":
	            case "18":
	            case "19":
	                return 7.85;
	            case "20":
	            case "21":
	            case "22":
	            case "23":
	            case "24":
	            case "25":
	            case "26":
	            case "27":
	            case "28":
	            case "29":
	                return 15.98;
	            case "30":
	            case "31":
	            case "32":
	            case "33":
	            case "34":
	            case "35":
	            case "36":
	            case "37":
	            case "38":
	            case "39":
	                return 12.50;
	            case "40":
	            case "41":
	            case "42":
	            case "43":
	            case "44":
	            case "45":
	            case "46":
	                return 17.30;
	            case "47":
	            case "48":
	            case "49":
	            case "69":
	                return 20.83;
	            default:
	                return 0.0;
	        }
	
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
	

 
}
