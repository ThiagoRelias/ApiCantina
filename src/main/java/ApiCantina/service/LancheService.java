package ApiCantina.service;


import ApiCantina.dto.LancheRequestDTO;
import ApiCantina.dto.LancheResponseDTO;
import ApiCantina.dto.LancheResumidoDTO;
import ApiCantina.model.Lanche;
import ApiCantina.repository.LancheRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LancheService {

    @Autowired
    private LancheRepository repository;

    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        Lanche lanche = Lanche.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .disponivel(dto.getDisponivel())
                .build();
        return mapToResponse(repository.save(lanche));
    }

    public List<LancheResumidoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(l -> new LancheResumidoDTO(l.getNome(), l.getPreco()))
                .collect(Collectors.toList());
    }

    public LancheResponseDTO buscarPorId(Long id) {
        Lanche lanche = repository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Lanche com ID " + id + " não encontrado."));
        return mapToResponse(lanche);
    }

    public LancheResponseDTO atualizar(Long id, LancheRequestDTO dto) {
        Lanche lanche = repository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Lanche com ID " + id + " não encontrado."));
        lanche.setNome(dto.getNome());
        lanche.setDescricao(dto.getDescricao());
        lanche.setPreco(dto.getPreco());
        lanche.setDisponivel(dto.getDisponivel());
        return mapToResponse(repository.save(lanche));
    }

    public void remover(Long id) {
        Lanche lanche = repository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Lanche com ID " + id + " não encontrado."));
        repository.delete(lanche);
    }

    private LancheResponseDTO mapToResponse(Lanche lanche) {
        LancheResponseDTO res = new LancheResponseDTO();
        res.setId(lanche.getId());
        res.setNome(lanche.getNome());
        res.setDescricao(lanche.getDescricao());
        res.setPreco(lanche.getPreco());
        return res;
    }
}
