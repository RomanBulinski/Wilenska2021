package rom.buulean.wilenska2021backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Wilenksa2021SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .mvcMatchers(HttpMethod.GET,"/resolutions/**").hasAnyRole("USER1","ADMIN1")
                .mvcMatchers(HttpMethod.GET,"/realEstates/**").hasRole("ADMIN1")
                .mvcMatchers(HttpMethod.GET,"/owners/**").hasRole("ADMIN1")
                .antMatchers("/login", "/start", "/userLogger", "/userRole").permitAll()
                .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                    .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("{noop}user1")
                .roles("USER1")
                .and()
                .withUser("admin1")
                .password("{noop}admin1")
                .roles("ADMIN1");
    }
}
