# Movies

Simple application for managing movies.

## How to use REST endpoints?

* to add some movie please use PUT request in JSON format:

```
{
	"title": "Shrek",
	"rate": 7.8,
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
  
## Responses for add movie:
  * success - When movie has been added correct then true, if not then false
  * movieFailureResultReason - Occurs only when failure, possible causes of failure:
  * * INVALID_TITLE_MOVIE - Title must have at least 3 characters up to 50 and can contain only letters.
  * * MOVIE_WITH_TITLE_ALREADY_EXISTS - Occurs when added movie title already exists.
  
