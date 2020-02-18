# Payloads

-   RepositoryPayload
    -   id : Long
    -   name : String
    -   ownerPayload : OwnerPayload
    -   description : String
    -   forks : Long
    -   watchers : Long
    -   htmlUrl : String
    -   stars : Long
    -   createdAt : Date


-   OwnerPayload
    -   username : String
    -   avatarUrl : String


-   UserPayload
    -   id : Long
    -   username : String
    -   name : String
    -   avatarUrl : String
    -   publicRepositories : Long
    -   followers : Long
    -   htmlUrl : String
    -   createdAt : Date