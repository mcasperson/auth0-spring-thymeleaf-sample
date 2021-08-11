package com.matthewcasperson.auth0demo.configuration;

import com.matthewcasperson.auth0demo.oauth.CustomAuthorizationRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@EnableWebSecurity
@Configuration
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/*.js", "/*.css").permitAll()
                .anyRequest().authenticated()
            .and()
            .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestResolver(
                        new CustomAuthorizationRequestResolver(
                                clientRegistrationRepository, "/oauth2/authorization"));
    }
}
