package com.example.mybbs.service;

import com.example.mybbs.dao.MyBbsUserDAO;
import com.example.mybbs.dto.MyBbsUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBbsUserService {

    @Autowired
    private MyBbsUserDAO dao;

    public boolean signUp(String id, String pw, String name) {
        MyBbsUserDTO user = new MyBbsUserDTO(id, pw, name);
        return dao.signUp(user);
    }

    public MyBbsUserDTO signIn(String id, String pw) {
        MyBbsUserDTO user = dao.signIn(id);

        if(user == null) {
            return null;
        } else {
            if (user.getPw().equals(pw)) {
                return user;
            } else {
                return null;
            }
        }
    }
}
