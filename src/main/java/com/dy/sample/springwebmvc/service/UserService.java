package com.dy.sample.springwebmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String addPrefix(String name) {
        return "Mr. " + name;
    }
}
