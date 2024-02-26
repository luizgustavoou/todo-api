# Todo Api
<!-- license --> 

## :memo:  Sobre o projeto
A API consiste de um simples gerenciamento de tarefas para explorar os conhecimentos estudados no ecossistema Spring.

## :books: Funcionalidades
* <b>Autenticação</b>;
* <b>CRUD de todo</b>;

# :wrench: Tecnologias utilizadas
## Back end
* Spring Boot;
* Spring Validation;
* Spring Web;
* Spring Data JPA;
* MySQL Driver;

## Infraestrutura
* Docker;

## :rocket: Rodando o projeto
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/luizgustavoou/todo-api.git

# inicialize um container mysql ou instale o mysql localmente na sua máquina
docker run --name meu-mysql -e MYSQL_ROOT_PASSWORD=banco123 -e MYSQL_DATABASE=todo-api -p 3306:3306 mysql:latest 

# importe o projeto em alguma IDE de preferência

# Inicialize o projeto
```

## :soon: Implementação futura
* <b>Comentar sobre um todo</b>;
* <b>Implementar Websocket para os comentários de todo</b>;

## :dart: Status do projeto
Andamento
# Autor

Luiz Gustavo de Oliveira Umbelino
[https://www.linkedin.com/in/wmazoni](https://www.linkedin.com/in/luiz-oliveira-802294294/)https://www.linkedin.com/in/luiz-oliveira-802294294/

