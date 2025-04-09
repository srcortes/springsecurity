package springsecurity.service;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PassengerOperationExecutor {

  public void executeCommandPassenger(CommandPassenger commandPassenger) {
    commandPassenger.execute();
  }

}
