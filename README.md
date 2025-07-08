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
| **Produtividade**| Lombok, ModelMapper                |

---

## 🛠️ Configuração Rápida

```bash
# Clone o projeto
git clone https://github.com/Gabrielcardososales/TodoList.git

# Entre na pasta
cd TodoList

# Execute (requer Maven instalado)
mvn spring-boot:run



GET    /api/todos           Lista todas tarefas
POST   /api/todos           Cria nova tarefa
GET    /api/todos/{id}      Busca tarefa por ID
PUT    /api/todos/{id}      Atualiza tarefa
DELETE /api/todos/{id}      Remove tarefa
PATCH  /api/todos/{id}/complete  Marca como concluída
