package tech.devinhouse.aviacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.aviacao.model.Passageiro;

import java.util.Optional;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{
    Optional<Passageiro> findByCpf(Long cpf);
}
