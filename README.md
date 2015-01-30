# spring-boot-autoconfigure
[![Build Status](https://travis-ci.org/arhs/spring-boot-autoconfigure.svg)](https://travis-ci.org/arhs/spring-boot-autoconfigure) for Travis CI passing

Auto-configuration classes for a [Spring Boot](http://projects.spring.io/spring-boot/) project.

## Usage
Add the following dependency to your **pom.xml** file:

```xml
<dependency>
    <groupId>com.arhs.spring.boot.autoconfigure</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>
```

The following auto-configurations are included so far:
* [Jongo](http://jongo.org/)
* [Twilio](https://www.twilio.com)

### Twilio auto-configuration

To use the Twilio auto-configuration, you must annotate your field with the **Autowired** annotation and add the configuration of your properties file. Here's an example:

In the file that contains an instance of the class:
```java
class HomeController {
    @Autowired
    private TwilioService twilioService;
}
```

In the properties file (located in the **resources** directory):
```yml
twilio:
  accountSID: MY_ACCOUNT_SID
  authToken: MY_AUTHENTICATION_TOKEN
```

### Jongo auto-configuration
In the file that contains an instance of the class:
```java
class HomeController {
    @Autowired
    private Jongo jongo;
}
```

Configuration of the Jongo auto-configuration in the application.yml file:
```yml
spring:
  data:
     mongodb:
        database: MY_DATABASE_NAME
```

## Copyright and license

> The MIT License (MIT)
>
> Copyright (c) 2015 ARHS Developments SA
>
> Permission is hereby granted, free of charge, to any person obtaining a copy of
> this software and associated documentation files (the "Software"), to deal in
> the Software without restriction, including without limitation the rights to
> use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
> the Software, and to permit persons to whom the Software is furnished to do so,
> subject to the following conditions:
>
> The above copyright notice and this permission notice shall be included in all
> copies or substantial portions of the Software.
>
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
> FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
> COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
> IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
> CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
