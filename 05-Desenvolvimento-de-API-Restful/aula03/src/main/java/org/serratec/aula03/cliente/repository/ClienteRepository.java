package org.serratec.aula03.cliente.repository;


import org.serratec.aula03.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    List<Cliente> findByNome(String nome);
}
