package com.dy.sample.springwebmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dy.sample.springwebmvc.model.User;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        LOG.info("Home Page Requested, locale = {}", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @PostMapping(value = "/user")
    public String user(@Validated User user, Model model) {
        LOG.info("User Page Requested");
        
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
}