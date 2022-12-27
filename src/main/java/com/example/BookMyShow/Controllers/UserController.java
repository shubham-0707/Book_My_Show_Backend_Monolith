package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody()UserEntryDTO userEntryDTO){
        userService.addUser(userEntryDTO);

        return new ResponseEntity("The user is added successfully" , HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int id){
        return new ResponseEntity(userService.getUser(id) , HttpStatus.OK);
    }
 }
