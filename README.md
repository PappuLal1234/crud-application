# Crud Operation App - Spring Boot & React JS

## Introduction
This is a small Crud Application with proper exception handling where we perform crud operation with user information.
## Technologies Used
- Java-17
- Spring Boot
- Maven (for project build)
- React Js
- HTML/CSS/Bootstrap
- JavaScript
##  Data Flow

* Controller -
  it Will receive request from client(fronten end) and send request to service layer.
* Service -
  it Will receive request from controller and this will manipulate the operation and send request to DAO layer
* Repository -
  it Will receive request from service and it will communicate with the pogo

##  Data Structure used in project

* DataBase Design -
  Here Created pogo for User.
  In this project mostly used ArrayList & along with java 8 feature like optional class and
  lambda expression.


## Setup and Installation
1. Clone the repository to your local machine using `git clone`.
2. Ensure you have Java JDK,Node JS and Maven installed on your system.
3. Open the project in your favorite IDE (IntelliJ, Eclipse,VsCode etc.).
4. Build the project using Maven: `mvn clean install`.
5. Run the Spring Boot application: `mvn spring-boot:run`.

## API Endpoints

### Controller Endpoints:
- `Todo Controller`: Here we're performing Todo operations


## Known Issues / Future Improvements
- The application currently uses an  MySQL database. For production use, consider switching to a more robust database like MySQL or PostgreSQL.
- Add error handling and validation for user inputs and API responses.
- Implement exception for listing endpoints that can potentially return large datasets.
- Improve error responses with clear error messages and HTTP status codes.


## Author
Your Name (@PappuLaL)
