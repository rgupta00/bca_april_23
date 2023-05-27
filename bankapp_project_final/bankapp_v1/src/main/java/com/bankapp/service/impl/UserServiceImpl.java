package com.bankapp.service.impl;

import com.bankapp.entities.UserEntity;
import com.bankapp.repo.UserRepo;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity findByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userRepo.save(userEntity);
    }
}
