package com.epam.demojenkinscicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MainController {
    @GetMapping()
    public String sayHello() {
        return "Hello Mother World";
    }
}
