package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.ConsultaEnderecoRequest;
import client.ConsultaEnderecoResponse;
import model.Endereco;
import service.FreteService;
import service.ViaCepService;

@RestController
@RequestMapping("/v1/consulta-endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsultaEnderecoController {

    private final ViaCepService viaCepService;
    private final FreteService freteService;

    public ConsultaEnderecoController(ViaCepService viaCepService, FreteService freteService) {
        this.viaCepService = viaCepService;
        this.freteService = freteService;
    }

    @PostMapping("/cep")
    public ResponseEntity<ConsultaEnderecoResponse> consultaEndereco(@RequestBody ConsultaEnderecoRequest request) {
        Endereco endereco = viaCepService.buscarEndereco(request.getCep());
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        endereco.setFrete(freteService.calcularFrete(endereco.getUf()));
        ConsultaEnderecoResponse response = new ConsultaEnderecoResponse();
        return ResponseEntity.ok(response);
    }
}
