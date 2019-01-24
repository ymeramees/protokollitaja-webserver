# Protokollitaja Webserver
Back end server for shooting sport ranking and results display software [Protokollitaja](https://github.com/ymeramees/protokollitaja) and results [webpage](http://web.zone.ee/protokollitaja/).

### Main Features
* REST API to upload results from Protokollitaja and serve them to the webpage
* Read and write competition data from MongoDB
* Password authentication for uploading
* Embedded Tomcat server for easy deployment

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)

### Installing/Deploying
Standard Spring Boot procedure:
on Linux or Mac: `mvn spring-boot:run`
on Windows: `mvnw spring-boot:run`

## License

This project is licensed under the AGPLv3 License - see the [LICENSE.md](LICENSE.md) file for details
