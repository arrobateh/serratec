package org.serratec.aula.funcionario.controller;

import jakarta.validation.Valid;
import org.serratec.aula.funcionario.domain.Funcionario;
import org.serratec.aula.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Listar funcionarios
    @GetMapping
    public List<Funcionario> findAll() {
       return funcionarioRepository.findAll();
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionaro =  funcionarioRepository.findById(id);
        if(funcionaro.isPresent()) {
            return ResponseEntity.ok(funcionaro.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Cadastrar funcionario
    @PostMapping
    public ResponseEntity<Object> addFuncionario(@Valid @RequestBody Funcionario funcionario) {
        if (funcionarioRepository.existsByNome(funcionario.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este funcionario já existe");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
    }

    // Atualizar funcionario
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id) {
        if(!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        funcionario =  funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    // Deletar funcionario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        if(!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
