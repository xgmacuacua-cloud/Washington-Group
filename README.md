# Projecto Java - Questionário Washington Group

Este é o projecto completo desenvolvido em **Java 17** utilizando **Spring Boot**.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.2** (Web, Thymeleaf)
- **Jackson** (Para manipulação de JSON)
- **Maven** (Gerenciador de dependências)

## Como Rodar Localmente
1. Certifique-se de ter o **JDK 17** e o **Maven** instalados.
2. Navegue até a pasta do projecto: `cd java-project`
3. Execute o comando: `mvn spring-boot:run`
4. Acesse no navegador: `http://localhost:8080`

## Estrutura do Código
- `controller/`: Gerencia as rotas `/questionario`, `/processar` e `/pessoas-identificadas`.
- `model/`: Define a entidade `Avaliacao`.
- `service/`: Implementa a persistência no arquivo `dados.json`.
- `resources/templates/`: Contém as páginas HTML (Thymeleaf).
