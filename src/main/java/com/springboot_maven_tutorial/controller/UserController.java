package com.springboot_maven_tutorial.controller;


import com.springboot_maven_tutorial.dto.UpdateUserDto;
import com.springboot_maven_tutorial.dto.UserDto;
import com.springboot_maven_tutorial.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id) throws RuntimeException {
        return this.userService.getUserById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws RuntimeException{
        this.userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping()
    public UserDto addUser(@RequestBody UserDto userDto) throws RuntimeException {
        return this.userService.addUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PatchMapping("/{id}")
    public UserDto patchUser(@PathVariable("id") long id, @RequestBody UpdateUserDto updateUserDto) throws RuntimeException {
        return this.userService.patchUser(id, updateUserDto);
    }

    @Operation(description = "Returns page of users", summary = "Returns page of users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/page")
    public Page<UserDto> getUserPage(final Pageable pageable){
        return userService.getUserPage(pageable);
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() throws RuntimeException {
        return userService.getAllUsers();
    }




}





