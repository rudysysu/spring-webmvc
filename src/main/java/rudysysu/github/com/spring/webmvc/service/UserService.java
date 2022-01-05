package rudysysu.github.com.spring.webmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String addPrefix(String name) {
        return "Mr. " + name;
    }
}
