package com.calculo.cep.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.calculo.cep.model.Endereco;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate;
    private final String url = "https://viacep.com.br/ws/%s/json/";

    public ViaCepService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Endereco consultarEnderecoPorCep(String cep) {
        String urlRequest = String.format(url, cep);
        ResponseEntity<Endereco> response = restTemplate.exchange(urlRequest, HttpMethod.GET, null, Endereco.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }

        return null;
    }
}



