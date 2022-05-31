package com.maiyeuem.hellospring.controller;

import com.maiyeuem.hellospring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hello")
public class HelloController {
    @GetMapping(path = "world")
    public String say() {
        return "Hello World";
    }
    @GetMapping(path = "talk")
    public String talk() {
        return "Hello World";
    }
//    @RequestMapping(path = "student", method = RequestMethod.GET)
//    public Student getStudent(){
//        return Student.builder().build();
//    }

}
