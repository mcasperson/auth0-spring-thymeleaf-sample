To run the application, set the following environment variables:

* `CLIENT_SECRET`: Auth0 Application client secret
* `CLIENT_ID`: Auth0 Application client ID
* `DOMAIN`: Auth0 Application domain e.g. `yourname.auth0.com`
* `AUDIENCE`: The audience of the external API e.g. `ktordemo`
* `EXTERNALAPI`: The host and IP address of the external API e.g. `localhost:6060`

Run the application with the following bash:

```bash
export CLIENT_ID=ClientIDGoesHere
export CLIENT_SECRET=ClientSecretGoesHere
export DOMAIN=ApplicationDomainGoesHere
export AUDIENCE=AudienceGoesHere
export EXTERNALAPI=localhost:6060
./mvnw spring-boot:run
```

Or the following Powershell:

```powershell
$env:CLIENT_ID="ClientIDGoesHere"
$env:CLIENT_SECRET="ClientSecretGoesHere"
$env:DOMAIN="ApplicationDomainGoesHere"
$env:AUDIENCE="AudienceGoesHere"
$env:EXTERNALAPI="localhost:6060"
.\mvnw spring-boot:run
```

An example external API can be found at https://github.com/mcasperson/Auth0Ktor.