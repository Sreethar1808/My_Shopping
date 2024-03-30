package com.My_Shopping.My_Shopping.service;


import com.My_Shopping.My_Shopping.Repository.UserRepository;
import com.My_Shopping.My_Shopping.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void registerUser(AppUser appUser)
    {
          userRepository.save(appUser);
    }

    public AppUser getUserId(UUID id)
    {
        AppUser user = userRepository.findById(id).orElse(null);
        return user;
    }
}
