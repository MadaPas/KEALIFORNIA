package com.kea.jymp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/bookRooms")
    public String bookRooms(){

        return "/bookRooms";
    }

}
