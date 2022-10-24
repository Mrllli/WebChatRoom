package com.github.l.jackson.web.chat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("/")
    public String online(HttpSession session){

        return "index.html";
    }
}
