package com.example.mybbs;

import com.example.mybbs.dto.MyBbsDTO;
import com.example.mybbs.dto.MyBbsUserDTO;
import com.example.mybbs.service.MyBbsService;
import com.example.mybbs.service.MyBbsUserService;
import com.example.mybbs.service.ReplyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MyBbsUserService userService;

    @Autowired
    private MyBbsService bbsService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/")
    public String root() throws Exception {
        return "index";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @RequestMapping("/signUpQuery")
    public String signUpQuery(HttpServletRequest req) {
        userService.signUp(
                req.getParameter("id"),
                req.getParameter("pw"),
                req.getParameter("name")
        );
        return "index";
    }

    @RequestMapping("/signIn")
    public String signIn(HttpServletRequest req, HttpSession session, Model model) throws IOException {

        MyBbsUserDTO user = userService.signIn(req.getParameter("id"), req.getParameter("pw"));
        if (user == null) {
            return "loginError";
        } else {
            model.addAttribute("list", bbsService.getList());
            session.setAttribute("sessionName", user.getName());
            return "redirect:board";
        }
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board(HttpServletRequest req, Model model) {
        List<MyBbsDTO> list = bbsService.getList();
        model.addAttribute("list", list);
        model.addAttribute("pageQuantity", Paging(list));

        if (req.getParameter("page") == null) {
            model.addAttribute("currentPage", 1);
        } else {
            model.addAttribute("currentPage", req.getParameter("page"));
        }
        return "board";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest req, Model model) {
        String searchOption = req.getParameter("searchOption");
        String searchValue = req.getParameter("searchValue");
        List<MyBbsDTO> list = null;

        if (searchOption.equals("title")) {
            list = bbsService.searchTitle(searchValue);
        } else {
            list = bbsService.searchWriter(searchValue);
        }
        model.addAttribute("list", list);
        model.addAttribute("pageQuantity", Paging(list));
        if (req.getParameter("page") == null) {
            model.addAttribute("currentPage", 1);
        } else {
            model.addAttribute("currentPage", req.getParameter("page"));
        }
        return "board";
    }

    @RequestMapping("/write")
    public String write() {
        return "write";
    }

    @RequestMapping("/writeQuery")
    public String writeQuery(HttpServletRequest req, HttpSession session) {
        bbsService.write(
                req.getParameter("title"),
                (String) session.getAttribute("sessionName"),
                req.getParameter("content")
        );
        return "redirect:board";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(HttpServletRequest req, Model model) {
        model.addAttribute("posting", bbsService.read(Integer.parseInt(req.getParameter("num"))));
        return "read";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest req, Model model) {
        model.addAttribute("posting", bbsService.read(Integer.parseInt(req.getParameter("num"))));
        return "update";
    }

    @RequestMapping("/updateQuery")
    public String updateQuery(HttpServletRequest req) {
        bbsService.update(
                Integer.parseInt(req.getParameter("num")),
                req.getParameter("title"),
                req.getParameter("content"));
        return "redirect:board";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest req) {
        int bbs_num = Integer.parseInt(req.getParameter("num"));
        bbsService.delete(bbs_num);
        replyService.delete(bbs_num);
        return "redirect:board";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionName");
        return "redirect:/";
    }

    @RequestMapping("/reply")
    public @ResponseBody String reply(HttpServletRequest req, HttpSession session) {
        int bbs_num = Integer.parseInt(req.getParameter("bbs_num"));
        Gson gson = new Gson();

        replyService.reply(
                bbs_num,
                req.getParameter("comments"),
                (String) session.getAttribute("sessionName")
        );
        return gson.toJson(replyService.getReply(bbs_num));
    }

    @RequestMapping("/getReply")
    public @ResponseBody String getReply(HttpServletRequest req) {
        int bbs_num = Integer.parseInt(req.getParameter("bbs_num"));
        Gson gson = new Gson();

        replyService.getReply(bbs_num);

        return gson.toJson(replyService.getReply(bbs_num));
    }

    public int Paging(List<MyBbsDTO> list) {
        int OBJ_PER_PAGE = 5;
        return  (list.size() / OBJ_PER_PAGE) + 1;
    }
}
