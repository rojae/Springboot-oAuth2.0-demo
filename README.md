### Standalone Authorization Server

This Authorization Server complies to OAuth2 standards, providing bare minimum sign up and token issuance. Client applications bearing `access token` may request access to Resources. 

### Basic Flow

![Auth Flow](docs/spring-auth.png)


### Prerequisites

1.Gradle

Gradle is required to manage dependencies and to compile 


### Endpoints 

**Sign Up**

New users may Sign Up via `/api/auth/signup` endpoint. Required body parameters are to be sent as `x-www-form-urlencoded` including, `email` and `password`. Upon successful action, the Id of the user will be returned.

**Requesting Tokens**

`Access Tokens` and `Refresh Tokens` can be requested via `/oauth/tokens`.


