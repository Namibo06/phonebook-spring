## Sobre o que é este projeto 🚀
### ↪ É somente um exemplo de CRUD de uma agenda telefônica,na qual é usada Arquitetura Limpa

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
│   │   │               │   ├── mapper
│   │   │               │   │   └── ContactMapper.java
│   │   │               │   │   └── ModelMapperConfig.java
│   │   │               │   ├── services
│   │   │               │   │   ├── impl
│   │   │               │   │   │   └── ContactImplService.java
│   │   │               │   │   └── ContactService.java
│   │   │               │   ├── usecases
│   │   │               │   │   └── CreateContactUseCase.java
│   │   │               │   │   └── DeleteContactUseCase.java
│   │   │               │   │   └── ExistsContactUseCase.java
│   │   │               │   │   └── FindAllContactUseCase.java
│   │   │               │   │   └── FindContactByNameOrNumberUseCase.java
│   │   │               │   │   └── UpdateContactUseCase.java
│   │   │               ├── domain
│   │   │               │   ├── entities
│   │   │               │   │   └── Contact.java
│   │   │               │   ├── exceptions
│   │   │               │   │   └── AlreadyExistsException.java
│   │   │               │   │   └── GlobalExceptionHandler.java
│   │   │               │   │   └── NotFoundException.java
│   │   │               │   │   └── NullValuesException.java
│   │   │               │   ├── repositories
│   │   │               │   │   └── ContactRepository.java
│   │   │               ├── infrastructure
│   │   │               │   ├── configuration
│   │   │               │   │   └── SwaggerConfig.java
│   │   │               │   ├── persistence
│   │   │               │   │   ├── impl
│   │   │               │   │   │   └── ContactRepositoryImpl.java
│   │   │               │   │   └── ContactEntity.java
│   │   │               │   │   └── JpaContactRepository.java
│   │   │               ├── web
│   │   │               │   ├── controllers
│   │   │               │   │   └── ContactController.java
│   │   │               │   ├── dtos
│   │   │               │   │   ├── ContactRequest.java
│   │   │               │   │   ├── ContactResponse.java
│   │   │               │   │   ├── ErrorResponse.java
│   │   │               │   │   └── MessageStatusResponse.java
│   │   │               └── PhonebookApplication.java
│   │   ├── resources
│   │   │   └── application.yml
├── docker-compose.yaml
├── Dockerfile
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

### ▪ mapper (application):
#### Onde ficam os mapeamentos.

<br>

### ▪ services (application):
#### Onde ficam os contratos de serviço,e onde também o serviço entra em contato com a camada de repositório.

<br>

### ▪ usecases (application):
#### Aqui é onde fica a lógica e regras de negócio,onde as interações de alto nível que fazem o aplicativo funcionar,são definidas e orquestradas.

<br><br>

### ▪ entities (domain):
#### ↪ Aqui ficam as entidades que serão utilizadas como resposta para o cliente,ou transferir dados pelas demais camadas.

<br>

### ▪ exceptions (domain):
#### ↪ Parte responsável por guardas as exceções personalizadas e também podendo guardar o gerenciador de exceções.

<br>

### ▪ repositories (domain):
#### ↪ Ficam aqui os contratos que serão implementados.

<br><br>

### ▪ configuration (infrastructure):
#### ↪ Arquivos de configurações de bibliotecas,frameworks,ou libs externas.

<br>

### ▪ persistence (infrastructure):
#### ↪ Parte responsável por interagir com o banco de dados.

<br><br>

### ▪ controllers (web):
#### ↪ São acessados pelos endpoints expostos,e sendo assim,direcionados a interagir com outras partes internas do sistema.

<br>

### ▪ responses (web):
#### ↪ Vem como requisições,seja feito de um site em produção ou localmente através de uma ferramenta de testes como Insomnia,Postman,ou até mesmo Testes Unitários,ou vão como resposta a partir de algum processo.

