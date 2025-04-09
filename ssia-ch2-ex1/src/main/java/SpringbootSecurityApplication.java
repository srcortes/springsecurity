import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"springsecurity"})
public class SpringbootSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class);
    }
}
