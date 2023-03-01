package com.calculo.cep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculo.cep.dto.ConsultaEnderecoRequest;
import com.calculo.cep.dto.ConsultaEnderecoResponse;
import com.calculo.cep.model.Endereco;
import com.calculo.cep.service.ViaCepService;

@RestController
@RequestMapping("/v1/consulta-endereco/cep")
public class ConsultaEnderecoController {

    private ViaCepService viaCepService;

    public ConsultaEnderecoController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @PostMapping
    public ResponseEntity<ConsultaEnderecoResponse> consultaEndereco(@RequestBody ConsultaEnderecoRequest request) {
        String cep = request.getCep().replace("-", "");

        Endereco endereco = viaCepService.consultarEnderecoPorCep(cep);
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (endereco.getUf() == null) {
        	ConsultaEnderecoResponse response = new ConsultaEnderecoResponse(endereco, null);
            return ResponseEntity.ok(response);
        }

        Double frete = calculaFrete(endereco);

        ConsultaEnderecoResponse response = new ConsultaEnderecoResponse(endereco, frete);
        return ResponseEntity.ok(response);
    }

    private Double calculaFrete(Endereco endereco) {
        String uf = endereco.getUf();
        switch (uf) {
            case "SP":
            case "RJ":
            case "MG":
            case "ES":
                return 7.85;
            case "MT":
            case "MS":
            case "GO":
            case "DF":
                return 12.50;
            case "BA":
            case "SE":
            case "AL":
            case "PE":
            case "PB":
            case "RN":
            case "CE":
            case "PI":
            case "MA":
                return 15.98;
            case "PR":
            case "SC":
            case "RS":
                return 17.30;
            case "AM":
            case "RO":
            case "AC":
            case "RR":
            case "AP":
            case "PA":
            case "TO":
                return 20.83;
            default:
                return 0.0;
        }
    }

}
