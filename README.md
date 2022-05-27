# POKEMON API

## Description
This file has been created with the aim of meeting the challenge proposed by the Modyo company for the position of java developer.

## Environment deployed
The application was deployed at https://json-pokemon-api.herokuapp.com

### Reference
To deploy, this guide was followed: 
- https://itquetzali.com/2019/03/10/api-rest-usando-spring-boot-y-mongodb-y-desplegar-en-heroku/

### Contract
To see the contract with the different services created go to: https://json-pokemon-api.herokuapp.com/swagger-ui.html

## Challenge to resolve
For the back-end, it is requested to build a REST API using Java Spring Boot that exposes the information to the Pokedex.
This API must consume the PokeApi service https://pokeapi.co/ to get the information. Documentation can be found at https://pokeapi.co/docs/v2

From the frontend side we will only need the different calls by curl or postman (this is part of the deliverable) to the exposed APIs and to be able to obtain for each of the pokemons (photo and its basic information):
- Type (type)
- Weight
- List of Skills (ability)

Also, when you click on one, its descriptive file should be displayed along with its photo and detailed information:
- Basic Information (the same as the list)
- Description
- Evolutions

- If you want (OPTIONAL) you can make a front-end that makes the calls mentioned above, and you can choose the language of your preference.

The application must be deployed on AWS, Azure, GCP or Heroku, at your choice. It is important that you document how the deployment is done. The application code must be hosted in some Git repository to which you must give us access.

Any extra functionality is welcome. Ideally, it is expected that the application has tests and that the responses of the Poke API are stored in a cache layer to improve the performance of the responses. you will have extra score!

What we will evaluate with this challenge is that you are able to:
- Integrate an external API.
- Expose a REST API.
- Consume API from front-end (optional)
- Deploy to the cloud.
- Handle errors.
- Maintain an orderly and quality code.
 
Please upload the challenge through a public repository, thanks!