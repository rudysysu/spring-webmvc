package rudysysu.github.com.spring.webmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import rudysysu.github.com.spring.webmvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import rudysysu.github.com.spring.webmvc.service.UserService;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private UserService service;
    
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        LOG.info("Home Page Requested, locale = {}", locale);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @PostMapping(value = "/user")
    public String user(@Validated User user, Model model) {
        LOG.info("User Page Requested");
        
        model.addAttribute("userName", this.service.addPrefix(user.getUserName()));
        return "user";
    }
}