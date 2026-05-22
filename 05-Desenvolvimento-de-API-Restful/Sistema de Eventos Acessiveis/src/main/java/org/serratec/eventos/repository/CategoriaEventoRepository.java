package org.serratec.eventos.repository;

import org.serratec.eventos.domain.CategoriaEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {
}
