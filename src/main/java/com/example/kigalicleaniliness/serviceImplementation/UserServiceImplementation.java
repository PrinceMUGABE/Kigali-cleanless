package com.example.kigalicleaniliness.serviceImplementation;

import com.example.kigalicleaniliness.model.UserModel;
import com.example.kigalicleaniliness.repository.UserRepository;
import com.example.kigalicleaniliness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository repo;
    @Override
    public UserModel saveUser(UserModel user) {
        return repo.save(user);
    }

    @Override
    public UserModel findUserById(int code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel savedUser = repo.findById(user.getId()).orElse(null);
        if (savedUser!=null){
            UserModel updateUser = new UserModel();
            updateUser.setUsername(user.getUsername());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());

            return repo.save(updateUser);
        }else {
            return repo.save(user);
        }
    }

    @Override
    public List<UserModel> listUsers() {
        return repo.findAll();
    }

    @Override
    public void deleteUser(int code) {
        UserModel savedUser = repo.findById(code).orElse(null);
        if (savedUser!=null){
            repo.delete(savedUser);
        }
    }

    @Override
    public UserModel findUserByUsername(UserModel user) {
        return repo.findByUsername(user);
    }
}
