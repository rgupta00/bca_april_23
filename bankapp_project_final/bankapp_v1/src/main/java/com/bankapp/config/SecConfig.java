package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity(debug = true)
//                              some sp regex   , works when method finished but returing a object
//Method level sec: @Secure, [@PreAuthrized , @PostAuthorized], @RoleAllowed(EJB)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMethodSecurity
public class SecConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthentationFilter jwtAuthentationFilter;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(encoding());
        return  provider;
    }

    @Bean
    public PasswordEncoder encoding(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws  Exception{
        return
                httpSecurity.csrf()
                        .disable()
                        .authorizeHttpRequests()
                        .requestMatchers("/home","/authenticate","/register").permitAll()
                        .and()
                        .authorizeHttpRequests().requestMatchers("/**").authenticated()
                        .and()
                        .httpBasic()
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .authenticationProvider(authenticationProvider())
                        .addFilterBefore(jwtAuthentationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
    }


    //Authenticationmanager

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationManager)throws Exception{
        return authenticationManager.getAuthenticationManager();
    }


}

















