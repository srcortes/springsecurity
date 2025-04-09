package springsecurity.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAsync
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    //@Bean
    /*public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    /**
     * It is a strategy to use passwordEncoder, it is a replacement method above
     * @return
     */
   @Bean
    public PasswordEncoder passwordEncoder(){
       //This part is optional more or less is something customization
        /*Map<String, PasswordEncoder> encoder = new HashMap<>();

        encoder.put("noop", NoOpPasswordEncoder.getInstance());
        encoder.put("bcrypt", new BCryptPasswordEncoder());
        encoder.put("scrypt", new SCryptPasswordEncoder());

        System.out.println(encoder);
        return new DelegatingPasswordEncoder("bcrypt", encoder);*/
       PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

       return passwordEncoder;
    }

  /**
   * This bean is used to test InheritableThreadLocal, this way
   * By default spring use ThreadLocal it mean have thread per request
   * @return
   */
  @Bean
    public InitializingBean initializingBean() {
    return () -> SecurityContextHolder.setStrategyName(
        SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
   httpSecurity.httpBasic(c->{
     c.realmName("OTHER");
     c.authenticationEntryPoint(new CustomEntryPoint());
   });
   httpSecurity.authorizeRequests().anyRequest().authenticated();
  }
}
