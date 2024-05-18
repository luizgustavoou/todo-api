# Todo API

## :memo: About the Project
The Todo API is a simple task management system designed to explore the knowledge gained in the Spring ecosystem.

## :books: Features
* **Authentication**
* **CRUD for todos**

# :wrench: Technologies Used
## Backend
* Spring Boot
* Spring Validation
* Spring Web
* Spring Data JPA
* MySQL Driver

## Infrastructure
* Docker

## :rocket: Running the Project
Prerequisites: Java 17

```bash
# clone the repository
git clone https://github.com/luizgustavoou/todo-api.git

# initialize a MySQL container or install MySQL locally on your machine
docker run --name meu-mysql -e MYSQL_ROOT_PASSWORD=banco123 -e MYSQL_DATABASE=todo-api -p 3306:3306 mysql:latest 

# import the project into your preferred IDE

# start the project
```

## :soon: Future Implementations
* **Comment on a todo**
* **Implement Websocket for todo comments**

## :dart: Project Status
In Progress

# Author

Luiz Gustavo de Oliveira Umbelino  
<a href="https://github.com/luizgustavoou">Luiz Gustavo de Oliveira Umbelino</a><br>
