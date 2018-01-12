# Movies

Simple application for managing movies. You can add movies with details like your rating, actors and director information. You can also managing added earlier movies(delete, get all movies sorted by rating).

## Installation

* Create Postgres database and run migration from file 'postgres_database_migration.sql'.
* Create 'config' directory in root project path.
* Create in 'config' directory file 'application.properties' with database credential properties: 

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
  * success - when movie has been added correctly then true, if not then false.
  * movieFailureResultReason - occurs only when failure, possible causes of failure:
  * * INVALID_TITLE_MOVIE - title must have at least 3 characters up to 50 and can contain only letters.
  * * INVALID_MOVIE_RATING - ratio must have exists and be correctly filled(numeric value).
  * * MOVIE_WITH_TITLE_ALREADY_EXISTS - occurs when added movie title already exists.
