package com.My_Shopping.My_Shopping.controler;

import com.My_Shopping.My_Shopping.models.AppUser;
import com.My_Shopping.My_Shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class commonControler {
    @Autowired
    UserService userService;
    @PostMapping("/user/register")
    public String RegisterUser(@RequestBody AppUser appUser)
    {
           userService.registerUser(appUser);
           return "User got successfully saved";
    }
}
