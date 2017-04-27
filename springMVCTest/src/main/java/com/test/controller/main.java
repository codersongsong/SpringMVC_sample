package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: main
 * @Description: (Description)
 * @Author: songzhengjie
 * @DATE: 2017/4/27 12:23
 */

@Controller
@RequestMapping("/main")
public class main {


    @RequestMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();

        return "index";
    }
}
