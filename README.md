# Simple CRUD operations & Security
This project covers basic CRUD operations and Restrict Access Based On Roles using Spring Security
## Features
- The project is implemented using the Controller-Service-Repository pattern.
- Implements the DTO pattern using ModelMapper.
- Uses MYSQL as a database.
- The project utilizes a custom authentication system with bcrypt-encrypted passwords and role-based access restrictions. User roles and passwords are managed in the project's database.

| HTTP METHOD | Endpoint          | CRUD        | Role     |
|-------------|-------------------|-------------|----------|
| GET         | /api/persons      | Read All    | EMPLOYEE |
| GET         | /api/person/{id}  | Read Single | EMPLOYEE |
| POST        | /api/persons      | Create      | MANAGER  |
| PUT         | /api/persons      | Update      | MANAGER  |
| DELETE      | /api/persons/{id} | Delete      | ADMIN    |

## Database schema
![schema](https://github.com/alpersener/crudandsec/blob/master/database.jpg)


## Endpoints
### GET 

Example request endpoint

```
https://api.example.com/api/persons
https://api.example.com/api/persons/{id}

```
Returns:
```
{
"id": 1,
"firstName": "example",
"lastName": "example",
"email": "example@example.com",
"personDetail": {
    "id": 1,
    "gender": "male",
    "age": 25
        }
    }
```
### POST
Example request endpoint

```
https://api.example.com/api/persons

```

Returns:

```
{
"firstName": "example",
"lastName": "example",
"email": "example@example.com",
"personDetail": {
    "gender": "male",
    "age": 25
        }
    }
```
### PUT
Example request endpoint

```
https://api.example.com/api/persons

```

Returns:

```
{
"id":1,
"firstName": "example",
"lastName": "example2",
"email": "example2@example.com",
"personDetail": {
    "id":1,
    "gender": "male",
    "age": 25
        }
    }
```
### DELETE

Example request endpoint

```
https://api.example.com/api/persons/{id}
```






