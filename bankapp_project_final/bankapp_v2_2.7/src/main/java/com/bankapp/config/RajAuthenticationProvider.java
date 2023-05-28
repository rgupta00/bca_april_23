//package com.bankapp.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RajAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        UserDetails userDetails=userDetailsService.loadUserByUsername(authentication.getName());
//        if (userDetails != null) {
//            return new UsernamePasswordAuthenticationToken(
//                    authentication.getName(),
//                    authentication.getCredentials(),
//                    authentication.getAuthorities());
//        } else {
//            throw new BadCredentialsException("Incorrect user credentials !!");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication
//                .equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
//
//
//
//
