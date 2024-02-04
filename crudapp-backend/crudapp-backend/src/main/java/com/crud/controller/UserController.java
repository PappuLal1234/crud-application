package com.crud.controller;

import com.crud.entities.User;
import com.crud.exception.UserNotFoundException;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody Map<String,String>loginRequest)
    {
        String email=loginRequest.get("email");
        String password=loginRequest.get("password");
        Optional<User>userOptional=userService.getUserByEmail(email);
        if(userOptional.isPresent())
        {
            User user=userOptional.get();
            if(user.getPassword().equals(password))
            {
                return ResponseEntity.ok("Login successfully");
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody User user) throws IllegalAccessException {
        User newUser=userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }
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

    @PutMapping("/{userId}")
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

        //else throw new UserNotFoundException(userId);
    }

    @DeleteMapping("/{userId}")
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
