package com.crud.service;

import com.crud.entities.User;
import com.crud.exception.ResourceAlreadyExistException;
import com.crud.exception.UserNotFoundException;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user)  {
        if(userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new ResourceAlreadyExistException(user.getEmail());
        }
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
    public Optional<User>getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public Optional<User>getUserById(String id)
    {
        if(!userRepository.findById(id).isPresent())
        {
            throw new UserNotFoundException(id);
        }
        return userRepository.findById(id);
    }
    public void updateUser(User user)
    {
        userRepository.save(user);
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }
    public void deleteUser(String id)
    {
        userRepository.deleteById(id);
    }
}



