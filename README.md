To run the application, set the following environment variables:

* `CLIENT_SECRET`: Auth0 Application client secret
* `CLIENT_ID`: Auth0 Application client ID
* `DOMAIN`: Auth0 Application domain e.g. `yourname.auth0.com`
* `AUDIENCE`: The audience of the external API e.g. `ktordemo`
* `EXTERNALAPI`: The host and IP address of the external API e.g. `localhost:6060`

To build and execute the application, run:

```
./mvnw spring-boot:run
```

An example external API can be found at https://github.com/mcasperson/Auth0Ktor.