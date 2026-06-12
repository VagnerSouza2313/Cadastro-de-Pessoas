# API de Cadastro e Gestão de Pessoas

## Sobre o Projeto

Este projeto consiste no desenvolvimento de uma API REST utilizando **Java + Spring Boot**, com foco em aplicar conceitos de arquitetura em camadas, boas práticas de desenvolvimento e integração com banco de dados relacional.

A aplicação tem como objetivo gerenciar entidades como pessoas e suas informações, permitindo operações de cadastro, consulta, atualização e remoção.

---

## Arquitetura

O projeto segue o padrão de **Arquitetura em Camadas**, dividido em:

* **Controller** → Responsável pela exposição dos endpoints (camada de entrada)
* **Service** → Contém as regras de negócio
* **Repository** → Comunicação com o banco de dados
* **Model (Entity)** → Representação das entidades do sistema
* **DTO** → Transferência de dados entre camadas
* **Exception** → Tratamento global de erros

---

## Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker / Docker Compose
* Maven

---

## Estrutura do Projeto

```
src/main/java/com/vagner/CadastroPessoas
├── controller
├── service
├── repository
├── domain
├── dto
├── mappers
└── enums
```

---

## Como Executar o Projeto

### Pré-requisitos

* Java 17+
* Docker
* Maven

---

### Subindo o banco com Docker

```bash
docker-compose up -d
```

---

### Executando a aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## Banco de Dados

* SGBD: PostgreSQL
* Configuração via `application.yml`
* Mapeamento utilizando JPA/Hibernate

---

## Endpoints

| Método | Endpoint      | Descrição              |
| ------ | ------------- | ---------------------- |
| GET    | api/readAll     | Lista todas as pessoas |
| GET    | api/readId/{id} | Busca por ID           |
| POST   | api/create      | Cria uma nova person   |
| PUT    | api/update/{id} | Atualiza uma person    |
| DELETE | api/delete/{id} | Remove uma person      |

---

## Boas Práticas Aplicadas

* Separação de responsabilidades (SRP)
* Uso de DTOs para isolamento de camadas
* Padronização de respostas da API

---

## Roadmap

* [ ok ] Implementar CRUD completo de Pessoas
* [ ] Adicionar validações com Bean Validation
* [ ] Adicionar documentação com Swagger
* [ ok ] Deploy com Docker

---

## Vagner Souza

Desenvolvido para fins de estudo e prática de desenvolvimento backend com Java e Spring.
