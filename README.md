# Movies

Simple application for managing movies. You can add movies with details like your rating, actors and director information. You can also managing added earlir movies(delete, get all movies sorted by rating).

## Installation

Create database in Postgres and run migration which is in file 'postgres_database_migration.sql'.
Create 'config' directory in root path project and create inside 'config' file application.properties with database credential properties: 

```
spring.datasource.url =
spring.datasource.username =
spring.datasource.password =
```
fill correctly above properties.

## How to use REST endpoints?
Controller is mapping request on "/movies", for example http://sebastian.opacki.pl/movies
* to add some movie please use PUT request in JSON format```

```
{
	"title": "Shrek",
	"rating": 7.8,
	"actors": ["Mike Myers", "Eddie Murphy"],
	"director": "Andrew Adamson"
}
```

* to delete selected movie, please use DELETE request with movie ID to remove:
```
{
	"id": 47
}
```

* to get all movies sorted by rating please use GET request.
  
## Responses for add movie request:
  * success - When movie has been added correct then true, if not then false
  * movieFailureResultReason - Occurs only when failure, possible causes of failure:
  * * INVALID_TITLE_MOVIE - Title must have at least 3 characters up to 50 and can contain only letters.
  * * MOVIE_WITH_TITLE_ALREADY_EXISTS - Occurs when added movie title already exists.
  
