package com.giodad.lil.roomwebapp.ops;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "greeting")
public class GreetingEndpoint {

    @ReadOperation
    public String getGreeting() {
        return "Hello Spring Boot from actuator";
    }
}
