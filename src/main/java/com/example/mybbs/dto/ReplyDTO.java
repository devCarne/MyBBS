package com.example.mybbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyDTO {
    int num;
    int bbs_num;
    String comments;
    String writer;
}