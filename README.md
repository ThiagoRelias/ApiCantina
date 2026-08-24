# ApiCantina
#  ApiCantina - Sistema de Gerenciamento de Lanches

##  Objetivo
O objetivo deste projeto é fornecer uma API REST robusta para o gerenciamento do cardápio de uma cantina. O sistema permite automatizar o fluxo de administração de lanches, oferecendo operações rápidas de consulta e garantindo a integridade dos dados por meio de validações rigorosas antes da persistência no banco de dados.

##  Descrição do Projeto
A **ApiCantina** é uma aplicação backend desenvolvida com a arquitetura MVC (Model-View-Controller) simplificada para APIs. Ela expõe endpoints padronizados para o controle completo do ciclo de vida dos lanches (CRUD), tratando de forma transparente as respostas de sucesso e os códigos de erro HTTP adequados.

### Funcionalidades Implementadas:
*   **Cadastrar Lanche:** Valida campos obrigatórios (nome, preço, disponibilidade), tamanhos máximos de caracteres e restrições de valores (preço maior que zero) antes de salvar. Retorna status 201 Created.
*   **Listar Todos os Lanches:** Retorna uma visão resumida (apenas nome e preco) otimizada para a consulta rápida do cardápio digital. Retorna status 200 OK.
*   **Consultar por ID:** Busca detalhada trazendo todas as informações do lanche. Retorna status 404 Not Found caso o ID não exista.
*   **Atualizar Lanche:** Permite a modificação segura dos atributos de um lanche existente via ID, revalidando os novos dados inseridos. Retorna status 404 Not Found se o lanche não for encontrado.
*   **Remover Lanche:** Exclui permanentemente um item do catálogo por ID. Retorna status 204 No Content em caso de sucesso ou 404 Not Found se o registro não existir.

##  Tecnologias Utilizadas
*   **Java 17** ou superior
*   **Spring Boot 3.x**
    *   *Spring Web* (Criação dos endpoints REST)
    *   *Spring Data JPA* (Persistência e comunicação com banco de dados)
    *   *Validation* (Validação de beans com Jakarta Validation)
*   **Lombok** (Produtividade com as anotações Builder, Data, etc.)
