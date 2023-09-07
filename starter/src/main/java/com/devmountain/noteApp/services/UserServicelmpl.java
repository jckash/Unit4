package com.devmountain.noteApp.services;

import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServicelmpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

@Override
@Transactional
    public ArrayList<String> addUser(UserDto userDto){
        ArrayList<String> response = new ArrayList<>();
        User user = new User(UserDto);
        userRepository.saveAndFlush(user);
        response.add("User Added Successfully");
        return response;
    }

    @Override
    @Transactional
    public ArrayList<String> userLogin(UserDto userDto){
    ArrayList<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findbyUsername(userDto.getUsername());
        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("User Login Successful");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else { response.add("Username or password incorrect");
    } return response;
}
