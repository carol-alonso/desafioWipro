import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import client.ViaCepClient;
import client.ViaCepResponse;
import exception.ViaCepException;
import model.Endereco;
import repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final ViaCepClient viaCepClient;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(ViaCepClient viaCepClient, EnderecoRepository enderecoRepository) {
        this.viaCepClient = viaCepClient;
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco consultaEndereco(String cep) throws ViaCepException {
        // Verifica se o CEP informado é válido
        if (!cep.matches("\\d{8}")) {
            throw new ViaCepException("CEP inválido");
        }

        // Verifica se o endereço já está salvo no banco de dados
        Endereco endereco = enderecoRepository.findByCep(cep);
        if (endereco != null) {
            return endereco;
        }

        // Consulta o endereço na API VIA CEP
        ViaCepResponse viaCepResponse = viaCepClient.consultaCep(cep);
        if (viaCepResponse == null) {
            throw new ViaCepException("CEP não encontrado");
        }

        // Cria um novo objeto Endereco com os dados da resposta da API VIA CEP
        endereco = new Endereco();
        endereco.setCep(viaCepResponse.getCep());
        endereco.setRua(viaCepResponse.getLogradouro());
        endereco.setComplemento(viaCepResponse.getComplemento());
        endereco.setBairro(viaCepResponse.getBairro());
        endereco.setCidade(viaCepResponse.getLocalidade());
        endereco.setEstado(viaCepResponse.getUf());

        // Salva o novo endereço no banco de dados
        enderecoRepository.save(endereco);

        return endereco;
    }

}