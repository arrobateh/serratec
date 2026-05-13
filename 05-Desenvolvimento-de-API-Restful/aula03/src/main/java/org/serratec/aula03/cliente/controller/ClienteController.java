package org.serratec.aula03.cliente.controller;

import jakarta.validation.Valid;
import org.serratec.aula03.cliente.domain.Cliente;
import org.serratec.aula03.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/clientes")
    public class ClienteController {
        @Autowired
        private ClienteRepository clienteRepository;

        // 1. Listar clientes
        @GetMapping
        public List<Cliente> listar() {
            return clienteRepository.findAll();
        }

        // 2. Listar cliente por id

        @GetMapping("/{id}")
        public ResponseEntity<Cliente> buscarPorID(@PathVariable Long id) {

            if (!clienteRepository.existsById(id)) {
             return ResponseEntity.notFound().build();
            }
            return clienteRepository.findById(id)
                    .map(done -> ResponseEntity.ok(done))
                    .orElse(ResponseEntity.notFound().build());
        }

        // 3. Cadastrar cliente
        @PostMapping
        public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
            Cliente  salvarCliente = clienteRepository.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvarCliente);
        }
        // 4. Atualizar cliente
        @PutMapping("/{id}")
        public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
            if (!clienteRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }

            cliente.setId(id);

            Cliente atualizarCliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(atualizarCliente);
        }

        // 5. Deletar cliente
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
            if (!clienteRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        // Buscar por nome
        @GetMapping("/buscar")
        public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
            List<Cliente> clientes = clienteRepository.findByNome(nome);

            if (clientes.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(clientes);
        }


    }
