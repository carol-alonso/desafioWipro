package service;

import org.springframework.stereotype.Service;

import client.ViaCepClient;
import client.ViaCepResponse;
import exception.ViaCepException;
import feign.FeignException;

@Service
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCepResponse consultaCep(String cep) throws ViaCepException {
        try {
            ViaCepResponse viaCepResponse = viaCepClient.consultaCep(cep);
            if (viaCepResponse == null || viaCepResponse.getCep() == null) {
                throw new ViaCepException("CEP não encontrado");
            }
            return viaCepResponse;
        } catch (FeignException e) {
            throw new ViaCepException("Erro ao consultar CEP: " + e.getMessage());
        }
    }
}
