package com.example.mybbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyBbsUserDTO {
    String id;
    String pw;
    String name;
}
