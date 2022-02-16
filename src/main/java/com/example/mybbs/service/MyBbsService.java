package com.example.mybbs.service;

import com.example.mybbs.dao.MyBbsDAO;
import com.example.mybbs.dto.MyBbsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MyBbsService {

    @Autowired
    private MyBbsDAO dao;

    public List<MyBbsDTO> getList() {
        return dao.getList();
    }

    public List<MyBbsDTO> searchTitle(String title) {
        return dao.searchTitle(title);
    }

    public List<MyBbsDTO> searchWriter(String writer) {
        return dao.searchWriter(writer);
    }

    public boolean write(String title, String writer, String content) {
        MyBbsDTO dto = new MyBbsDTO(0, title, writer, content, new Date(System.currentTimeMillis()), 0);
        return dao.write(dto);
    }

    public MyBbsDTO read(int num) {
        return dao.read(num);
    }

    public boolean update(int num, String title, String content) {
        return dao.update(num, title, content);
    }

    public boolean delete(int num) {
        return dao.delete(num);
    }
}
