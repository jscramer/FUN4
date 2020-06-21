
package com.example.controller;

import com.example.repository.UserRepository;
import com.example.entity.User;
import com.example.entity.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/user")
@RestController
public class UserController {
    private UserRepository userRepository;

}


