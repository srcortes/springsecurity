package springsecurity.controller;

import java.util.concurrent.ExecutionException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springsecurity.service.PassengerInformationUpdate;
import springsecurity.service.PassengerOperationExecutor;
import springsecurity.service.ServiceExample;

@RestController
@AllArgsConstructor
public class HelloController {

    private final ServiceExample serviceExample;

    private final PassengerOperationExecutor passengerOperationExecutor;
    private final PassengerInformationUpdate passengerInformationUpdate;
    @GetMapping("/Hello")
    public String hello() throws Exception {
        return "Hello " + "..." +  serviceExample.testing("...").get();
    }

    @GetMapping("/HelloV2")
    public String hellov2() throws Exception {
       return serviceExample.newTesting();
    }


}
