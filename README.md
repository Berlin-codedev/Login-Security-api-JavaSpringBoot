# 🔐 Login Security API

Esta é uma API REST robusta desenvolvida em **Java** com **Spring Boot**, focada em autenticação e gerenciamento de usuários. O projeto foi estruturado seguindo as melhores práticas de mercado, utilizando uma arquitetura em camadas e isolamento de dados com DTOs.

## 🚀 Tecnologias Utilizadas

* **Java 17** (ou a versão que você estiver usando)
* **Spring Boot 3.x**
* **Spring Security** (Autenticação e Autorização)
* **Spring Data JPA** (Persistência de Dados)
* **Banco de Dados:** [Ex: H2 / PostgreSQL / MySQL]
* **Maven** (Gerenciador de Dependências)

## 📐 Arquitetura do Projeto

O sistema foi desenhado dividindo as responsabilidades de forma clara para garantir manutenibilidade e segurança:

1. **Entity (`Usuario`):** Mapeamento direto com as tabelas do Banco de Dados.
2. **Repository:** Interface que estende o `JpaRepository` para operações de CRUD.
3. **DTO (`SecDto`):** Objetos de transferência de dados que protegem a camada de negócio e controlam o que entra e sai da API.
4. **Mapper (`SecMapper`):** Componente dedicado a traduzir de forma isolada DTOs em Entidades e vice-versa.
5. **Service:** Concentra todas as regras de negócio e validações do sistema.
6. **Controller:** Expõe as rotas HTTP e endpoints da API.
7. **Security:** Camada de interceptação que protege as rotas e gerencia o acesso do usuário.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Java JDK instalado (versão 17 ou superior)
* Maven instalado

### Passos para rodar localmente
1. Clone o repositório:
   ```bash
   git clone https://github.com
   ```
2. Entre na pasta do projeto:
   ```bash
   cd NOME_DO_REPOSITORIO
   ```
3. Execute a aplicação via Maven:
   ```bash
   mvn spring-boot:run
   ```

## 🛠️ Endpoints Principais (CRUD)

| Método | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- |
| **POST** | `/usuarios` | Cadastra um novo usuário | Público |
| **GET** | `/usuarios` | Lista todos os usuários | Protegido (User/Admin) |
| **PUT** | `/usuarios/{id}` | Atualiza dados do usuário | Protegido (User/Admin) |
| **DELETE** | `/usuarios/{id}` | Remove um usuário | Protegido (Apenas Admin) |
