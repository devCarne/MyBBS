package com.example.mybbs.dao;

import com.example.mybbs.dto.MyBbsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyBbsDAO {

    List<MyBbsDTO> getList();

    List<MyBbsDTO> searchTitle(String title);

    List<MyBbsDTO> searchWriter(String writer);

    boolean write(MyBbsDTO dto);

    MyBbsDTO read(int num);

    boolean update(int num, String title, String content);

    boolean delete(int num);

    boolean addReply(int num, int replyCnt);
}
