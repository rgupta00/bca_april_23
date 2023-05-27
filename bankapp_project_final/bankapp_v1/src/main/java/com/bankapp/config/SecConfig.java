package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
//                              some sp regex   , works when method finished but returing a object
//Method level sec: @Secure, [@PreAuthrized , @PostAuthorized], @RoleAllowed(EJB)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    //401
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //  AuthenticationManager pr= auth.inMemoryAuthentication().and().build();

        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication()
//                .withUser("raj").password("raj123").roles("MGR")
//                .and()
//                .withUser("ekta").password("ekta123").roles("CLERK");
    }

    //password encoding
    @Bean
    public PasswordEncoder encoding(){
        return NoOpPasswordEncoder.getInstance();
    }
    //403


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                //.antMatchers("/home/**").permitAll()
                .authorizeRequests().anyRequest().authenticated()

                .and()
//                .antMatchers("/mgr/**").hasAnyRole("MGR")
//                .antMatchers("/clerk/**").hasAnyRole("MGR", "CLERK")

                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}

















