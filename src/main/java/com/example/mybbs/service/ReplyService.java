package com.example.mybbs.service;

import com.example.mybbs.dao.MyBbsDAO;
import com.example.mybbs.dao.ReplyDAO;
import com.example.mybbs.dto.MyBbsDTO;
import com.example.mybbs.dto.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyDAO dao;

    @Autowired
    private MyBbsDAO bbsDAO;

    public boolean reply(int bbs_num, String comments, String writer) {
        MyBbsDTO bbs = bbsDAO.read(bbs_num);
        int replyCnt = bbs.getReplyCnt();
        replyCnt++;
        bbsDAO.addReply(bbs_num, replyCnt);

        ReplyDTO dto = new ReplyDTO(replyCnt, bbs_num, comments, writer);
        return dao.reply(dto);
    }

    public List<ReplyDTO> getReply(int bbs_num) {
        return dao.getReply(bbs_num);
    }

    public boolean delete(int bbs_num) {
        return dao.delete(bbs_num);
    }
}
