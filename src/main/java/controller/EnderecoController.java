package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Endereco;
import model.EnderecoRequest;
import model.EnderecoResponse;
import service.EnderecoService;

@RestController
@RequestMapping("/v1")
@Api(value = "API de consulta de endereço e cálculo de frete")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@PostMapping("/consulta-endereco")
	@ApiOperation(value = "Consulta o endereço de um determinado CEP")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Endereço encontrado", response = EnderecoResponse.class),
			@ApiResponse(code = 400, message = "CEP inválido"),
			@ApiResponse(code = 404, message = "CEP não encontrado") })
	public ResponseEntity<Endereco> consultaEndereco(@RequestBody @Valid EnderecoRequest request) {

		Endereco endereco = enderecoService.consultaEndereco(request.getCep());
		if (endereco != null) {
			endereco.setFrete(calcularFrete(endereco.getEstado()));
			return ResponseEntity.ok(endereco);
		} else {
			return ResponseEntity.notFound().build();
		}
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
}
