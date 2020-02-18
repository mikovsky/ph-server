## Model
-   [x] Repository Model
-   [x] Owner Model
-   [X] User Model


## Payload
-   [x] Repository Payload
-   [x] Owner Payload
-   [x] User Payload


## Mappers
-   [x] RepositoryPayload to Repository
-   [x] OwnerPayload to Owner
-   [x] UserPayload to User


## DAO - Repositories & Services 
-   [x] Repository Repo
-   [x] Repository Service
-   [x] User Repo
-   [x] User Service


## Github API
-   [ ] get user with :username - GET /users/:username
-   [ ] get users repositories - GET /users/:username/repos


## Endpoints
-   [ ] Users
    -   [ ] get all users from database - GET /api/users
    -   [ ] add new user to database - POST /api/users/:username
        -   [ ] get User with :username via Github API
        -   [ ] map it and store it in database
    -   [ ] remove existing user from database - DELETE /api/users/:username
        -   [ ] delete user from database
        -   [ ] delete all its repositories from database
        
        
-   [ ] Repositories
    -   [ ] get all repositories from database - GET /api/repositories
    -   [ ] get all users repositories from database - GET /api/repositories/:username
