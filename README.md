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

To use a auto-configuration class, you must annotate your field annotation "Autowired" and add the configuration of your properties file. Here's an example:

```java
class HomeController {
    @Autowired
    private TwilioService twilioService;
}
```

```yml
twilio:
  accountSID: MY_ACCOUNT_SID
  authToken: MY_AUTHENTICATION_TOKEN
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
