package tech.devinhouse.aviacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.devinhouse.aviacao.model.Confirmacao;

import java.util.Optional;

public interface ConfirmacaoRepository extends JpaRepository<Confirmacao, Long>{

    @Query("SELECT c FROM Confirmacao c WHERE c.assento = :assento")
    Optional<Confirmacao> findByAssento(String assento);

}
