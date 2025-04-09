package springsecurity.service;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class PassengerInformationUpdate implements CommandPassenger{
  private String orderId;

  @Override
  public void execute() {
    System.out.println(orderId);

  }
}
