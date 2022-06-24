# InterProbe-Java-Spring-Bootcamp First Homework

### About the project

**Products Service** was developed for product operations.

You can list,  add, update, delete the product.

Listing reviews for a product

List comments made to a specific product in the given date ranges

List comments made by a user

List products that have not expired

List expired products

Show comments made by a user within a certain date range





Tech Stack:
* [Java     13](#) * [Spring Boot](#)
* [Spring DataJpa](#) * [H2 Database](#)
* [ModelMapper](#)
* [Git](#) * [Liquibase](#)
* [Swagger](#)

### Run Swagger
> `http://localhost:8089/v3/api` will run 

### Database
> `http://localhost:8089/h2-console`


### Project run with Maven
1. go to this github adress git clone https://github.com/...
2. mvn clean install
3. mvn springboot:run

> `http://localhost:8089` will run that port

## HTTP Client Structure

|      Controller          | Metot  |                  Adres                   |                  Description                   |
| :-------------------:    |:------:|:----------------------------------------:|:----------------------------------------------:|
|  **ProductController**   |  GET   |         localhost:8089/products          |             Will List All products             |
|                          |  GET   |       localhost:8089/products/{id}       |            will get product with id            |
|                          |  POST  |         localhost:8089/products          |                create a product                |
|                          |  PUT   |       localhost:8089/products/{id}       |          will update product with id           |
|                          | DELETE |       localhost:8089/products/{id}       |          will delete product with id           |
|                          |  GET   |  localhost:8089/products/expirationDate  |           will list expired products           |
|                          |  GET   | localhost:8089/products/noExpirationDate |    will list products that have not expired    |


|         Controller          | Metot |                                       Adres                                       |                                     Description                       |
|:---------------------------:|:-----:|:---------------------------------------------------------------------------------:|:---------------------------------------------------------------------:|
| **ProductReviewController** |  GET  |                   localhost:8089/comments/products/{productId}                    |                           Will list reviews for a product             |
|                             |  GET  |                      localhost:8089/comments/users/{userId}                       |                      It will list the comments made by a user         |
|                             |  GET  |           localhost:8089/comments/product/{productId}/startDate/endDate           |      It will show comments made to a specific product in the given date ranges |
|                             |  GET  |                             localhost:8089/comments/user/{userId}/startDate/endDate                              |    It will show the comments made by a user within a certain date rang|



|     Controller     | Metot  |            Adres             |       Description        |
|:------------------:|:------:|:----------------------------:|:------------------------:|
| **UserController** |  GET   |     localhost:8089/users     |   Will List All users    |