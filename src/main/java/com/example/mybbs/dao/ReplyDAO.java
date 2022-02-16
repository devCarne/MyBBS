package com.example.mybbs.dao;

import com.example.mybbs.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyDAO {

    boolean reply(ReplyDTO reply);

    List<ReplyDTO> getReply(int bbs_num);

    boolean delete(int bbs_num);
}
