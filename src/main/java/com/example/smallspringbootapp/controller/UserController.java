package com.example.smallspringbootapp.controller;

import com.example.smallspringbootapp.model.request.CreateUserRequest;
import com.example.smallspringbootapp.model.response.UserResponse;
import com.example.smallspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public UserResponse findById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping(value = "/{userId}", consumes  = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse update(@PathVariable Long userId, @RequestBody CreateUserRequest request) {
        return userService.update(userId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }


}
