package com.ravali.oauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/api/private")
    @PreAuthorize("hasAuthority('create_profile')")
    public String getCompany() {
        return "Authentication Successfull";
    }
}
