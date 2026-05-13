package org.serratec.aula.funcionario.repository;

import org.serratec.aula.funcionario.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByNome(String nome);
}
