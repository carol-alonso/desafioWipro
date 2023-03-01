package service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.CepNaoEncontradoException;
import model.Endereco;

@Service
public class ViaCepService {
    
    private static final String URL_VIACEP = "https://viacep.com.br/ws/%s/json/";
    
    private final RestTemplate restTemplate;
    
    public ViaCepService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
        public Endereco buscarEndereco(String cep) throws CepNaoEncontradoException {
            ResponseEntity<Endereco> response = restTemplate.getForEntity(URL_VIACEP + cep + "/json", Endereco.class);

            if (response.getBody() == null) {
                throw new CepNaoEncontradoException("CEP não encontrado");
            }

            Endereco endereco = response.getBody();

            if (endereco.getCep() == null) {
                throw new CepNaoEncontradoException("CEP não encontrado");
            }

            return endereco;
        }

    }

