package com.lanxiang.springmvc.rest;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanxiang.springmvc.model.Movie;

/**
 * Created by lanxiang on 2017/3/25.
 */

@Controller
@RequestMapping("/springmvc")
public class UserController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/movie")
    @ResponseBody
    public Movie movie() {
        Movie movie = new Movie(100001, "啦啦啦", new Date(), "23333");
        return movie;
    }
}
