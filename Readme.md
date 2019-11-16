# Spring Boot APIs using JWT

This is a microservice that exposes following endpoints

Public APIs
```
authenticate
signUp
h2-console
```

Authenticated APIs
```
hello
getUserDetails
updateUserDetails
```


## Usage

```
Clone the repo
Open in intelliJ
Build the project
Now try accessing the APIs using postman
```

# Login/Authenticate API Request
```
http://localhost:8080/authenticate
Content-Type: application/json
POST
Body
```
```JSON
{
	"email": "sajal@gmail.com",
	"password": "123"
}
```

# SignUp API Request
```
http://localhost:8080/signUp
Content-Type: application/json
POST
Body
```
```JSON
{
	"email": "sajal1@gmail.com",
	"password": "123",
	"name": "sajal"
}
```

# Get user Details API Request
```
http://localhost:8080/getUserDetails
Content-Type: application/json
GET
Body
```

# Update user Details API Request
```
(User won't be able to update the email)
http://localhost:8080/updateUserDetails
Content-Type: application/json
PUT
Body
```
```JSON
{
	"email": "sajal1@gmail.com",
	"password": "123",
	"name": "sajal"
}
```