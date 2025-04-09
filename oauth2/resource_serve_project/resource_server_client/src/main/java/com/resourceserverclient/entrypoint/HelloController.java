package com.resourceserverclient.entrypoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "${api.url.hello}")
    public String hello(){
        return "Hello";
    }
}
