# Sample app that leverage oauth route service

This project is a simple Spring Boot[b] application.  That dumps out the headers passed to the application.

## Requirements
### Java, Maven
The application is written in Java 8 and packaged as a self executable JAR file. This enables it to run anywhere that Java is available.

## Deployment
_The following instructions assume that you have [created an account][c] and [installed the `cf` command line tool][i]._

In order to automate the deployment process as much as possible, the project contains a Cloud Foundry [manifest][y].  To deploy run the following commands:
```bash
$ ./mvnw clean package
$ cf push
```

Assuming that the route service has been deployed and a user provided service has been created with steps in README (https://github.com/pivotalservices/oauth-route-service/blob/master/README.md)

The next step assumes that you have an application already running that you'd like to bind this route service to.  To do this, run the following command, substituting the domain and hostname bound to that application:
```bash
$ cf bind-route-service <APPLICATION-DOMAIN> test-route-service --hostname <APPLICATION-HOST>
```

Invoking the sample application after route service is bound will add additional headers that are visible by going to https://<APPLICATION-HOST>/<APPLICATION-DOMAIN>

## License
The project is released under version 2.0 of the [Apache License][a].


[a]: http://www.apache.org/licenses/LICENSE-2.0
[b]: http://projects.spring.io/spring-boot/
[c]: https://console.run.pivotal.io/register
[i]: http://docs.run.pivotal.io/devguide/installcf/install-go-cli.html
[r]: http://docs.cloudfoundry.org/services/route-services.html
[y]: manifest.yml
# sample-webapp-using-outh-route-service
