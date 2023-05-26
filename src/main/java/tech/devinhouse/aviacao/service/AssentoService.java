package tech.devinhouse.aviacao.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssentoService {

    public List<String> getTodosOsAssentos() {
        List<String> assentos = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (char c = 'A'; c <= 'F'; c++) {
                assentos.add(i + String.valueOf(c));
            }
        }
        return assentos;
    }

}
