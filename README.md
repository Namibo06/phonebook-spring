## Sobre o que é este projeto 🚀
### ↪ É somente um exemplo de CRUD de uma agenda telefônica,na qual é usada arquitetura limpa

---------------------------------------------------------------------


## Estrutura do projeto 🔗
```
phonebook
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── waitomo
│   │   │           └── phonebook
│   │   │               ├── application
│   │   │               │   ├── services
│   │   │               │   │   ├── impl
│   │   │               │   │   │   └── ContactImplService.java
│   │   │               │   │   └── ContactService.java
│   │   │               │   ├── usecases
│   │   │               │   │   └── CreateContactUseCase.java
│   │   │               ├── domain
│   │   │               │   ├── entities
│   │   │               │   │   └── Contact.java
│   │   │               │   ├── exceptions
│   │   │               │   ├── repositories
│   │   │               │   │   └── ContactRepository.java
│   │   │               ├── infrastructure
│   │   │               │   ├── configuration
│   │   │               │   ├── persistence
│   │   │               │   │   ├── impl
│   │   │               │   │   │   └── ContactRepositoryImpl.java
│   │   │               │   │   └── JpaContactRepository.java
│   │   │               ├── web
│   │   │               │   ├── controllers
│   │   │               │   │   └── ContactController.java
│   │   │               │   ├── dtos
│   │   │               │   │   ├── ContactRequestDTO.java
│   │   │               │   │   ├── ContactResponseDTO.java
│   │   │               │   │   ├── ErrorResponseDTO.java
│   │   │               │   │   └── MessageStatusResponseDTO.java
│   │   │               └── PhonebookApplication.java
│   │   ├── resources
│   │   │   └── application.yml
├── README.md
└── pom.xml
```

-----------------------------------------------------------------------------

## Explicando as packages 📦

### ▪ application:
#### É a parte onde ficam as Services e suas implementações,e UseCases.Se tornando a camada que contém toda a lógica da aplicação e casos de uso,que coordenam a interação entre domínio e a infraestrutura.

<br>

### ▪ domain:
#### É a parte onde ficam as Entities,Exceptions e Repositories.Se tornando a camada que contém as entidades e regras de negócio,ela é independente de frameworks e infraestrutura.

<br>

### ▪ infrastructure:
#### É a parte onde ficam as configurações do sistema,e também a parte de persistência de dados.Se tornando a camada que contém as implementações de infraestrutura,como persistência,configuração e adaptadores web.

<br>

### ▪ web:
#### É a parte que tem contato com o exterior da aplicação,por exemplo os DTO's,e os Controllers.Se tornando a camada de apresentação.  

----------------------------------------------------------------------------

## Explicando as sub-packages 📦

### ▪ services (application):
####

<br>

### ▪ usecases (application):
####

<br><br>

### ▪ entities (domain):
####

<br>

### ▪ exceptions (domain):
####

<br>

### ▪ repositories (domain):
####

<br><br>

### ▪ configuration (infrastructure):
####

<br>

### ▪ persistence (infrastructure):
####

<br><br>

### ▪ controllers (web):
#### ↪ São acessados pelos endpoints expostos,e sendo assim,direcionados a interagir com outras partes internas do sistema.

<br>

### ▪ dtos (web):
#### ↪ Vem direto das requisições seja feito de um site em produção ou localmente através de uma ferramenta de testes como Insomnia,Postman,ou até mesmo Testes Unitários.