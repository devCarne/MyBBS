package com.example.mybbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class MyBbsDTO {
    int num;
    String title;
    String writer;
    String content;
    Date regDate;
    int replyCnt;
}
