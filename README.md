This is sample application developed for learning purpose. Please follow below steps to setup or run the app in local.

Techstack:
-----------------------
Spring Boot - 3.1.4
Maven - 3.9.4
springdoc-openapi - 2.2.0
PostgreSQL - 42.6.0

Checkout the repository to local and import the project to your favorite IDE. Run the BlokGPtApplication.

OpenAPI URL:
http://localhost:8080/blokGPT/v3/api-docs

Swagger URL:
http://localhost:8080/blokGPT/swagger-ui/index.html

Docker commands:

Create the image:
---------------------
`docker build -t blokgpt .`

Start the application:
-----------------------
`docker run -p 8080:8080 blokgpt `

Using docker-compose 

`docker-compose up`

after closing 

`docker-compose down`