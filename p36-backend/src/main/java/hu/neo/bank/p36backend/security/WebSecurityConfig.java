package hu.neo.bank.p36backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/api/user/hello")
                        .permitAll()
                    .antMatchers("api/user/registration")
                        .permitAll()
                    .anyRequest().authenticated()
                    .and()

                .httpBasic()
                    .and()
                .headers()
                    .frameOptions()
                        .disable()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
/*
                .cors()
                    .and()
                .csrf().disable()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .httpBasic()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        /*String hashedPassword = passwordEncoder().encode("duck");
        System.out.println(hashedPassword);
        auth
                .inMemoryAuthentication()
                .withUser("user").password(hashedPassword).roles("USER");*/
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
