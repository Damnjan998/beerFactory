# <i>Beer Factory</i>


### <u>GitHub repository</u>

* [BeerFactory on GitHub](https://github.com/Damnjan998/beerFactory)
  

### <u>Technologies</u>
* [Java 11]()
* [MySQL]()
* [RestTemplate]()  
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)


### <u>Introduction</u>

BeerFactory is an API that handles 4 endpoints.</br>
GET Endpoint for fetching all beer records from database.</br>
GET Endpoint for getting one beer record with specified ID.</br>
DELETE Endpoint for deleting beer record with specified ID.</br>
POST Endpoint for inserting beer record from another API using RestTemplate.


### <u>Curl Commands</u>

#### Get All curl command
curl http://localhost:8080/beers/ </br>
-H "Accept: application/json"

#### Get By ID curl command
curl http://localhost:8080/beers/{id} </br>
-H "Accept: application/json"

#### Post curl command
curl -X POST http://localhost:8080/beers/

#### Delete By ID curl command
curl -X DELETE http://localhost:8080/beers/{id}


###<u>Choices for technologies</u>
I chose to work with MySQL database, because I wanted to take some challenge for myself.
In my earlier projects I was using in memory database like H2, and that is why I decided to use MySQL 
and gain some new knowledge and experience. Also, I wanted to use streams from Java 8 and learn them as much as possible. 


###<u>Things I would do differently second time</u> 

For my second time around, I would add Unit table to database to reduce redundant fields. </br> 
Also, I would implement search, paging and sorting for application. </br>
Also, I would do pairing good beers with provided food, and this would also make database a bit different.


##Author 
####Damnjan Askovic




