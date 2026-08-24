package ApiCantina.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class LancheRequestDTO {
    @NotBlank(message = "O nome do lanche é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal preco;

    @NotNull(message = "O status de disponibilidade é obrigatório.")
    private Boolean disponivel;
}
