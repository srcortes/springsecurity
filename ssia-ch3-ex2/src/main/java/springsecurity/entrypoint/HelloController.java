package springsecurity.entrypoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "${api.url.helloController}")
    public String hello(){
        return  "Hello  - ssia-ch3-ex2";
    }

}
