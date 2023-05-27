package com.bankapp.web.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

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
    public String clerk(){
        return "clerk";
    }
}
