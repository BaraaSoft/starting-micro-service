package com.baraabytes.app.ws.controller;

import com.baraabytes.app.ws.request.UserRequest;
import com.baraabytes.app.ws.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers(
            @RequestParam(
                    value = "page",
                    defaultValue = "1" // this will prevent 404 when page param isn't provided
            ) int page,
            @RequestParam(
                    value = "limit",
                    defaultValue = "50"
            ) int limit
    ){
        String message = String.format("all the %d users from page = %d ",limit,page);
        return message;
    }


    @GetMapping(
            path = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserResponse> getUser(
            @PathVariable String userId){
        UserResponse user = new UserResponse();
        user.setUserId(userId);
        user.setEmail("baraaabuzeid@hotmail.com");
        user.setFirstname("BR");
        user.setLastname("Longer");
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity(user, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        UserResponse user = new UserResponse();
        user.setUserId(UUID.randomUUID().toString());
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        return new ResponseEntity<UserResponse>(user,HttpStatus.CREATED);
    }

    @PutMapping
    public String updateUser(){
        return  "update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user";
    }

}
