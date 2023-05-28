package com.bankapp.web.api;

import com.bankapp.config.JwtService;
import com.bankapp.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    ///authenticate
    @PostMapping("authenticate")
    public String authenticate( @RequestBody AuthRequest authRequest){

        Authentication authentication=authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else{
            throw  new UsernameNotFoundException("user is invalid");
        }

    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @PreAuthorize("hasAuthority('ROLE_MGR')")
    @GetMapping("mgr")
    public String mgr(){
        return "mgr";
    }
    @PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    @GetMapping("clerk")
    public String clerk() {
        return "clerk";
    }
}
