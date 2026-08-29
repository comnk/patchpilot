package com.example.demo.exploration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ExplorationController {

    @GetMapping("/explorations")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/explorations")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
