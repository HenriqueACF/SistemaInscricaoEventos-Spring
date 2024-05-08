# Endpoints:

#### POST
- https://localhost:8090/api/send

{
"to": "emailTeste@gmail.com",
"subject": "teste",
"body": "teste"
}
 

- https://localhost:8080/events/{id}/upcoming
{"participantEmail": "henrique@gmail.com""}

{
"maxParticipants": 20,
"registeredParticipants": 0,
"date": "08/05/2024",
"title": "title teste",
"description": "description teste"
}



#### GET

- https://localhost:8080/events
- https://localhost:8080/events/upcoming

