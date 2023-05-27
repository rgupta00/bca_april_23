package com.bankapp.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {
    //called by spring sec
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logic service layer and dao layer
        //we get our own user , then i need to covert that user to the user witch spring sec understand... User
        return new User("raj", "raj123", AuthorityUtils.createAuthorityList("ROLE_MGR"));
    }
}
