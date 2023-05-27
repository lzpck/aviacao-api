package tech.devinhouse.aviacao.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import tech.devinhouse.aviacao.model.Classificacao;
import tech.devinhouse.aviacao.model.Confirmacao;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.repository.ConfirmacaoRepository;
import tech.devinhouse.aviacao.repository.PassageiroRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ConfirmacaoServiceTest {

    @InjectMocks
    ConfirmacaoService confirmacaoService;

    @MockBean
    ConfirmacaoRepository confirmacaoRepository;

    @MockBean
    PassageiroRepository passageiroRepository;

    @Mock
    AssentoService assentoService;

    @Test
    void testRegistrarConfirmacao() {
        //Arrange
        Long cpf = 11111111111L;
        String assento = "3A";
        boolean malasDespachadas = true;
        Classificacao classificacao = Classificacao.VIP;
        Passageiro passageiro = new Passageiro();
        passageiro.setClassificacao(classificacao);
        passageiro.setMilhas(0);

        when(passageiroRepository.findById(cpf)).thenReturn(Optional.of(passageiro));
        when(assentoService.isAssentoExistente(assento)).thenReturn(true);
        when(confirmacaoRepository.findByAssento(assento)).thenReturn(Optional.empty());
        when(assentoService.isFileiraEmergencia(assento)).thenReturn(false);

        Confirmacao resultado = confirmacaoService.registrarConfirmacao(cpf, assento, malasDespachadas);

        assertEquals(assento, resultado.getAssento());
        assertEquals(malasDespachadas, resultado.isMalasDespachadas());
        assertEquals(classificacao, resultado.getClassificacao());
    }
}
