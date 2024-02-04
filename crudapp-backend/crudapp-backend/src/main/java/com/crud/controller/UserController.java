package com.crud.controller;

import com.crud.entities.User;
import com.crud.exception.UserNotFoundException;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId)
    {
        return userService.getUserById(userId)
                .orElseThrow(()->new UserNotFoundException(userId));
    }
    @GetMapping()
    public ResponseEntity<List<User>>getAllUser()
    {
        List<User> listOfUsers=userService.findAll();
        return ResponseEntity.ok(listOfUsers);
    }

    @PutMapping("/update/{userId}")
    public String updateUser(@PathVariable("userId") String userId,@RequestBody User user)
    {
        Optional<User> userOptional=userService.getUserById(userId);

            User user1=userOptional.get();
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setGender(user.getGender());
            userService.updateUser(user);
            return ("User updated successfully");

    }

    @DeleteMapping("/remove/{userId}")
    public String deleteUser(@PathVariable String userId)
    {
        Optional<User>userOptional=userService.getUserById(userId);
        if(userOptional.isPresent())
        {
            userService.deleteUser(userId);
            return ("User deleted successfully");
        }
        else throw new UserNotFoundException(userId);
    }
}
