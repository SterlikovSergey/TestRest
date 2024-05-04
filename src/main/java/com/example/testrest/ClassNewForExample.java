package com.example.testrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/testNewClass")
public class ClassNewForExample {

    public ClassNewForExample() {
        System.out.println("ClassNewForExample");
    }
    public String test() {
        return "test";
    }
}
