package com.baraabytes.photoapp.api.users.ui.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(value = {"/status","status/check"})
    public ResponseEntity getUser(){
        String str = "Yes from users service!";
        return ResponseEntity.ok(str);
    }
}
