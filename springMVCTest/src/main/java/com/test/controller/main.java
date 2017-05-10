package com.test.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.graph.Graphs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.concurrent.TimeUnit;

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

        LoadingCache<Key, Graphs> graphs = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(10, TimeUnit.MINUTES).removalListener(null).build(
                new CacheLoader<Key, Graphs>() {
                    @Override
                    public Graphs load(Key key) throws Exception {
                        return null;
                    }
                }
        );

        return "index";
    }
}
