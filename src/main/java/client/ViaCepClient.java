package client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import exception.ViaCepException;

@Component
public class ViaCepClient {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    private final RestTemplate restTemplate;

    @Autowired
    public ViaCepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponse consultaCep(String cep) throws ViaCepException {
        String url = String.format(VIA_CEP_URL, cep);
        ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);
        if (response == null || response.getCep() == null) {
            throw new ViaCepException("CEP não encontrado");
        }
        return response;
    }
}
