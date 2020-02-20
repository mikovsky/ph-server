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
-   [x] get user with :username - GET /users/:username
-   [x] get users repositories - GET /users/:username/repos


## Endpoints
-   [x] Users
    -   [x] get all users from database - GET /api/users
    -   [x] add new user to database - POST /api/users/:username
        -   [x] get User with :username via Github API
        -   [x] map it and store it in database
    -   [x] remove existing user from database - DELETE /api/users/:username
        -   [x] delete user from database
        -   [x] delete all its repositories from database
        
        
-   [x] Repositories
    -   [x] get all repositories from database - GET /api/repositories
    -   [x] get all users repositories from database - GET /api/repositories/:username
    -   [x] force fetch of users repositories - GET /api/repositories/refresh/:username
    
    
## Task Scheduler
-   [ ] Repository Fetcher Task
    -   [ ] Fetch repositories for all users registered in database every 10 minutes
    -   [ ] Store repositories in database