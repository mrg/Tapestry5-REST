# Tapestry 5 REST

Just an example illustrating using Tapestry 5 with REST (specifically Tapestry-RESTEasy).

## Running

### Start the server

`mvn jetty:run`

### Say 'hi'

`curl -G http://localhost:8080/t5rest/rest/echo/hi`

### Fetch all people

`curl -G http://localhost:8080/t5rest/rest/people`

### Fetch person with id = 3

`curl -G http://localhost:8080/t5rest/rest/people/3`

### Fetch people with last name = 'smith'

`curl -G http://localhost:8080/t5rest/rest/people/lastname/smith`

### Update first name of person with id = 3

`curl -d 'id=3&firstName=Thomas' http://localhost:8080/t5rest/rest/people`

## Notes

Since this uses Tapestry, you can take advantage of Tapestry's live Java class reloading.
While the server is running, edit any of the `*Impl.java` classes (such as change a log statement)
and see the changes show up immediately without having to restart the server.
