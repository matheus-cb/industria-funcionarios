# Industria Funcionarios API

## Visão Geral

Industria Funcionarios API é uma aplicação para gerenciamento de funcionários em uma indústria, permitindo realizar operações como listar, adicionar, remover, atualizar e agrupar funcionários. A API também fornece funcionalidades adicionais como cálculo de salários e listagem por mês de aniversário.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.0
- H2 Database
- JPA (Java Persistence API)
- Maven
- Springdoc OpenAPI 2.5.0 (para documentação da API)

## Funcionalidades

- Listar todos os funcionários
- Adicionar um novo funcionário
- Remover um funcionário pelo ID
- Atualizar os salários de todos os funcionários em 10%
- Agrupar funcionários por função
- Listar funcionários por mês de aniversário
- Buscar o funcionário mais velho
- Ordenar funcionários por nome
- Somar os salários de todos os funcionários
- Calcular a quantidade de salários mínimos por função

## Endpoints da API

### Funcionarios

- `GET /funcionarios`: Listar todos os funcionários
- `POST /funcionarios`: Adicionar um novo funcionário
- `DELETE /funcionarios/{id}`: Remover um funcionário pelo ID
- `PUT /funcionarios/atualizar-salarios`: Atualizar os salários de todos os funcionários em 10%
- `GET /funcionarios/agrupar-por-funcao`: Agrupar funcionários por função
- `GET /funcionarios/aniversarios/{mes}`: Listar funcionários por mês de aniversário
- `GET /funcionarios/mais-velho`: Buscar o funcionário mais velho
- `GET /funcionarios/ordenar-por-nome`: Ordenar funcionários por nome
- `GET /funcionarios/somar-salarios`: Somar os salários de todos os funcionários
- `GET /funcionarios/salarios-minimos`: Calcular a quantidade de salários mínimos por função

## Configuração e Execução

### Pré-requisitos

- Java 17
- Maven

### Passos para Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/industria-funcionarios.git
   cd industria-funcionarios
    ```
2. Compile e rode os testes:

    ```bash
    mvn clean install
    ```
   
3. Inicie a aplicação:

    ```bash
    mvn spring-boot:run
    ```
   
4. Acesse a documentação da API (Swagger UI) no navegador:

    [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Estrutura do Projeto

```
    industria-funcionarios/
│
├── src/main/java/com/example/funcionarios
│   ├── config
│   │   └── SwaggerConfig.java
│   ├── controller
│   │   └── FuncionarioController.java
│   ├── model
│   │   └── Funcionario.java
│   ├── repository
│   │   └── FuncionarioRepository.java
│   ├── service
│   │   └── FuncionarioService.java
│   └── IndustriaFuncionariosApplication.java
│
├── src/test/java/com/example/funcionarios
│   ├── FuncionarioServiceTest.java
│   ├── FuncionarioControllerIntegrationTest.java
│   └── IndustriaFuncionariosApplicationTests.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
└── README.md
```

### Testes

- `FuncionarioServiceTest`: Testes unitários para a camada de serviço
- `FuncionarioControllerIntegrationTest`: Testes de integração para o controlador

Os testes estão localizados no pacote src/test/java/com/example/funcionarios. Para rodar os testes, use o seguinte comando:

```bash
mvn test
```