package com.bankapp.config;

import com.bankapp.entities.UserEntity;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//I dont care how u write ur dao layer , server
@Service
public class DetailService implements UserDetailsService {
    //called by spring sec
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userService.findByUsername(username);
        if(userEntity==null){
            throw new UsernameNotFoundException("user is invalid");
        }
        //then somehow we need to convert UserEntity to the user that spring sec understand
        ///userEntity ---> User
        //u can create a impl of a class UserDetails
        return  new SecUser(userEntity);
    }
}
