package org.serratec.eventos.repository;

import org.serratec.eventos.domain.RecursoAcessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecAcessibilidadeRepository extends JpaRepository<RecursoAcessibilidade, Long> {
}
