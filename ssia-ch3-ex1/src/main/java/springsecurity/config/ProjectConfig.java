package springsecurity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springsecurity.model.User;
import springsecurity.service.InMemoryUserDetailsService;

import java.util.List;

@Configuration
public class ProjectConfig {
    //We are comment this part to work with datasource, but to reminder
    //It is a way to work with spring security
    @Value("${data.userName}")
    private String userName;

    @Value("${data.password}")
    private String password;

    @Value("${data.allow}")
    private String permission;

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = new User(userName, password, permission);
        List<UserDetails> userDetails = List.of(user);

        return new InMemoryUserDetailsService(userDetails);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
