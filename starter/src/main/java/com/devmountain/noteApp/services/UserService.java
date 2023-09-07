package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UserService {
    @Transactional
    ArrayList<String> addUser(UserDto userDto);

    @Transactional
    ArrayList<String> userLogin(UserDto userDto);
}
