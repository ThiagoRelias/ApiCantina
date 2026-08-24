package ApiCantina.controller;


import ApiCantina.dto.LancheRequestDTO;
import ApiCantina.dto.LancheResponseDTO;
import ApiCantina.dto.LancheResumidoDTO;
import ApiCantina.service.LancheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lanches")
public class LancheController {

    @Autowired
    private LancheService service;

    @PostMapping
    public ResponseEntity<LancheResponseDTO> cadastrar(@Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<LancheResumidoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
