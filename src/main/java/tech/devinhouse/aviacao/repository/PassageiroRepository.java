package tech.devinhouse.aviacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.aviacao.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{
}
