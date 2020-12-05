package com.xjj.e_01_rest_service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
/*
 * Rest
 * */

@RestController
public class GreetController {

    private static final String template = "Hello, %s!";
    // 原子性，同步的Long
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @GetMapping("/greet")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hyper")
    public HttpEntity<Greeting> hyper(@RequestParam(value = "name", defaultValue = "World")
                                                  String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greeting.add(linkTo(methodOn(GreetController.class).hyper(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
