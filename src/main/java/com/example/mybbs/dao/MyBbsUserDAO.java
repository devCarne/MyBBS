package com.example.mybbs.dao;

import com.example.mybbs.dto.MyBbsUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyBbsUserDAO {

    boolean signUp(MyBbsUserDTO user);

    MyBbsUserDTO signIn(String id);
}
