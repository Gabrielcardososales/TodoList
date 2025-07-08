# 🚀 TodoList API - Simplify Challenge

**Uma solução elegante para gerenciamento de tarefas**  
[🔗 Ver Desafio Original](https://github.com/simplify-tec/desafio-junior-backend-simplify) | [📂 Acessar Repositório](https://github.com/Gabrielcardososales/TodoList)

---

## 💻 Stack Tecnológica

| Categoria       | Tecnologias                          |
|-----------------|--------------------------------------|
| **Backend**     | Java 17, Spring Boot 3.1.5           |
| **Banco**       | H2 Database (em memória)             |
| **Documentação**| Swagger UI                           |
| **Build**       | Maven                                |
| **Produtividade**| Lombok, ModelMapper                 |

---

## ✨ Práticas Adotadas

- **SOLID, DRY, YAGNI, KISS**  
- **API REST**  
- **Consultas com Spring Data JPA**  
- **Injeção de Dependências**  
- **Tratamento de respostas de erro**  
- **Geração automática do Swagger com a OpenAPI 3**  

---

## 📡 Endpoints da API

### Tarefas (`/api/tasks`)
| Método | Rota                | Descrição                          | Parâmetros/Observações           |
|--------|---------------------|------------------------------------|----------------------------------|
| `GET`  | `/`                 | Lista todas as tarefas             | Ordenação opcional por campos    |
| `GET`  | `/{id}`             | Busca uma tarefa por ID            |                                  |
| `POST` | `/`                 | Cria uma nova tarefa               | Corpo: `{title, description, dueDate, priority}` |
| `PUT`  | `/{id}`             | Atualiza uma tarefa existente      | Corpo completo da tarefa         |
| `PATCH`| `/{id}/status`      | Atualiza apenas o status           | Corpo: `{status: "COMPLETED"}`   |
| `DELETE`| `/{id}`            | Remove uma tarefa                  |                                  |

### Exemplo de Request (POST)
```json
{
  "title": "Revisar código",
  "description": "Validar implementação dos endpoints",
  "dueDate": "2023-12-15",
  "priority": "HIGH"
}
---

## 🛠️ Configuração Rápida

```bash
# Clone o projeto
git clone https://github.com/Gabrielcardososales/TodoList.git

# Entre na pasta
cd TodoList

# Execute (requer Maven instalado)
mvn spring-boot:run
