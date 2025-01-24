

# SpringBoot_Actordb

## Description
SpringBoot_Actordb is a Spring Boot project for managing actors in a database. It provides RESTful APIs to perform CRUD operations on actor data.

## Project Structure
```
.classpath
.gitattributes
.gitignore
.mvn/
    wrapper/
        maven-wrapper.properties
.project
.settings/
    org.eclipse.core.resources.prefs
    org.eclipse.jdt.core.prefs
    org.eclipse.m2e.core.prefs
HELP.md
mvnw
mvnw.cmd
pom.xml
src/
    main/
        java/
            com/
                jsp/
                    springboot/
                        actordb/
                            controller/
                            entity/
                            exception/
                            repository/
                            service/
                            serviceimpl/
                            utility/
        resources/
            application.properties
            static/
            templates/
    test/
        java/
            com/
                jsp/
                    springboot/
                        actordb/
target/
    classes/
    test-classes/
```

## Prerequisites
- Java 17
- Maven
- MySQL

## Setup

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd SpringBoot_Actordb
   ```

2. **Configure the database:**
   Update the database configuration in 

application.properties

:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/springboot_actordb?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=root
   ```

3. **Build the project:**
   ```sh
   ./mvnw clean install
   ```

4. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```

## API Endpoints

### ActorController
- **Add Actor**
  - `POST /actors`
  - Request Body: 

Actor


  - Response: 

ResponseEntity<ResponceStructure<Actor>>



- **Find All Actors**
  - `GET /actors`
  - Response: 

ResponseEntity<ResponceStructure<List<Actor>>>



- **Find Actor by ID**
  - `GET /actors/id`
  - Query Param: 

int actorId


  - Response: 

ResponseEntity<ResponceStructure<Actor>>



- **Update Actor by ID**
  - `PUT /actors`
  - Query Param: 

int actorId


  - Request Body: 

Actor


  - Response: 

ResponseEntity<ResponceStructure<Actor>>



- **Delete Actor by ID**
  - `DELETE /actors`
  - Query Param: 

int actorId


  - Response: 

ResponseEntity<ResponceStructure<Actor>>



- **Find Actor by Name**
  - `GET /actors/name`
  - Query Param: 

String actorName


  - Response: 

ResponseEntity<ResponceStructure<List<Actor>>>



- **Find Actor by Age**
  - `GET /actors/age`
  - Query Param: 

int age


  - Response: 

ResponseEntity<ResponceStructure<List<Actor>>>



- **Find Actors by Age Range**
  - `GET /actors/agebetween`
  - Query Params: 

int age1

, 

int age2


  - Response: 

ResponseEntity<ResponceStructure<List<Actor>>>



- **Find Actor by Industry**
  - `GET /actors/industry`
  - Query Param: 

String industry


  - Response: 

ResponseEntity<ResponceStructure<List<Actor>>>



## Exception Handling
Custom exceptions are handled using 

ApplicationHandler

:
- 

ActorNotFoundByIdException


- 

ActorNotFoundByAgeException


- 

ActorNotFoundByNameException


- 

ActorNotFoundByIndustryException



## License
This project is licensed under the Apache License, Version 2.0. See the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0) file for details.

## Authors
- Your Name

## Acknowledgments
- Spring Boot
- MySQL
- Apache Maven


