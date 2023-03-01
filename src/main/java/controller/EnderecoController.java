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
	public ResponseEntity<EnderecoResponse> consultaEndereco(@RequestBody @Valid EnderecoRequest request) {

		EnderecoResponse endereco = enderecoService.consultaEndereco(enderecoRequest.getCep());
		if (endereco != null) {
			endereco.setFrete(calcularFrete(endereco.getEstado()));
			return ResponseEntity.ok(endereco);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
