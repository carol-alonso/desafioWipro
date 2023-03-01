package com.calculo.cep.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FreteService {

    private static final Map<String, Double> REGIOES_FRETE = new HashMap<>();
    static {
        REGIOES_FRETE.put("SP", 7.85);
        REGIOES_FRETE.put("RJ", 7.85);
        REGIOES_FRETE.put("ES", 7.85);
        REGIOES_FRETE.put("MG", 7.85);
        REGIOES_FRETE.put("MS", 12.50);
        REGIOES_FRETE.put("MT", 12.50);
        REGIOES_FRETE.put("GO", 12.50);
        REGIOES_FRETE.put("DF", 12.50);
        REGIOES_FRETE.put("BA", 15.98);
        REGIOES_FRETE.put("SE", 15.98);
        REGIOES_FRETE.put("AL", 15.98);
        REGIOES_FRETE.put("PE", 15.98);
        REGIOES_FRETE.put("PB", 15.98);
        REGIOES_FRETE.put("RN", 15.98);
        REGIOES_FRETE.put("CE", 15.98);
        REGIOES_FRETE.put("PI", 15.98);
        REGIOES_FRETE.put("MA", 15.98);
        REGIOES_FRETE.put("PR", 17.30);
        REGIOES_FRETE.put("SC", 17.30);
        REGIOES_FRETE.put("RS", 17.30);
        REGIOES_FRETE.put("AM", 20.83);
        REGIOES_FRETE.put("RR", 20.83);
        REGIOES_FRETE.put("RO", 20.83);
        REGIOES_FRETE.put("AC", 20.83);
        REGIOES_FRETE.put("PA", 20.83);
        REGIOES_FRETE.put("AP", 20.83);
        REGIOES_FRETE.put("TO", 20.83);
    }

    public double calcularFrete(String uf) {
        return REGIOES_FRETE.getOrDefault(uf.toUpperCase(), 0.0);
    }

}
